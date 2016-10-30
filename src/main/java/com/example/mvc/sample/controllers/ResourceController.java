package com.example.mvc.sample.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvc.samle.entities.data.Resource;

@Controller
@RequestMapping("/resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		return "resource_add";
	}

	@ModelAttribute(value = "resource")
	public Resource resource() {
		return new Resource();
	}

	@ModelAttribute(value = "typeOptions")
	public List<String> options() {
		return new LinkedList<>(Arrays.asList(new String[] { "Material", "Other", "Staff", "Technical Equipment" }));
	}

	@ModelAttribute(value = "radioOptions")
	public List<String> radioOptions() {
		return new LinkedList<>(Arrays.asList(new String[] { "Hours", "Piece", "Tons" }));
	}

	@ModelAttribute(value = "checkOptions")
	public List<String> checkOptions() {
		return new LinkedList<>(Arrays.asList(new String[] { "Lead Time", "Special Rate", "Requires Approval" }));
	}

	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource) {
		System.out.println(resource);
		return "redirect:/resource/add";
	}
	
	@RequestMapping(value="/find", method = RequestMethod.GET)
	public String find(@ModelAttribute Resource resource) {
		return "resource_add";
	}
}
