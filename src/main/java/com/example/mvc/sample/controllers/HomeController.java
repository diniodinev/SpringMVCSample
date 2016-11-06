package com.example.mvc.sample.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.mvc.samle.entities.data.Project;

@Controller
public class HomeController {
	
	@RequestMapping(value = "/home")
	public String homeWithId(Model model, @ModelAttribute(value="project") Project project) {
		System.out.println("From param request handler method" + project);
		model.addAttribute("currentProject", project);
		return "home";
	}

	/*@RequestMapping(value = "/home")
	public String home(Model model) {
		Project project = new Project();
		project.setDescription("This is project sponsored by Nasa");
		project.setName("Simple Project 1");

		model.addAttribute("currentProject", project);
		return "welcome";
	}*/
}
