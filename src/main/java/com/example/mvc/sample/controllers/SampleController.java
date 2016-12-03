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

}
