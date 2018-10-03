package com.punctualpanda.punctualpanda;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {
	
	@RequestMapping("/welcome")
	public String blankone(Map<String, Object> model){
		System.out.println("blankone is called!!");
		return "welcomeView";
	}
	
	@RequestMapping("/hello")
	public String hello(Map<String, Object> model){
		System.out.println("hello function is called!!");
		return "hello"; 
	}
}
