package com.bytatech.ayoos.patientapigateway.doctor.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A DoctorSessionInfo.
 */

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "doctorsessioninfov11")
public class DoctorSessionInfo {
	
	
	private Long id;

	private String sessionName;

	private LocalDate date;
	
	private ZonedDateTime startTime;

	private ZonedDateTime endTime;

	private ZonedDateTime interval;

	@ManyToOne
	@JsonIgnoreProperties("doctorSessionInfos")
	private Doctor doctor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSessionName() {
		return sessionName;
	}

	public DoctorSessionInfo sessionName(String sessionName) {
		this.sessionName = sessionName;
		return this;
	}

	public void setSessionName(String sessionName) {
		this.sessionName = sessionName;
	}

	public LocalDate getDate() {
		return date;
	}

	public DoctorSessionInfo date(LocalDate date) {
		this.date = date;
		return this;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public ZonedDateTime getStartTime() {
		return startTime;
	}

	public DoctorSessionInfo startTime(ZonedDateTime startTime) {
		this.startTime = startTime;
		return this;
	}

	public void setStartTime(ZonedDateTime startTime) {
		this.startTime = startTime;
	}

	public ZonedDateTime getEndTime() {
		return endTime;
	}

	public DoctorSessionInfo endTime(ZonedDateTime endTime) {
		this.endTime = endTime;
		return this;
	}

	public void setEndTime(ZonedDateTime endTime) {
		this.endTime = endTime;
	}

	public ZonedDateTime getInterval() {
		return interval;
	}

	public DoctorSessionInfo interval(ZonedDateTime interval) {
		this.interval = interval;
		return this;
	}

	public void setInterval(ZonedDateTime interval) {
		this.interval = interval;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public DoctorSessionInfo doctor(Doctor doctor) {
		this.doctor = doctor;
		return this;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

}
