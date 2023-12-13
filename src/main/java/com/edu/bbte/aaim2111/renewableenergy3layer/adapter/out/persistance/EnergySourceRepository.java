package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergySourceRepository extends JpaRepository<EnergySource, Long> {
}
