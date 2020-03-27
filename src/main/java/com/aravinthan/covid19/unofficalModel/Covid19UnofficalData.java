package com.aravinthan.covid19.unofficalModel;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19UnofficalData {
	Covid19UnofficalDataSummary summary;
	Covid19UnofficalRawPatientData rawPatientData[];
	public Covid19UnofficalDataSummary getSummary() {
		return summary;
	}
	public void setSummary(Covid19UnofficalDataSummary summary) {
		this.summary = summary;
	}
	
	
	public Covid19UnofficalRawPatientData[] getRawPatientData() {
		return rawPatientData;
	}
	public void setRawPatientData(Covid19UnofficalRawPatientData[] rawPatientData) {
		this.rawPatientData = rawPatientData;
	}
	public Covid19UnofficalData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Covid19UnofficalData [summary=" + summary + ", rawPatientData=" + Arrays.toString(rawPatientData) + "]";
	}
	
	
	
	
	


}
