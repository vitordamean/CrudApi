package com.aula.pres.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SpringFoxConfig {

	@Bean
	public Docket swagger() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.aula.pres.resources"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API para persistência de cidades e clientes")
				.description("Um exemplo de aplicação Spring Boot REST API desenvolvido para avaliação do curso DEVTI")
				.version ("1.0.0")
				.license("Apache License Version")
				.licenseUrl("https://www.apache. licenses /LICENSE 2.0")
				.contact(new Contact("Vitor Damean", "https://github.com/vitordamean","vitor.damean@gmail.com"))
				.build();
	}

}
