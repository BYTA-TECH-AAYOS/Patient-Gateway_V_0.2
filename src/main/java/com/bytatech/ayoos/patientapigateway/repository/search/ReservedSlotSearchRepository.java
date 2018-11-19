package com.bytatech.ayoos.patientapigateway.repository.search;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.bytatech.ayoos.patientapigateway.doctor.model.ReservedSlot;

public interface ReservedSlotSearchRepository extends ElasticsearchRepository<ReservedSlot, Long> {
	
	@Query("{\"bool\" : {\"must\" : [{\"term\" : {\"date\" : \"?0\"}},{\"term\" : {\"doctor.profileInfo.profileName\" : \"?1\"}},{\"match\" : {\"slotStatus.status\" : \"?2\"}}]}}")
	public Page<ReservedSlot> findReservedSlots( LocalDate date,String profileName,String status,Pageable pageable);
	
}
