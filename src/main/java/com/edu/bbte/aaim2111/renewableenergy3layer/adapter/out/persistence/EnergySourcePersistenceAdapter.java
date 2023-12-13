package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.EnergySourcePersistencePort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class EnergySourcePersistenceAdapter implements EnergySourcePersistencePort {
    private final EnergySourceRepository repository;
    private final EnergySourceMapper mapper;

    @Autowired
    public EnergySourcePersistenceAdapter(
            EnergySourceRepository repository,
            EnergySourceMapper energySourceMapper
    ) {
        this.repository = repository;
        this.mapper = energySourceMapper;
    }

    @Override
    public EnergySource saveEnergySource(EnergySource energySource) {
        EnergySourceJpaEntity jpaEntity = mapper.energySourceToEnergySourceJpaEntity(energySource);

        jpaEntity = repository.save(jpaEntity);

        return mapper.energySourceJpaEntityToEnergySource(jpaEntity);
    }

    @Override
    public List<EnergySource> findAllEnergySources() {
        return repository.findAll().stream()
                .map(mapper::energySourceJpaEntityToEnergySource)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EnergySource> findEnergySourceById(Long id) {
        return repository.findById(id)
                .map(mapper::energySourceJpaEntityToEnergySource);
    }
}