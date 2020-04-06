package com.aravinthan.covid19.secondApiModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class CasesTimeSeriesData {
	Integer dailyconfirmed;
	Integer dailydeceased;
	Integer dailyrecovered;
	String date;
	Integer totalconfirmed;
	Integer totaldeceased;
	Integer totalrecovered;
	public Integer getDailyconfirmed() {
		return dailyconfirmed;
	}
	public void setDailyconfirmed(Integer dailyconfirmed) {
		this.dailyconfirmed = dailyconfirmed;
	}
	public Integer getDailydeceased() {
		return dailydeceased;
	}
	public void setDailydeceased(Integer dailydeceased) {
		this.dailydeceased = dailydeceased;
	}
	public Integer getDailyrecovered() {
		return dailyrecovered;
	}
	public void setDailyrecovered(Integer dailyrecovered) {
		this.dailyrecovered = dailyrecovered;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Integer getTotalconfirmed() {
		return totalconfirmed;
	}
	public void setTotalconfirmed(Integer totalconfirmed) {
		this.totalconfirmed = totalconfirmed;
	}
	public Integer getTotaldeceased() {
		return totaldeceased;
	}
	public void setTotaldeceased(Integer totaldeceased) {
		this.totaldeceased = totaldeceased;
	}
	public Integer getTotalrecovered() {
		return totalrecovered;
	}
	public void setTotalrecovered(Integer totalrecovered) {
		this.totalrecovered = totalrecovered;
	}
	public CasesTimeSeriesData() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "CasesTimeSeriesData [dailyconfirmed=" + dailyconfirmed + ", dailydeceased=" + dailydeceased
				+ ", dailyrecovered=" + dailyrecovered + ", date=" + date + ", totalconfirmed=" + totalconfirmed
				+ ", totaldeceased=" + totaldeceased + ", totalrecovered=" + totalrecovered + "]";
	}
	

}
