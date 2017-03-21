package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@SpringBootApplication
@RibbonClient(name="say-hello",configuration=SayHelloConfiguration.class)
public class RibbonClientApplication {
	
	@Bean
	@LoadBalanced
	RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
	@RequestMapping("/hi")
	public String hi(@RequestParam(value="name",defaultValue="sharath")String name){
		String greeting = this.restTemplate.getForObject("http://say-hello/greeting",String.class);
		return greeting;
	}
	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}
}
