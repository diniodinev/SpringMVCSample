package com.example.mvc.sample.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.mvc.samle.entities.data.Resource;

@Controller
@RequestMapping("/resource")
@SessionAttributes("resource")
public class ResourceController {

	@RequestMapping("/add")
	public String add(Model model) {
		System.out.println("Invoce add method handler");
		if(1==1){
			throw new RuntimeException("Custom runtime");
		}
		return "resource_add";
	}

	@RequestMapping("/review")
	public String review(@ModelAttribute Resource resource) {
		System.out.println("Call review jsp");
		return "resource_review";
	}

	@RequestMapping("/request")
	@ResponseBody
	public String request(@ModelAttribute Resource resource) {
		return "The request has been approived.";
	}

	@ExceptionHandler(NullPointerException.class)
	public String errorHandler() {
		return "controller_error";
		
	}
	@RequestMapping("/save")
	public String save(@ModelAttribute Resource resource, SessionStatus status) {
		System.out.println("Invoke Save");
		System.out.println(resource);
		status.setComplete();
		return "redirect:/resource/add";
	}

	@RequestMapping(value = "/find", method = RequestMethod.GET)
	public String find(@ModelAttribute Resource resource) {
		System.out.println("Find in resource Controller.");
		return "resource_add";
	}

	@ModelAttribute(value = "resource")
	public Resource resource() {
		System.out.println("Add resource to the model");
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

}
