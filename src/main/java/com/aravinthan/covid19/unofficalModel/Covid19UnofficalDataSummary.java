package com.aravinthan.covid19.unofficalModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19UnofficalDataSummary {
	String total;

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	

	public Covid19UnofficalDataSummary() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Covid19UnofficalSummary [total=" + total + "]";
	}
	

}
