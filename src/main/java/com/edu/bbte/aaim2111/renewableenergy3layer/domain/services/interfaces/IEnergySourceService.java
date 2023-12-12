package com.edu.bbte.aaim2111.renewableenergy3layer.domain.services.interfaces;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceDisplayDTO;

import java.util.List;

public interface IEnergySourceService {
    List<EnergySourceDisplayDTO> findAllAvailable();
    EnergySourceDisplayDTO addNewEnergySource(EnergySourceCreateUpdateDTO newSource);
    EnergySourceDisplayDTO purchaseEnergySource(Long id, Double amount);
    EnergySourceDisplayDTO increaseEnergySourceStock(Long id, Double amount);
}
