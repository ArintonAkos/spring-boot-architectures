package com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.services;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.EnergySourcePersistencePort;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.UserPersistencePort;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.EnergySourceDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance.EnergySourceMapper;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in.EnergySourceServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnergySourceServiceImpl implements EnergySourceServicePort {
    private final EnergySourcePersistencePort energySourcePersistencePort;
    private final UserPersistencePort userPersistencePort;
    private final EnergySourceMapper energySourceMapper = EnergySourceMapper.INSTANCE;

    @Autowired
    public EnergySourceServiceImpl(
            EnergySourcePersistencePort energySourcePersistencePort,
            UserPersistencePort userPersistencePort
    ) {
        this.energySourcePersistencePort = energySourcePersistencePort;
        this.userPersistencePort = userPersistencePort;
    }


    @Override
    public List<EnergySourceDisplayDTO> findAllAvailable() {
        return energySourcePersistencePort.findAllEnergySources()
                .stream()
                .map(energySourceMapper::energySourceToEnergySourceDisplayDTO)
                .collect(Collectors.toList());
    }

    public EnergySourceDisplayDTO addNewEnergySource(EnergySourceCreateUpdateDTO newSourceDTO) {
        User provider = userPersistencePort.findUserById(newSourceDTO.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        EnergySource newSource = energySourceMapper.energySourceCreateUpdateDTOToEnergySource(newSourceDTO);
        newSource.setProvider(provider);

        newSource = energySourcePersistencePort.saveEnergySource(newSource);
        return energySourceMapper.energySourceToEnergySourceDisplayDTO(newSource);
    }

    public EnergySourceDisplayDTO purchaseEnergySource(Long id, Double amount) {
        EnergySource source = energySourcePersistencePort.findEnergySourceById(id)
                .orElseThrow(() -> new RuntimeException("Energy source not found"));

        source.decreaseStock(amount);
        source = energySourcePersistencePort.saveEnergySource(source);

        return energySourceMapper.energySourceToEnergySourceDisplayDTO(source);
    }

    @Override
    public EnergySourceDisplayDTO increaseEnergySourceStock(Long id, Double amount) {
        EnergySource source = energySourcePersistencePort.findEnergySourceById(id)
                .orElseThrow(() -> new RuntimeException("Energy source not found"));

        source.increaseStock(amount);
        source = energySourcePersistencePort.saveEnergySource(source);

        return energySourceMapper.energySourceToEnergySourceDisplayDTO(source);
    }
}
