package com.example.mvc.sample.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

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

import com.example.mvc.samle.entities.data.City;
import com.example.mvc.samle.entities.data.Country;
import com.example.mvc.samle.entities.data.Project;
import com.example.mvc.samle.entities.data.services.ProjectService;
import com.example.mvc.samle.entities.validators.ProjectValidator;

@Controller
@RequestMapping("/project")
public class ProjectController {
	@Autowired
	ProjectService service;

	@ModelAttribute
	public void init(Model model) {
		List<Country> countries = new ArrayList<>();
		Country bulgaria = new Country("Bulgaria");
		Country russia = new Country("Russia");
		russia.add(new City("Sevastopol"));
		bulgaria.add(new City("Sofia"));
		bulgaria.add(new City("Pleven"));
		bulgaria.add(new City("Ruse"));
		countries.add(bulgaria);
		countries.add(russia);
		
		List<String> favLanguage = new ArrayList<>();
		favLanguage.add("Java");
		favLanguage.add("C++");
		favLanguage.add("C#");
		favLanguage.add("Go");
		favLanguage.add("Scala");
		favLanguage.add("Groovy");
		
		model.addAttribute("inputCountries", countries);
		model.addAttribute("favLanguage", favLanguage);
	}

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
	public String addProject(@ModelAttribute Project project, Model model) {
		model.addAttribute("types", new ArrayList<String>() {
			{
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
		
		System.out.println(project);
		project.setProjectId(new Random().nextLong());
		if (errors.hasErrors()) {
			System.out.println("There is errors");
		}
		service.addProject(project);
		// attributes.addFlashAttribute("project", project);
		// return "redirect:/home";
		return "project_add";
	}

	@InitBinder
	public void projectValidator(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}
}
