package com.rest.webservices.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration file for swagger
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
	
	 public static final springfox.documentation.service.Contact DEFAULT_CONTACT = new Contact("", "", "");
	  public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("AWESOME Api Documentation", "Api Documentation", "1.0", "urn:tos",
	          DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<VendorExtension>());
     private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = 
    		 new HashSet<String>(Arrays.asList("application/json","application/xml"));

//Bean-docket
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2).
				apiInfo(DEFAULT_API_INFO).
				produces(DEFAULT_PRODUCES_AND_CONSUMES)
				.consumes(DEFAULT_PRODUCES_AND_CONSUMES);
	}
}