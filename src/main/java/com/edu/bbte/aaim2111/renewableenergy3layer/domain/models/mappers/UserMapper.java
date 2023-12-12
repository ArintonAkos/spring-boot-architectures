package com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.mappers;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.User;
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
}
