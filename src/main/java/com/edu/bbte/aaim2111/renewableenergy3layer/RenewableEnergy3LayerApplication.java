package com.edu.bbte.aaim2111.renewableenergy3layer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities")
public class RenewableEnergy3LayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenewableEnergy3LayerApplication.class, args);
	}

}
