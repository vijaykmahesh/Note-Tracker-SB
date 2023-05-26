package com.seleniumexpress.notetracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class TestController {
	
	@ModelAttribute("greetings")
	public Greeting greeting() {
		
		System.out.println("inside greeting()");
		
		Greeting greeting = new Greeting();
		greeting.setMesg("Good Morning");
		greeting.setName("Abhilash");
		
		return greeting;
	}
	
	@GetMapping("/hello")
	public String sayHello(Model model) {
		
		//System.out.println("name is : " + greeting.getName());
		//System.out.println("mesg is : " + greeting.getMesg());

		System.out.println("****");
		
		return "welcome";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

//	@GetMapping("/hello")
//	public String sayHello(Model model,RedirectAttributes redirectAttributes) {
//		
//		//model.addAttribute("name", "Abhilash P");
//		
//		redirectAttributes.addFlashAttribute("name", "Abhilash P");
//		
//		return "redirect:/theRealHello";
//	}
//	
//	@GetMapping("/theRealHello")
//	public String theRealHello(Model model) {
//		
//		return "welcome";
//	}
	
	
	
	
	
	
}
