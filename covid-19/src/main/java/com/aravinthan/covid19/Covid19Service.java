package com.aravinthan.covid19;


import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeMap;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aravinthan.covid19.unofficalModel.Covid19UnofficalDetails;
import com.aravinthan.covid19.unofficalModel.Covid19UnofficalRawPatientData;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class Covid19Service {
	



	
	private Covid19UnofficalDetails source; 	
	
//	State based Case count
	HashMap<String, Integer> state_mapping= new HashMap<String, Integer>();
//	Gender based Case Count
	HashMap<String, Integer> gender_mapping= new HashMap<String, Integer>();
//	Reported date based Case Count
	Map<Date, Integer> reportedDate_mapping= new TreeMap<Date, Integer>(Collections.reverseOrder());
//	Status based Case Count
	Map<String, Integer> status_mapping= new TreeMap<String, Integer>();

	
	String lastRefreshed;
	String lastOriginUpdate;
	String lastCaseReportedIn;
	
	String updated;
	
	
	Integer count=0;
	public Integer getCount() {
		return count;
	}
	
	
	
//	Getters

	public Covid19UnofficalDetails getSource() {
		return source;
	}

	public HashMap<String, Integer> getState_mapping() {
		return state_mapping;
	}

	public HashMap<String, Integer> getGender_mapping() {
		return gender_mapping;
	}

	public Map<Date, Integer> getReportedDate_mapping() {
		return reportedDate_mapping;
	}

	public Map<String, Integer> getStatus_mapping() {
		return status_mapping;
	}

	public String getLastRefreshed() {
		return lastRefreshed;
	}

	public String getLastOriginUpdate() {
		return lastOriginUpdate;
	}

	public String getLastCaseReportedIn() {
		return lastCaseReportedIn;
	}


//	Spring execute this function when the bean for this service is created
//  Spring schedule allows to load this function every 50 seconds	
	@PostConstruct
	@Scheduled(cron = "0 */3 * * * *")
	public void getUnoffical() throws Exception {
		System.out.println("Service being executed");
		count++;
		
//		Api URL
		final String url = "https://api.rootnet.in/covid19-in/unofficial/covid19india.org";

//		Clearing the map on every loading
		state_mapping.clear();
		gender_mapping.clear();
		reportedDate_mapping.clear();
		status_mapping.clear();
		
		
		
//		Hitting the API and getting the respone
		 HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	        
//	    Storing the response in a string and doing object mapping 
	    System.out.println(response.getBody());
	    String json=response.getBody();
	    ObjectMapper objectMapper = new ObjectMapper();
	    source = null;
		try {
			source = objectMapper.readValue(json, Covid19UnofficalDetails.class);
			System.out.println("=="+source);
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("---->>Extracting patients Details<<<<------");
		Covid19UnofficalRawPatientData[] patientsData;
		patientsData=source.getData().getRawPatientData();
		
//		Processing the obtained data
		
//		Adding the total count to the Status count mapping
		Integer total=Integer.parseInt(source.getData().getSummary().getTotal());
		status_mapping.put("Total",total);
		
//		Iterating the data and taking the case count on different bases
		for(Covid19UnofficalRawPatientData patientData:patientsData){
			
//			Mapping the cases based on state
//			System.out.println(patientData.getState());
			String state=patientData.getState();
			boolean isStatePresent = state_mapping.containsKey(state);
			if(!isStatePresent)
			state_mapping.put(state,1);
			else
			state_mapping.replace(state, state_mapping.get(state)+1);
			
//			Mapping the cases based on gender
//			System.out.println(patientData.getGender());
			String gender=patientData.getGender();
			boolean isGenderPresent = gender_mapping.containsKey(gender);
			if(!isGenderPresent)
			gender_mapping.put(gender,1);
			else
			gender_mapping.replace(gender, gender_mapping.get(gender)+1);
			
//			Mapping the cases based on reported date
//			System.out.println(patientData.getReportedOn());
			String date=patientData.getReportedOn();
			Date reportedDate=new SimpleDateFormat("dd/MM/yyyy").parse(date);
			boolean isReportedDatePresent = reportedDate_mapping.containsKey(reportedDate);
			if(!isReportedDatePresent)
				reportedDate_mapping.put(reportedDate,1);
			else
				reportedDate_mapping.replace(reportedDate, reportedDate_mapping.get(reportedDate)+1);
			
//			Mapping the cases based on status
//			System.out.println(patientData.getStatus());
			String status=patientData.getStatus();
			boolean isStatusPresent = status_mapping.containsKey(status);
			if(!isStatusPresent)
				status_mapping.put(status,1);
			else
				status_mapping.replace(status, status_mapping.get(status)+1);
			
		}
		
		
//		Sorting the map based on case count
		state_mapping=(HashMap<String, Integer>) sortByValue(state_mapping);
		gender_mapping=(HashMap<String, Integer>) sortByValue(gender_mapping);
		status_mapping=sortByValue(status_mapping);
		
		System.out.println("==>"+state_mapping);
		System.out.println("==>"+gender_mapping);
		System.out.println("==>"+status_mapping);
		
		lastRefreshed=source.getLastRefreshed();
		lastOriginUpdate=source.getLastOriginUpdate();
		lastCaseReportedIn=patientsData[total-1].getState();
	    
//		Coverting into IST time
	    lastRefreshed=changeDateTimeToIST(lastRefreshed);
	    lastOriginUpdate=changeDateTimeToIST(lastOriginUpdate);
		
		System.out.println("Last Refreshed: "+lastRefreshed);
		System.out.println("Last origin Update: "+lastOriginUpdate);
		System.out.println("Last case reported in: "+lastCaseReportedIn);
		System.out.println("updated time: "+updated);
		System.out.println("count="+count);
	    
	}
	public static String changeDateTimeToIST(String dateTime) throws ParseException {
		 DateFormat utcFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
         utcFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
         Date utcTime = utcFormat.parse(dateTime);
         

         DateFormat localFormat = new SimpleDateFormat("EEE, dd MMMM yyyy' at 'hh:mm aa");
         localFormat.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
         System.out.println("Localtime -----> " + localFormat.format(utcTime));
         return localFormat.format(utcTime);
		
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
		List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			@Override
			public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
				return (e1.getValue()).compareTo(e2.getValue());
			}
		});
		Collections.reverse(list);
		Map<K, V> result = new LinkedHashMap<>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
	 
		return result;
	}
	
	
}