package com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.services;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.UserPersistencePort;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.incoming.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.outgoing.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.mapper.UserMapper;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.in.UserServiceUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServiceUseCase {
    private final UserPersistencePort userPersistencePort;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(UserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public UserDisplayDTO createUser(UserCreateUpdateDTO userCreateUpdateDTO) {
        User user = userMapper.userCreateUpdateDTOToUser(userCreateUpdateDTO);
        user = userPersistencePort.saveUser(user);
        return userMapper.userToUserDisplayDTO(user);
    }

    @Override
    public List<UserDisplayDTO> getAllUsers() {
        return userPersistencePort.findAllUsers()
                .stream()
                .map(userMapper::userToUserDisplayDTO)
                .collect(Collectors.toList());
    }
}