package com.example.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class BourseRestService {
	
	@Value("${me}")
	private String mess;
	
	@RequestMapping("/messages")
	String tellMe() {
		System.out.println("-------c moi qui répond-------");
		return mess;
	}
	
}
