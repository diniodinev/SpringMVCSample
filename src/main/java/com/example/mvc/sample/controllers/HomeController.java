package com.example.mvc.sample.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.samle.entities.data.Project;
import com.example.mvc.samle.entities.data.services.ProjectService;

@Controller
public class HomeController {

	@Autowired
	private ProjectService service;

	@RequestMapping(value = "/home", params = { "projectId" })
	public String homeWithId(Model model, @RequestParam(value = "projectId") Long projectId) {
		System.out.println("From param request handler method" + projectId);
		model.addAttribute("currentProject	", service.find(projectId));
		return "home";
	}

	@RequestMapping(value = "/home")
	public String home(Model model) {
		Project project = new Project();
		project.setDescription("This is project sponsored by Nasa");
		project.setName("Simple Project 1");

		model.addAttribute("currentProject", project);
		return "welcome";
	}
}
