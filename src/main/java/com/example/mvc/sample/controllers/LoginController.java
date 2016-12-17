package com.example.mvc.sample.controllers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.mvc.samle.entities.data.Category;

import com.example.mvc.samle.entities.data.LoginForm;

@Controller
public class LoginController {

	@ModelAttribute
	public void getFormParams(Model model) {
		List<String> companyNames = Arrays.asList(new String[] { "Datex", "EPAM", "T-Systems", "EGAM" });
		model.addAttribute("companyNames", companyNames);

		Category progLang = new Category("Programing", "Programing Languages");
		progLang.setParts(Arrays.asList(new String[] { "Java", "Go", "C#", "C++" }));

		Category hobies = new Category("Hobies", "Outdoors");
		hobies.setParts(Arrays.asList(new String[] { "Hating", "Rafting", "Skiing", "Boxing" }));

		List<Category> categories = new LinkedList<>();
		categories.add(progLang);
		categories.add(hobies);

		model.addAttribute("categs", categories);

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(@ModelAttribute(value = "loginForm") LoginForm loginForm, BindingResult result) {

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(@ModelAttribute(value = "loginForm") LoginForm loginForm, BindingResult result) {

		return "redirect:confirmlogin";
	}

}
