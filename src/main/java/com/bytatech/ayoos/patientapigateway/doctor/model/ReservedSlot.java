package com.bytatech.ayoos.patientapigateway.doctor.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A ReservedSlot.
 */

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "reservedslotv11")
public class ReservedSlot{

    private Long id;

    private LocalDate date;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    @ManyToOne
    @JsonIgnoreProperties("reservedSlots")
    private Doctor doctor;

    @ManyToOne
    @JsonIgnoreProperties("")
    private SlotStatus slotStatus;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public ReservedSlot date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public ReservedSlot startTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public ReservedSlot endTime(ZonedDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public ReservedSlot doctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public SlotStatus getSlotStatus() {
        return slotStatus;
    }

    public ReservedSlot slotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
        return this;
    }

    public void setSlotStatus(SlotStatus slotStatus) {
        this.slotStatus = slotStatus;
    }

}
