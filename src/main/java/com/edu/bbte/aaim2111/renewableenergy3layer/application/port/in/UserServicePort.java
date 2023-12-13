package com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.UserDisplayDTO;

import java.util.List;

public interface UserServicePort {
    UserDisplayDTO createUser(UserCreateUpdateDTO userCreateUpdateDTO);

    List<UserDisplayDTO> getAllUsers();
}
