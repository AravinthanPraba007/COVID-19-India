package com.aravinthan.covid19;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Covid19Controller {
	
	@Autowired
	Covid19Service service;
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("test", "testing datas");
		model.addAttribute("gender_mapping",service.getGender_mapping());
		model.addAttribute("state_mapping",service.getState_mapping());
		model.addAttribute("status_mapping",service.getStatus_mapping());
		model.addAttribute("lastCaseReportedIn", service.getLastCaseReportedIn());
		model.addAttribute("lastRefreshed", service.getLastRefreshed());
		model.addAttribute("count", service.getCount());
		return "home";
	}
	
}
