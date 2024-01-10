package com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.incoming.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.outgoing.EnergySourceDisplayDTO;

import java.util.List;

public interface EnergySourceUseCase {
    List<EnergySourceDisplayDTO> findAllAvailable();
    EnergySourceDisplayDTO addNewEnergySource(EnergySourceCreateUpdateDTO newSource);
    EnergySourceDisplayDTO purchaseEnergySource(Long id, Double amount);
    EnergySourceDisplayDTO increaseEnergySourceStock(Long id, Double amount);
}
