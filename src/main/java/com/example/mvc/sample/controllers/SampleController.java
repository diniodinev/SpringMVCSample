package com.example.mvc.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SampleController {

	@RequestMapping("/sample")
	public String hetInitialPage(Model model) {
		return "sample";
	}

	@RequestMapping("/expresions")
	public String expresions(Model model) {
		return "expresions";
	}

	@RequestMapping("/scriplet")
	public String scriplet(Model model) {
		return "scriplet";
	}
	
	@RequestMapping("/callJavaClass")
	public String callJavaClass(Model model) {
		return "callJavaClass";
	}
	
	@RequestMapping("/buildInRequest")
	public String buildInRequest(Model model) {
		return "buildInRequest";
	}
	
	@RequestMapping("/mainPage")
	public String mainPage(Model model) {
		return "mainPage";
	}
	
}
