package com.aravinthan.covid19.unofficalModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Covid19UnofficalDetails {
	
	Covid19UnofficalData data;
	String lastRefreshed;
	String lastOriginUpdate;
	public Covid19UnofficalData getData() {
		return data;
	}
	public void setData(Covid19UnofficalData data) {
		this.data = data;
	}
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
	public Covid19UnofficalDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Covid19UnofficalDetails [data=" + data + ", lastRefreshed=" + lastRefreshed + ", lastOriginUpdate="
				+ lastOriginUpdate + "]";
	}
	
	
	

}
