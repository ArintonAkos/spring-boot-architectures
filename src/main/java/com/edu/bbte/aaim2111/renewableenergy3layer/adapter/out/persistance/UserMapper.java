package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", ignore = true)
    User userCreateUpdateDTOToUser(UserCreateUpdateDTO dto);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "email", source = "email")
    UserDisplayDTO userToUserDisplayDTO(User user);

    List<UserDisplayDTO> userListToUserDisplayDTOList(List<User> users);

    User userJpaEntityToUser(UserJpaEntity entity);

    UserJpaEntity userToUserJpaEntity(User user);
}
