package com.aravinthan.covid19.secondApiModel;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecondApiData {

	CasesTimeSeriesData casesTimeSeriesData[];
	StateWiseData stateWiseData[];
	TestedData testedData[];
	public CasesTimeSeriesData[] getCasesTimeSeriesData() {
		return casesTimeSeriesData;
	}
	public void setCasesTimeSeriesData(CasesTimeSeriesData[] casesTimeSeriesData) {
		this.casesTimeSeriesData = casesTimeSeriesData;
	}
	public StateWiseData[] getStateWiseData() {
		return stateWiseData;
	}
	public void setStateWiseData(StateWiseData[] stateWiseData) {
		this.stateWiseData = stateWiseData;
	}
	public TestedData[] getTestedData() {
		return testedData;
	}
	public void setTestedData(TestedData[] testedData) {
		this.testedData = testedData;
	}
	public SecondApiData(CasesTimeSeriesData[] casesTimeSeriesData, StateWiseData[] stateWiseData,
			TestedData[] testedData) {
		super();
		this.casesTimeSeriesData = casesTimeSeriesData;
		this.stateWiseData = stateWiseData;
		this.testedData = testedData;
	}
	@Override
	public String toString() {
		return "SecondApiData [casesTimeSeriesData=" + Arrays.toString(casesTimeSeriesData) + ", stateWiseData="
				+ Arrays.toString(stateWiseData) + ", testedData=" + Arrays.toString(testedData) + "]";
	}
	
	
}
