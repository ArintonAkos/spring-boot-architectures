package com.edu.bbte.aaim2111.renewableenergy3layer.domain.services.interfaces;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserDisplayDTO;

import java.util.List;

public interface IUserService {
    UserDisplayDTO createUser(UserCreateUpdateDTO userCreateUpdateDTO);

    List<UserDisplayDTO> getAllUsers();
}
