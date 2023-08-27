package com.selenium.autotest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/")
public class CommandController {

	@RequestMapping(value="/hello")
	public String hello() {
		return "Hello world RESTful with Spring boot!!";
	}
}
