package com.seleniumexpress.notetracker.controllers;

public class Greeting {
	
	private String name;
	private String mesg;
	
	public Greeting() {
		
		System.out.println("inside greetings contr");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}
	
	

}
