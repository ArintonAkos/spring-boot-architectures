package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.EnergySourcePersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EnergySourcePersistenceAdapter implements EnergySourcePersistencePort {
    private final EnergySourceRepository repository;

    @Autowired
    public EnergySourcePersistenceAdapter(EnergySourceRepository repository) {
        this.repository = repository;
    }

    @Override
    public EnergySource saveEnergySource(EnergySource energySource) {
        return repository.save(energySource);
    }

    @Override
    public List<EnergySource> findAllEnergySources() {
        return repository.findAll();
    }

    @Override
    public Optional<EnergySource> findEnergySourceById(Long id) {
        return repository.findById(id);
    }
}