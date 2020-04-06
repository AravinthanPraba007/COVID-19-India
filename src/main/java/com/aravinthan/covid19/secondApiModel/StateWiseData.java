package com.aravinthan.covid19.secondApiModel;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class StateWiseData {

	Integer active;
	Integer confirmed;
	Integer deaths;
	Integer deltaconfirmed;
	Integer deltadeaths;
	Integer deltarecovered;
	Date lastupdatedtime;
	Integer recovered;
	String state;
	String statecode;
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Integer getConfirmed() {
		return confirmed;
	}
	public void setConfirmed(Integer confirmed) {
		this.confirmed = confirmed;
	}
	public Integer getDeaths() {
		return deaths;
	}
	public void setDeaths(Integer deaths) {
		this.deaths = deaths;
	}
	public Integer getDeltaconfirmed() {
		return deltaconfirmed;
	}
	public void setDeltaconfirmed(Integer deltaconfirmed) {
		this.deltaconfirmed = deltaconfirmed;
	}
	public Integer getDeltadeaths() {
		return deltadeaths;
	}
	public void setDeltadeaths(Integer deltadeaths) {
		this.deltadeaths = deltadeaths;
	}
	public Integer getDeltarecovered() {
		return deltarecovered;
	}
	public void setDeltarecovered(Integer deltarecovered) {
		this.deltarecovered = deltarecovered;
	}
	public Date getLastupdatedtime() {
		return lastupdatedtime;
	}
	public void setLastupdatedtime(Date lastupdatedtime) {
		this.lastupdatedtime = lastupdatedtime;
	}
	public Integer getRecovered() {
		return recovered;
	}
	public void setRecovered(Integer recovered) {
		this.recovered = recovered;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatecode() {
		return statecode;
	}
	public void setStatecode(String statecode) {
		this.statecode = statecode;
	}
	public StateWiseData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "StateWiseData [active=" + active + ", confirmed=" + confirmed + ", deaths=" + deaths
				+ ", deltaconfirmed=" + deltaconfirmed + ", deltadeaths=" + deltadeaths + ", deltarecovered="
				+ deltarecovered + ", lastupdatedtime=" + lastupdatedtime + ", recovered=" + recovered + ", state="
				+ state + ", statecode=" + statecode + "]";
	}
	
}
