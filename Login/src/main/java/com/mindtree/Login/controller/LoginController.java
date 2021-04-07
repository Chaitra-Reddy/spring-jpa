package com.mindtree.Login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mindtree.Login.service.LoginService;

@Controller
public class LoginController {
	
	@Autowired
	private LoginService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@PostMapping("/logincheck")
	   public String sayHello(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		  if(service.validateUser(name, password)) {
			  return "success";
		  }
		  else {
			  return "failure";
		  }
	   }
}
