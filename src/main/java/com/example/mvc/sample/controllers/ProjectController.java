package com.example.mvc.sample.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvc.samle.entities.data.Project;
import com.example.mvc.samle.entities.data.Resource;
import com.example.mvc.samle.entities.data.services.ProjectService;

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
	public String addProject(HttpSession session) {
		session.setAttribute("token", "12345");
		return "project_add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String saveProject(@ModelAttribute Project project) {
		System.out.println(project);
		return "project_add";
	}
}
