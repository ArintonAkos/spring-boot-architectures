package com.edu.bbte.aaim2111.renewableenergy3layer.persistance.interfaces;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.EnergySource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEnergyRepository extends JpaRepository<EnergySource, Long> {
}
