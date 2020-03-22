package com.aravinthan.covid19.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19Source {

	
	String lastRefreshed;
	String lastOriginUpdate;
	
	
	
	
	
	public String getLastRefreshed() {
		return lastRefreshed;
	}
	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}
	public String getLastOriginUpdate() {
		return lastOriginUpdate;
	}
	public void setLastOriginUpdate(String lastOriginUpdate) {
		this.lastOriginUpdate = lastOriginUpdate;
	}
	public Covid19Source() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Covid19Source [lastRefreshed=" + lastRefreshed
				+ "\n lastOriginUpdate=" + lastOriginUpdate + "]";
	}
	
	
	

}
