package com.aravinthan.covid19.secondApiModel;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecondApiData {

	CasesTimeSeriesData cases_time_series[];
	StateWiseData statewise[];
	TestedData tested[];
	public CasesTimeSeriesData[] getCases_time_series() {
		return cases_time_series;
	}
	public void setCases_time_series(CasesTimeSeriesData[] casesTimeSeriesData) {
		this.cases_time_series = casesTimeSeriesData;
	}
	public StateWiseData[] getStatewise() {
		return statewise;
	}
	public void setStatewise(StateWiseData[] stateWiseData) {
		this.statewise = stateWiseData;
	}
	public TestedData[] getTested() {
		return tested;
	}
	public void setTested(TestedData[] testedData) {
		this.tested = testedData;
	}
	
	public SecondApiData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "SecondApiData [casesTimeSeriesData=" + Arrays.toString(cases_time_series) + ", stateWiseData="
				+ Arrays.toString(statewise) + ", testedData=" + Arrays.toString(tested) + "]";
	}
	
	
}
