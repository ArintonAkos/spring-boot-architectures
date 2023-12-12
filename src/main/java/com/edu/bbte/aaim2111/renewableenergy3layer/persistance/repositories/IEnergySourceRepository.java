package com.edu.bbte.aaim2111.renewableenergy3layer.persistance.repositories;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.EnergySource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnergySourceRepository extends JpaRepository<EnergySource, Long> {
}
