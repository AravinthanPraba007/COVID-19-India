package com.aravinthan.covid19.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aravinthan.covid19.secondApiModel.CasesTimeSeriesData;
import com.aravinthan.covid19.secondApiModel.SecondApiData;
import com.aravinthan.covid19.secondApiModel.StateWiseData;
import com.aravinthan.covid19.secondApiModel.TestedData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SecondApiService {
	
	@Autowired
	DateTimeHelperService dateTimeHelper;
	@Autowired
	NumberFormatHelperService numberFormat;
	
	SecondApiData secondApiSource;
	CasesTimeSeriesData yesterdayReport;
	TestedData lastTestedReport;
	List<StateWiseData> stateWiseReport =new ArrayList<StateWiseData>();
	StateWiseData todayStatus;
	CasesTimeSeriesData todayReport;
	String lastRefreshed;
	

	public String getLastRefreshed() {
		return lastRefreshed;
	}



	public SecondApiData getSecondApiSource() {
		return secondApiSource;
	}



	public CasesTimeSeriesData getYesterdayReport() {
		return yesterdayReport;
	}



	public TestedData getLastTestedReport() {
		return lastTestedReport;
	}



	public List<StateWiseData> getStateWiseReport() {
		return stateWiseReport;
	}



	public StateWiseData getTodayStatus() {
		return todayStatus;
	}



	public CasesTimeSeriesData getTodayReport() {
		return todayReport;
	}



//	@PostConstruct
	public void getSecondApiData() {
		System.out.println("Second api function is called--------->");
		final String secondApiUrl = "https://api.covid19india.org/data.json";
		// Hitting the API and getting the respone
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(secondApiUrl, HttpMethod.GET, entity, String.class);
//		System.out.println("Second api data is -->>>" + response.getBody());
		// Storing the response in a string and doing object mapping
		String json = response.getBody();
		ObjectMapper objectMapper = new ObjectMapper();
		secondApiSource = null;
		try {
			secondApiSource = objectMapper.readValue(json, SecondApiData.class);
//			System.out.println("Second api data is mapped ==" + secondApiSource);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		Getting yesterday Report from last index of cases_time_series data
		int lengthOfCasesTimeSeries=secondApiSource.getCases_time_series().length;
		secondApiSource.getCases_time_series()[lengthOfCasesTimeSeries-2].setDailyconfirmed(numberFormat.readableNumberFormat(secondApiSource.getCases_time_series()[lengthOfCasesTimeSeries-2].getDailyconfirmed()));
		yesterdayReport=secondApiSource.getCases_time_series()[lengthOfCasesTimeSeries-2];
		System.out.println("yesterday Report ==>"+yesterdayReport);
//		Getting yesterday tested repot from the last index of tested data"
		int lengthOfTested=secondApiSource.getTested().length;
		lastTestedReport=secondApiSource.getTested()[lengthOfTested-1];
		System.out.println("last tested report ==>"+lastTestedReport);
//		Getting statewise report by removing the intial index of statewise date which is today's status
		stateWiseReport.clear();
		for(int i=1;i<secondApiSource.getStatewise().length-1;i++){
			secondApiSource.getStatewise()[i].setActive(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getActive()));
			secondApiSource.getStatewise()[i].setConfirmed(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getConfirmed()));		
			secondApiSource.getStatewise()[i].setDeaths(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getDeaths()));
			secondApiSource.getStatewise()[i].setDeltaconfirmed(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getDeltaconfirmed()));
			secondApiSource.getStatewise()[i].setDeltadeaths(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getDeltadeaths()));
			secondApiSource.getStatewise()[i].setDeltarecovered(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getDeltarecovered()));
			secondApiSource.getStatewise()[i].setRecovered(numberFormat.readableNumberFormat(secondApiSource.getStatewise()[i].getRecovered()));		
			stateWiseReport.add(secondApiSource.getStatewise()[i]);
		}
		System.out.println("State wise report ==>"+stateWiseReport);
		
//		Getting todays status from first index of statewise data and convert to cases time series todayStaus=todayReport
		todayStatus=secondApiSource.getStatewise()[0];
		CasesTimeSeriesData todayReportCopy=new CasesTimeSeriesData();
		todayStatus.setDeltaconfirmed(numberFormat.readableNumberFormat(todayStatus.getDeltaconfirmed()));
		todayReportCopy.setDailyconfirmed(todayStatus.getDeltaconfirmed());
		todayStatus.setDeltadeaths(numberFormat.readableNumberFormat(todayStatus.getDeltadeaths()));
		todayReportCopy.setDailydeceased(todayStatus.getDeltadeaths());
		todayStatus.setDeltarecovered(numberFormat.readableNumberFormat(todayStatus.getDeltarecovered()));
		todayReportCopy.setDailyrecovered(todayStatus.getDeltarecovered());
		todayReportCopy.setDate(numberFormat.readableNumberFormat(todayStatus.getLastupdatedtime()));
		todayStatus.setConfirmed(numberFormat.readableNumberFormat(todayStatus.getConfirmed()));
		todayReportCopy.setTotalconfirmed(todayStatus.getConfirmed());
		todayStatus.setDeaths(numberFormat.readableNumberFormat(todayStatus.getDeaths()));
		todayReportCopy.setTotaldeceased(todayStatus.getDeaths());
		todayStatus.setRecovered(numberFormat.readableNumberFormat(todayStatus.getRecovered()));
		todayReportCopy.setTotalrecovered(todayStatus.getRecovered());
		todayStatus.setActive(numberFormat.readableNumberFormat(todayStatus.getActive()));
		todayReport=todayReportCopy;
		System.out.println("today report ==>"+todayReport);
//		Last refreshed dateTime
		lastRefreshed=DateTimeHelperService.changeDateFormatToReadableString(todayStatus.getLastupdatedtime());
		System.out.println("LastRefreshed --> "+lastRefreshed);

	}

}
