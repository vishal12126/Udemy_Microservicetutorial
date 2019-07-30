package com.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration file for swagger
@Configuration
//Enable Swagger
@EnableSwagger2
public class SwaggerConfig {
//Bean-docket
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2);
	}
}
