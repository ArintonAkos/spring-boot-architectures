package com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserPersistencePort {
    User saveUser(User user);
    List<User> findAllUsers();
    Optional<User> findUserById(Long id);
}
