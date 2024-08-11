package com.sstech.mmtp.MakeMyTravelPlan;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.sstech.mmtp.MakeMyTravelPlan.Entity")
@OpenAPIDefinition
public class MakeMyTravelPlanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MakeMyTravelPlanApplication.class, args);
		System.out.println("Welcome To MMTP");
	}

}
