package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.UserPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository repository;

    @Autowired
    public UserPersistenceAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        return repository.save(user);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return repository.findById(id);
    }
}
