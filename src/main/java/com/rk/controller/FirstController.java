package com.rk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FirstController {
	
	@RequestMapping("/Home.jsp")
	public ModelAndView home(){
		return new ModelAndView("Home");
		
	}
	
	@RequestMapping("/admin")
	public ModelAndView admin(){
		return new ModelAndView("Admin");
		
	}
	

}
