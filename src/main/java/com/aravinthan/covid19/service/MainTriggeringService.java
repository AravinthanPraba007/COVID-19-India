package com.aravinthan.covid19.service;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class MainTriggeringService {

	@Autowired
	SecondApiService secondApiService;
	@PostConstruct
	@Scheduled(cron = "0 */3 * * * *")
	public void getStarted(){
		secondApiService.getSecondApiData();
	}
}
