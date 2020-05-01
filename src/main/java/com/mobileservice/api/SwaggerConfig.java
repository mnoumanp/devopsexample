package com.mobileservice.api;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("mobile-service").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build()
				.apiInfo(apiInfo());
	}

	@Bean
	public Docket otherApi() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("other-api").select()
				.apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}

	@SuppressWarnings("rawtypes")
	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("mobile-service", "Api for search related operations.",
				"Api version here", "Api terms of service subject to Company Name",
				new Contact("api@mail.com", "", ""), "License of API", "API license URL",
				new ArrayList<VendorExtension>());
		return apiInfo;
	}
}
