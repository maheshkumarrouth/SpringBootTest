package com.cultuzz.de;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	@Autowired
	private TestDAOService testDAOService;
	@RequestMapping("/hello")
	public String sayHai(){
		System.out.println("testDAOService"+testDAOService.findAllData().size());
		return "Hai";
	}
}
