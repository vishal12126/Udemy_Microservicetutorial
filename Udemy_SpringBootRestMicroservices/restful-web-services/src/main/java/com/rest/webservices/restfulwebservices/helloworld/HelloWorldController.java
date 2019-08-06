package com.rest.webservices.restfulwebservices.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
   
	@Autowired
	private MessageSource messageSource;
	//@RequestMapping(method = RequestMethod.GET, path = "/hello-world") or
	@GetMapping(path = "/hello-world")
	public String helloWorld(){
		return "Hello-world";
	}
	
	@GetMapping(path = "/hello-world1")
	public String helloWorld1(){
		return "Hello-world1";
	}
	
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean(){
		return new HelloWorldBean("Hello-world-bean");
	}
	
	@GetMapping(path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean helloWorldPathVariable(@PathVariable String name){
		return new HelloWorldBean(String.format("Hello World, %s", name));
	}
	/*
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
		return messageSource.getMessage("good.morning.message", null , locale);
	}*/
	
	//Alternate Way to above method for internationalization
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternationalized(){
		return messageSource.getMessage("good.morning.message", null ,LocaleContextHolder.getLocale());
	}
}
