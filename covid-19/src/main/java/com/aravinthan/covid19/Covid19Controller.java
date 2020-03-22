package com.aravinthan.covid19;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Covid19Controller {
	
	@GetMapping("/")
	public String homePage(Model model) {
		model.addAttribute("test", "testing datas");
		return "home";
	}
	
}
