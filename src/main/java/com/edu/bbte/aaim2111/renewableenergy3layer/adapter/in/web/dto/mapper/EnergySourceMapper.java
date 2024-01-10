package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.mapper;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.incoming.EnergySourceCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.outgoing.EnergySourceDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence.EnergySourceJpaEntity;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence.UserJpaEntity;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.EnergySource;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.UserPersistencePort;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class EnergySourceMapper {
    @Autowired
    private UserPersistencePort userPersistencePort;

    public EnergySourceMapper() {
    }

    public EnergySourceMapper(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "provider", source = "providerId", qualifiedByName = "mapProvider")
    public abstract EnergySource energySourceCreateUpdateDTOToEnergySource(EnergySourceCreateUpdateDTO dto);

    @Mapping(target = "providerId", source = "provider.id")
    public abstract EnergySourceDisplayDTO energySourceToEnergySourceDisplayDTO(EnergySource energySource);

    @Mapping(target = "provider", source = "provider", qualifiedByName = "mapUserToUserJpaEntity")
    public abstract EnergySourceJpaEntity energySourceToEnergySourceJpaEntity(EnergySource energySource);

    @Mapping(target = "provider", source = "provider", qualifiedByName = "mapUserJpaEntityToUser")
    public abstract EnergySource energySourceJpaEntityToEnergySource(EnergySourceJpaEntity entity);

    @Named("mapProvider")
    protected User mapProvider(Long providerId) {
        return providerId == null
                ? null
                : userPersistencePort.findUserById(providerId)
                .orElseThrow(() -> new RuntimeException("Provider not found"));
    }

    @Named("mapUserToUserJpaEntity")
    protected UserJpaEntity mapUserToUserJpaEntity(User provider) {
        if (provider == null) {
            return null;
        }

        UserJpaEntity userJpaEntity = new UserJpaEntity();
        userJpaEntity.setId(provider.getId());
        userJpaEntity.setUsername(provider.getUsername());
        userJpaEntity.setEmail(provider.getEmail());

        return userJpaEntity;
    }

    @Named("mapUserJpaEntityToUser")
    protected User mapUserJpaEntityToUser(UserJpaEntity provider) {
        if (provider == null) {
            return null;
        }

        User user = new User();
        user.setId(provider.getId());
        user.setUsername(provider.getUsername());
        user.setEmail(provider.getEmail());

        return user;
    }
}