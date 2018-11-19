package com.bytatech.ayoos.patientapigateway.doctor.model;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.data.elasticsearch.annotations.Document;

import io.swagger.annotations.ApiModelProperty;

/**
 * A Doctor.
 */

@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Document(indexName = "doctorv11")
public class Doctor{
	
	private Long id;

	private String specialisation;

	private ProfileInfo profileInfo;

	private String location;

	private ContactInfo contactInfo;

	private DoctorSettings doctorSettings;

	private Workspace workspace;

	/**
	 * A relationship
	 */
	@ApiModelProperty(value = "A relationship")
	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<DoctorSessionInfo> doctorSessionInfos = new HashSet<>();

	@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	private Set<ReservedSlot> reservedSlots = new HashSet<>();

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSpecialisation() {
		return specialisation;
	}

	public Doctor specialisation(String specialisation) {
		this.specialisation = specialisation;
		return this;
	}

	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	public ProfileInfo getProfileInfo() {
		return profileInfo;
	}

	public Doctor profileInfo(ProfileInfo profileInfo) {
		this.profileInfo = profileInfo;
		return this;
	}

	public void setProfileInfo(ProfileInfo profileInfo) {
		this.profileInfo = profileInfo;
	}

	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public Doctor contactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
		return this;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public DoctorSettings getDoctorSettings() {
		return doctorSettings;
	}

	public Doctor doctorSettings(DoctorSettings doctorSettings) {
		this.doctorSettings = doctorSettings;
		return this;
	}

	public void setDoctorSettings(DoctorSettings doctorSettings) {
		this.doctorSettings = doctorSettings;
	}

	public Workspace getWorkspace() {
		return workspace;
	}

	public Doctor workspace(Workspace workspace) {
		this.workspace = workspace;
		return this;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	public Set<DoctorSessionInfo> getDoctorSessionInfos() {
		return doctorSessionInfos;
	}

	public Doctor doctorSessionInfos(Set<DoctorSessionInfo> doctorSessionInfos) {
		this.doctorSessionInfos = doctorSessionInfos;
		return this;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Doctor addDoctorSessionInfo(DoctorSessionInfo doctorSessionInfo) {
		this.doctorSessionInfos.add(doctorSessionInfo);
		doctorSessionInfo.setDoctor(this);
		return this;
	}

	public Doctor removeDoctorSessionInfo(DoctorSessionInfo doctorSessionInfo) {
		this.doctorSessionInfos.remove(doctorSessionInfo);
		doctorSessionInfo.setDoctor(null);
		return this;
	}

	public void setDoctorSessionInfos(Set<DoctorSessionInfo> doctorSessionInfos) {
		this.doctorSessionInfos = doctorSessionInfos;
	}

	public Set<ReservedSlot> getReservedSlots() {
		return reservedSlots;
	}

	public Doctor reservedSlots(Set<ReservedSlot> reservedSlots) {
		this.reservedSlots = reservedSlots;
		return this;
	}

	public Doctor addReservedSlot(ReservedSlot reservedSlot) {
		this.reservedSlots.add(reservedSlot);
		reservedSlot.setDoctor(this);
		return this;
	}

	public Doctor removeReservedSlot(ReservedSlot reservedSlot) {
		this.reservedSlots.remove(reservedSlot);
		reservedSlot.setDoctor(null);
		return this;
	}

	public void setReservedSlots(Set<ReservedSlot> reservedSlots) {
		this.reservedSlots = reservedSlots;
	}

}
