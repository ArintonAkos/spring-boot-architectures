package com.edu.bbte.aaim2111.renewableenergy3layer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence")
@EnableJpaRepositories(basePackages = "com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence")
public class RenewableEnergy3LayerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RenewableEnergy3LayerApplication.class, args);
	}

}
