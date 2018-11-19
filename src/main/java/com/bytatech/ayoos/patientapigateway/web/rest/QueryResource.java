package com.bytatech.ayoos.patientapigateway.web.rest;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Metrics;
import org.springframework.data.geo.Point;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bytatech.ayoos.patientapigateway.client.patient.api.CityResourceApi;
import com.bytatech.ayoos.patientapigateway.client.patient.api.CountryResourceApi;
import com.bytatech.ayoos.patientapigateway.client.patient.api.StateResourceApi;
import com.bytatech.ayoos.patientapigateway.client.patient.model.CityDTO;
import com.bytatech.ayoos.patientapigateway.client.patient.model.CountryDTO;
import com.bytatech.ayoos.patientapigateway.client.patient.model.StateDTO;
import com.bytatech.ayoos.patientapigateway.doctor.model.Doctor;
import com.bytatech.ayoos.patientapigateway.doctor.model.ReservedSlot;
import com.bytatech.ayoos.patientapigateway.repository.search.DoctorSearchRepository;
import com.bytatech.ayoos.patientapigateway.repository.search.ReservedSlotSearchRepository;
import com.codahale.metrics.annotation.Timed;

@RestController
@RequestMapping("/api/query")
public class QueryResource {

	@Autowired
	CountryResourceApi countryResourceApi;
	
	@Autowired
	StateResourceApi stateResourceApi;
	
	@Autowired
	CityResourceApi cityResourceApi;	
	
	@Autowired
	DoctorSearchRepository doctorSearchRepository;
	
	@Autowired
	ReservedSlotSearchRepository reservedSlotSearchRepository;

	@GetMapping("/_search/countries")
	@Timed
	public ResponseEntity<List<CountryDTO>> searchCountries(@RequestParam(required = false) Long offset,
			@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer pageNumber,
			@RequestParam(required = false) Integer pageSize, @RequestParam(required = false) Boolean paged,
			@RequestParam(required = false) Integer size,
			@RequestParam(value = "sort", required = false) List<String> sort,
			@RequestParam(required = false) Boolean sortSorted, @RequestParam(required = false) Boolean sortUnsorted,
			@RequestParam(required = false) Boolean unpaged) {
		return countryResourceApi.getAllCountriesUsingGET(offset, page, pageNumber, pageSize, paged, size, sort,
				sortSorted, sortUnsorted, unpaged);
	}

	
	@GetMapping("/_search/states/findByCountryName")
	@Timed
	public ResponseEntity<List<StateDTO>> getAllStatesByCountryName(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long offset, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Boolean paged, @RequestParam(required = false) Integer size,
			@RequestParam(value = "sort", required = false) List<String> sort,
			@RequestParam(required = false) Boolean sortSorted, @RequestParam(required = false) Boolean sortUnsorted,
			@RequestParam(required = false) Boolean unpaged) {
		return stateResourceApi.getAllStatesByCountryNameUsingGET(name, offset, page, pageNumber, pageSize, paged, size,
				sort, sortSorted, sortUnsorted, unpaged);
	}
	
	@GetMapping("/_search/cities/findByStateName")
	@Timed
	public ResponseEntity<List<CityDTO>> getAllCitiesByStateName(@RequestParam(required = false) String name,
			@RequestParam(required = false) Long offset, @RequestParam(required = false) Integer page,
			@RequestParam(required = false) Integer pageNumber, @RequestParam(required = false) Integer pageSize,
			@RequestParam(required = false) Boolean paged, @RequestParam(required = false) Integer size,
			@RequestParam(value = "sort", required = false) List<String> sort,
			@RequestParam(required = false) Boolean sortSorted, @RequestParam(required = false) Boolean sortUnsorted,
			@RequestParam(required = false) Boolean unpaged) {
		return cityResourceApi.getAllCitiesByStateNameUsingGET(name, offset, page, pageNumber, pageSize, paged, size,
				sort, sortSorted, sortUnsorted, unpaged);
	}
	
	@GetMapping("/_search/doctors")
	public Page<Doctor> getAllDoctors(Pageable pageable) {
		return doctorSearchRepository.findAll(pageable);
	}

	@GetMapping("/_search/doctors/findByNearByLocation/{lat}/{lon}/{distance}/{unit}")
	public Page<Doctor> getNearByDoctors(@PathVariable String lat, @PathVariable String lon,
			@PathVariable String distance, @PathVariable String unit, Pageable pageable) {
		Point point = new Point(Double.parseDouble(lat), Double.parseDouble(lon));

		Distance value = new Distance(Double.parseDouble(distance), Metrics.valueOf(unit));
		return doctorSearchRepository.findByLocationNear(point, value, pageable);
	}

	@GetMapping("/_search/reservedSlots/{date}/{profileName}/{status}")
	public Page<ReservedSlot> getReservedSlots(@PathVariable LocalDate date, @PathVariable String profileName,
			@PathVariable String status, Pageable pageable) {

		return reservedSlotSearchRepository.findReservedSlots(date, profileName, status, pageable);
	}
	
}
