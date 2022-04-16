package com.bits.cpad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MyCricketProfileWeb {

	public static void main(String[] args) {
		SpringApplication.run(MyCricketProfileWeb.class, args);
	}
	
	@GetMapping(path = "/")
	public String test() {
		return "Working!!";
	}

}
