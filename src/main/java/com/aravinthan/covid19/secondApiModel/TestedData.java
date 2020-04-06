package com.aravinthan.covid19.secondApiModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class TestedData {
	
	Integer totalpositivecases;
	Integer totalsamplestested;
	String updatetimestamp;
	public Integer getTotalpositivecases() {
		return totalpositivecases;
	}
	public void setTotalpositivecases(Integer totalpositivecases) {
		this.totalpositivecases = totalpositivecases;
	}
	public Integer getTotalsamplestested() {
		return totalsamplestested;
	}
	public void setTotalsamplestested(Integer totalsamplestested) {
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
