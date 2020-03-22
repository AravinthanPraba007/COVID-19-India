package com.aravinthan.covid19;


import java.io.IOException;
import java.util.Arrays;

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
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class Covid19Service {
	
	@PostConstruct
	@Scheduled(cron = "0 */1 * * * *")
	public  Covid19UnofficalDetails getUnoffical() {
		System.out.println("hello getTotalCount");
		final String url = "https://api.rootnet.in/covid19-in/unofficial/covid19india.org";
		 HttpHeaders headers = new HttpHeaders();
	        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        RestTemplate restTemplate = new RestTemplate();
	        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	     
	    System.out.println(response.getBody());
	    String json=response.getBody();
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    Covid19UnofficalDetails source;
		try {
			source = objectMapper.readValue(json, Covid19UnofficalDetails.class);
			System.out.println("=="+source);
		    return source;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return null;
	}
	
	
}
