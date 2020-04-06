package com.aravinthan.covid19.service;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SecondApiService {

	@PostConstruct
	public void getSecondApiData() {
		System.out.println("Function for second api called--------->");
		final String secondApiUrl = "https://api.covid19india.org/data.json";
		// Hitting the API and getting the respone
				HttpHeaders headers = new HttpHeaders();
				headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
				headers.add("user-agent",
						"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
				HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
				RestTemplate restTemplate = new RestTemplate();
				ResponseEntity<String> response = restTemplate.exchange(secondApiUrl, HttpMethod.GET, entity, String.class);
				System.out.println("Second api data is -->>>"+response.getBody());
				// Storing the response in a string and doing object mapping
				
		
	}
	
}