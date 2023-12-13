package com.edu.bbte.aaim2111.renewableenergy3layer;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence.EnergySourceJpaEntity;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence.EnergySourceRepository;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence.UserJpaEntity;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, EnergySourceRepository energySourceRepository) {
        return args -> {
            UserJpaEntity user = userRepository.save(new UserJpaEntity("username", "user@example.com", "password"));
            UserJpaEntity admin = userRepository.save(new UserJpaEntity("admin", "admin@example.com", "password"));

            EnergySourceJpaEntity solarEnergy = new EnergySourceJpaEntity("Solar", 1000.0, true, 1000.0, 0.55, user);
            EnergySourceJpaEntity windEnergy = new EnergySourceJpaEntity("Wind", 1200.0, true, 950.0, 0.75, user);
            EnergySourceJpaEntity hydroEnergy = new EnergySourceJpaEntity("Hydro", 899.0, true, 899.0, 0.89, admin);
            EnergySourceJpaEntity geothermalEnergy = new EnergySourceJpaEntity("Geothermal", 1350.0, true, 1000.0, 0.31, admin);

            energySourceRepository.save(solarEnergy);
            energySourceRepository.save(windEnergy);
            energySourceRepository.save(hydroEnergy);
            energySourceRepository.save(geothermalEnergy);
        };
    }
}