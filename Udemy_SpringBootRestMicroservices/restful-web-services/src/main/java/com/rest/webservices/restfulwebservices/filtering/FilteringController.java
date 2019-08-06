package com.rest.webservices.restfulwebservices.filtering;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {

	@GetMapping(path ="/filter")
	public SomeBean retrieveSomeBean(){
		return new SomeBean("values1","value2","values3");
	}
	
	//dynamic filtering
	@GetMapping(path ="/filtering")
	public MappingJacksonValue retrieveSomeBeanDynamic(){
		SomeBean someBean = new SomeBean("values1","value2","values3");
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("someBean", filter);
		 MappingJacksonValue mapping =  new MappingJacksonValue(someBean);
		 mapping.setFilters(filters);
		return mapping;
	}
	
}
