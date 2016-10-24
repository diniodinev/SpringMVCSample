package com.example.mvc.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/project")
public class ProjectController {

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String addProject() {
		return "project_add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String saveProject() {
		return "project_add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, params = { "authorized_funds=multi" })
	public String multiProject() {
		System.out.println("MultiProject");
		return "project_add";
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, params = { "authorized_funds=multi", "special" })
	public String specialProject() {
		System.out.println("MultiProject");
		return "project_add";
	}

}
