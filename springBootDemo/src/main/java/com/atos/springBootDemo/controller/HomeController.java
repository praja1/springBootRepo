package com.atos.springBootDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atos.springBootDemo.model.Person;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String show() {
		return "show";
	}

	@GetMapping("/showform")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return "addpersonform";
	}

	@PostMapping("/showform")
	public String greetingSubmit(@ModelAttribute Person person) {
		return "viewList";
	}
}
