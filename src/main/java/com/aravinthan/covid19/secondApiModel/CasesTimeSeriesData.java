package com.aravinthan.covid19.secondApiModel;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class CasesTimeSeriesData {
	String dailyconfirmed;
	String dailydeceased;
	String dailyrecovered;
	String date;
	String totalconfirmed;
	String totaldeceased;
	String totalrecovered;
	public String getDailyconfirmed() {
		return dailyconfirmed;
	}
	public void setDailyconfirmed(String dailyconfirmed) {
		this.dailyconfirmed = dailyconfirmed;
	}
	public String getDailydeceased() {
		return dailydeceased;
	}
	public void setDailydeceased(String dailydeceased) {
		this.dailydeceased = dailydeceased;
	}
	public String getDailyrecovered() {
		return dailyrecovered;
	}
	public void setDailyrecovered(String dailyrecovered) {
		this.dailyrecovered = dailyrecovered;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTotalconfirmed() {
		return totalconfirmed;
	}
	public void setTotalconfirmed(String totalconfirmed) {
		this.totalconfirmed = totalconfirmed;
	}
	public String getTotaldeceased() {
		return totaldeceased;
	}
	public void setTotaldeceased(String totaldeceased) {
		this.totaldeceased = totaldeceased;
	}
	public String getTotalrecovered() {
		return totalrecovered;
	}
	public void setTotalrecovered(String totalrecovered) {
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
