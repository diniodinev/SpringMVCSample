package com.example.mvc.sample.controllers;

import java.util.ArrayList;
import java.util.Random;

import javax.validation.Valid;

import org.apache.catalina.tribes.util.UUIDGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.mvc.samle.entities.data.Project;
import com.example.mvc.samle.entities.data.services.ProjectService;
import com.example.mvc.samle.entities.validators.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService service;

	@RequestMapping(value = "/{projectId}")
	public String findbyId(final Model model, @PathVariable("projectId") Long projectId) {
		model.addAttribute("project", service.find(projectId));
		return "project";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String findProject(Model model) {
		model.addAttribute("projects", service.findAll());
		return "projects";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addProject(Model model) {
		model.addAttribute("types", new ArrayList<String>() {
			{
				add("");
				add("Single Year");
				add("Multi Year");
			}
		});
		model.addAttribute("project", new Project());
		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@Valid @ModelAttribute("project") Project project, Errors errors,
			RedirectAttributes attributes) {
		project.setProjectId(new Random().nextLong());
		if(errors.hasErrors()){
			System.out.println("There is errors");
		}
		service.addProject(project);
//		attributes.addFlashAttribute("project", project);
//		return "redirect:/home";
		return "project_add";
	}

	@InitBinder
	public void projectValidator(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}
}
