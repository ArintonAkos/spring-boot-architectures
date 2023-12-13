package com.edu.bbte.aaim2111.renewableenergy3layer;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance.EnergySourceRepository;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance.UserRepository;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository, EnergySourceRepository energySourceRepository) {
        return args -> {
            User user = userRepository.save(new User("username", "user@example.com", "password"));
            User admin = userRepository.save(new User("admin", "admin@example.com", "password"));

            EnergySource solarEnergy = new EnergySource("Solar", 1000.0, true, 1000.0, 0.55, user);
            EnergySource windEnergy = new EnergySource("Wind", 1200.0, true, 950.0, 0.75, user);
            EnergySource hydroEnergy = new EnergySource("Hydro", 899.0, true, 899.0, 0.89, admin);
            EnergySource geothermalEnergy = new EnergySource("Geothermal", 1350.0, true, 1000.0, 0.31, admin);

            energySourceRepository.save(solarEnergy);
            energySourceRepository.save(windEnergy);
            energySourceRepository.save(hydroEnergy);
            energySourceRepository.save(geothermalEnergy);
        };
    }
}