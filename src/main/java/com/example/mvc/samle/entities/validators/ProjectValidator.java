package com.example.mvc.samle.entities.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.mvc.samle.entities.data.Project;

public class ProjectValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Project.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Project project = (Project) target;
		if (project.getName().length() < 5) {
			errors.rejectValue("name", "project.name.short");
		}
	}
}
