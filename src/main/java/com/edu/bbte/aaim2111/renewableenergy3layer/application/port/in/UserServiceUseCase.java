package com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.incoming.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.outgoing.UserDisplayDTO;

import java.util.List;

public interface UserServiceUseCase {
    UserDisplayDTO createUser(UserCreateUpdateDTO userCreateUpdateDTO);

    List<UserDisplayDTO> getAllUsers();
}
