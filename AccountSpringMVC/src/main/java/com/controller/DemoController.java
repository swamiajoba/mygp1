package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {
	
	@RequestMapping({"/","/home"})
	public String mydemo()
	{
		return "Demo";
	}
	
	

}
