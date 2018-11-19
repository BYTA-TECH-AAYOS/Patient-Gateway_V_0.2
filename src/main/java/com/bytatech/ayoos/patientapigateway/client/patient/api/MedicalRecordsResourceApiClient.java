package com.bytatech.ayoos.patientapigateway.client.patient.api;

import org.springframework.cloud.openfeign.FeignClient;
import com.bytatech.ayoos.patientapigateway.client.patient.ClientConfiguration;

@FeignClient(name="${patient.name:patient}", url="${patient.url:35.243.135.246:8085/}", configuration = ClientConfiguration.class)
public interface MedicalRecordsResourceApiClient extends MedicalRecordsResourceApi {
}