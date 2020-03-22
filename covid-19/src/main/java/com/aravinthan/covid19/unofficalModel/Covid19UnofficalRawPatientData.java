package com.aravinthan.covid19.unofficalModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19UnofficalRawPatientData {
	String reportedOn;
	String ageEstimate;
	String gender;
	String state;
	String status;
	public String getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(String reportedOn) {
		this.reportedOn = reportedOn;
	}
	public String getAgeEstimate() {
		return ageEstimate;
	}
	public void setAgeEstimate(String ageEstimate) {
		this.ageEstimate = ageEstimate;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Covid19UnofficalRawPatientData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Covid19UnofficalRawPatientData [reportedOn=" + reportedOn + ", ageEstimate=" + ageEstimate + ", gender="
				+ gender + ", state=" + state + ", status=" + status + "]";
	}
	
	
	
	

}
