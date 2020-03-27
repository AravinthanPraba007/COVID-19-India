package com.aravinthan.covid19;

import java.text.NumberFormat;

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
		NumberFormat myFormat = NumberFormat.getInstance();
		model.addAttribute("test", "testing datas");
		model.addAttribute("gender_mapping",service.getGender_mapping());
		model.addAttribute("state_mapping",service.getState_mapping());
		model.addAttribute("status_mapping",service.getStatus_mapping());
		model.addAttribute("lastCaseReportedIn", service.getLastCaseReportedIn());
		model.addAttribute("lastRefreshed", service.getLastRefreshed());
		model.addAttribute("count", service.getCount());
		model.addAttribute("todayCount", myFormat.format(service.getTodayCount()));
		model.addAttribute("yesterdayCount", myFormat.format(service.getYesterdayCount()));
		model.addAttribute("growthRate", service.getGrowthRate());
		model.addAttribute("current", myFormat.format(service.getCurrent()));
		model.addAttribute("next7", myFormat.format(service.getNext7()));
		model.addAttribute("next15", myFormat.format(service.getNext15()));
		model.addAttribute("next30", myFormat.format(service.getNext30()));
		model.addAttribute("collapsedError", service.isCollapsedError());
		model.addAttribute("collapsedErrorMsg", service.getCollapsedErrorMsg() );
		return "home";
	}
	
}
