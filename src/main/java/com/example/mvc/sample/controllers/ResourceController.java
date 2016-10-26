package com.example.mvc.sample.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.mvc.samle.entities.data.Resource;

@Controller
@RequestMapping(value = "/resource")
public class ResourceController {

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addResource(Model model) {
		List<String> options = new ArrayList<>(Arrays.asList(new String[] { "First", "Second", "Thrid", "Fourth" }));
		model.addAttribute("resource", new Resource());
		model.addAttribute("optionsType", options);
		return "resource_add";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveResource(@ModelAttribute Resource resource) {
		System.out.println(resource);
		return "resource_add";
	}

}
