package com.example.demo.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	
	@RequestMapping(value = "welcome")
	public String welcome() {
		return "welcome";
	}
	
	@RequestMapping(value = "modaltest")
	public String modalTest() {
		return "tests/modaltest";
	}
}
