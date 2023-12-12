package com.edu.bbte.aaim2111.renewableenergy3layer.domain.services;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserCreateUpdateDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.dto.user.UserDisplayDTO;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.mappers.UserMapper;
import com.edu.bbte.aaim2111.renewableenergy3layer.domain.services.interfaces.IUserService;
import com.edu.bbte.aaim2111.renewableenergy3layer.persistance.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final UserMapper userMapper = UserMapper.INSTANCE;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDisplayDTO createUser(UserCreateUpdateDTO userCreateUpdateDTO) {
        User user = userMapper.userCreateUpdateDTOToUser(userCreateUpdateDTO);
        user = userRepository.save(user);

        return userMapper.userToUserDisplayDTO(user);
    }

    public List<UserDisplayDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return userMapper.userListToUserDisplayDTOList(users);
    }
}
