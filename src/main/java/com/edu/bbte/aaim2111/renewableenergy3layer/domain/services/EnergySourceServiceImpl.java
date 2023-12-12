package com.edu.bbte.aaim2111.renewableenergy3layer.domain.services;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.EnergySource;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.mappers.EnergySourceMapper;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.services.interfaces.IEnergySourceService;
import com.edu.bbte.aaim2111.renewableenergy3layer.persistance.repositories.IEnergySourceRepository;
import com.edu.bbte.aaim2111.renewableenergy3layer.persistance.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnergySourceServiceImpl implements IEnergySourceService {
    private final IEnergySourceRepository energySourceRepository;
    private final IUserRepository userRepository;
    private final EnergySourceMapper energySourceMapper = EnergySourceMapper.INSTANCE;

    @Autowired
    public EnergySourceServiceImpl(
            IEnergySourceRepository energySourceRepository,
            IUserRepository userRepository
    ) {
        this.energySourceRepository = energySourceRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<EnergySourceDisplayDTO> findAllAvailable() {
        return energySourceRepository.findAll()
                .stream()
                .map(energySourceMapper::energySourceToEnergySourceDisplayDTO)
                .collect(Collectors.toList());
    }

    public EnergySourceDisplayDTO addNewEnergySource(EnergySourceCreateUpdateDTO newSourceDTO) {
        User provider = userRepository.findById(newSourceDTO.getProviderId())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        EnergySource newSource = energySourceMapper.energySourceCreateUpdateDTOToEnergySource(newSourceDTO);
        newSource.setProvider(provider);

        newSource = energySourceRepository.save(newSource);
        return energySourceMapper.energySourceToEnergySourceDisplayDTO(newSource);
    }

    public EnergySourceDisplayDTO purchaseEnergySource(Long id, Double amount) {
        EnergySource source = energySourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Energy source not found"));

        source.decreaseStock(amount);
        source = energySourceRepository.save(source);

        return energySourceMapper.energySourceToEnergySourceDisplayDTO(source);
    }

    @Override
    public EnergySourceDisplayDTO increaseEnergySourceStock(Long id, Double amount) {
        EnergySource source = energySourceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Energy source not found"));

        source.increaseStock(amount);
        source = energySourceRepository.save(source);

        return energySourceMapper.energySourceToEnergySourceDisplayDTO(source);
    }
}
