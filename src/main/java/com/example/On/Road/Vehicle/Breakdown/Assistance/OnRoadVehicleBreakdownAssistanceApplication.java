package com.example.On.Road.Vehicle.Breakdown.Assistance;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@EnableSwagger2
@SpringBootApplication
//@ComponentScan(basePackageClasses = {OnRoadVehicleBreakdownAssistanceApplication.class})
public class OnRoadVehicleBreakdownAssistanceApplication {
	final static Logger Log = LoggerFactory.getLogger(OnRoadVehicleBreakdownAssistanceApplication.class);

	public static void main(String[] args) {
		Log.info("application running successfully........");
		SpringApplication.run(OnRoadVehicleBreakdownAssistanceApplication.class, args);

	}
	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.On.Road.Vehicle.Breakdown.Assistance")).build();
	}
	// http://localhost:8083/swagger-ui.html#/

}
