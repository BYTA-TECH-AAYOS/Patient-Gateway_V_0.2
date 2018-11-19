package com.bytatech.ayoos.patientapigateway.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bytatech.ayoos.patientapigateway.client.patient.api.CityResourceApi;
import com.bytatech.ayoos.patientapigateway.client.patient.api.CountryResourceApi;
import com.bytatech.ayoos.patientapigateway.client.patient.api.StateResourceApi;
import com.bytatech.ayoos.patientapigateway.client.patient.model.CityDTO;
import com.bytatech.ayoos.patientapigateway.client.patient.model.CountryDTO;
import com.bytatech.ayoos.patientapigateway.client.patient.model.StateDTO;
import com.codahale.metrics.annotation.Timed;

public class QueryResource {

	@Autowired
	CountryResourceApi countryResourceApi;
	
	
	@Autowired
	StateResourceApi stateResourceApi;
	
	@Autowired
	CityResourceApi cityResourceApi;	
	

	@GetMapping("/countries")
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

	
	@GetMapping("/states/findByCountryName")
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
	
	@GetMapping("/cities/findByStateName")
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
}
