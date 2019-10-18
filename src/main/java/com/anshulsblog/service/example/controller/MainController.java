package com.anshulsblog.service.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	private String message = "Hello Friends!! Welcome to the world of Spring Boot.";
	 
	 @RequestMapping("/welcome")
	 public String welcome(ModelMap model) {
	  model.addAttribute("message", this.message);
	  return "welcome";
	 }

}
