package com.bhagyesh.spring.boot.springbootjwt.controller;

import javax.swing.text.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/home")
	   public String welcome(Model model) {
		  return "home";
	   }
	
}
