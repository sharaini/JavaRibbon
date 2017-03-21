package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class HelloServiceApplication {

	private static Logger log = LoggerFactory.getLogger(HelloServiceApplication.class);

	@RequestMapping(value = "/greeting")
	public String greet(){
		return "hello from service 3";
	}
	@RequestMapping(value = "/")
	public String home() {
	    log.info("Access /");
	    return "Hi!";
	  }
	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApplication.class, args);
	}
}
