package com.aravinthan.covid19.secondApiModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestedData {
	
	String totalpositivecases;
	String totalsamplestested;
	String updatetimestamp;
	public String getTotalpositivecases() {
		return totalpositivecases;
	}
	public void setTotalpositivecases(String totalpositivecases) {
		this.totalpositivecases = totalpositivecases;
	}
	public String getTotalsamplestested() {
		return totalsamplestested;
	}
	public void setTotalsamplestested(String totalsamplestested) {
		this.totalsamplestested = totalsamplestested;
	}
	public String getUpdatetimestamp() {
		return updatetimestamp;
	}
	public void setUpdatetimestamp(String updatetimestamp) {
		this.updatetimestamp = updatetimestamp;
	}
	public TestedData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "TestedData [totalpositivecases=" + totalpositivecases + ", totalsamplestested=" + totalsamplestested
				+ ", updatetimestamp=" + updatetimestamp + "]";
	}
	
	

}
