package com.healthhubapi.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.amazonaws.services.appstream.model.Application;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.*;

@EnableSwagger2
@EnableScheduling
@SpringBootApplication
public class HealthHubApplication   {

     

    @Autowired
    private Environment environment;

    

    public static void main(String[] args) {
    	System.out.println(" Step 0 ");
        SpringApplication.run(HealthHubApplication.class, args);
    }
    
    
     
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

	/*
	 * @Bean BCryptPasswordEncoder passwordEncoder() {
	 * System.out.println(" Step 3 "); return new BCryptPasswordEncoder(); }
	 */
     
    public Docket api() {
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metadata())
                .useDefaultResponseMessages(false)
                .securitySchemes(new ArrayList<>(Arrays.asList(new ApiKey("Bearer %token", "Authorization", "Header"))))//
                .genericModelSubstitutes(Optional.class);
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()//
                .title("Catrion Backend API")
                .version("1.0.0")
                .build();
    }

    
}
