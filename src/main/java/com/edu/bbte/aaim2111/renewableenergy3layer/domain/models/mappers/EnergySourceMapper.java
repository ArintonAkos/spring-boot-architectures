package com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.mappers;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.energy.EnergySourceDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.EnergySource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EnergySourceMapper {
    EnergySourceMapper INSTANCE = Mappers.getMapper(EnergySourceMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provider", ignore = true)
    EnergySource energySourceCreateUpdateDTOToEnergySource(EnergySourceCreateUpdateDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "capacity", source = "capacity")
    @Mapping(target = "java(energySource.isAvailable())", expression = "java(energySource.isAvailable())")
    @Mapping(target = "stock", source = "stock")
    @Mapping(target = "price", source = "price")
    @Mapping(target = "providerId", source = "provider.id")
    EnergySourceDisplayDTO energySourceToEnergySourceDisplayDTO(EnergySource energySource);
}