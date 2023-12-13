package com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;

import java.util.List;
import java.util.Optional;

public interface EnergySourcePersistencePort {
    EnergySource saveEnergySource(EnergySource energySource);
    List<EnergySource> findAllEnergySources();
    Optional<EnergySource> findEnergySourceById(Long id);
}