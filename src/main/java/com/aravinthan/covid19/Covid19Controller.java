package com.aravinthan.covid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aravinthan.covid19.service.SecondApiService;

@Controller
public class Covid19Controller {


	
	@Autowired
	SecondApiService secondApiService;
	
	@GetMapping("/")
	public String homePageTesting(Model model) {
		
		model.addAttribute("yesterdayReport", secondApiService.getYesterdayReport());
		model.addAttribute("todayReport", secondApiService.getTodayReport());
		model.addAttribute("todayStatus", secondApiService.getTodayStatus());
		model.addAttribute("stateWiseReport", secondApiService.getStateWiseReport());
		model.addAttribute("lastRefreshed", secondApiService.getLastRefreshed());
		return "homePage";
	}

}
