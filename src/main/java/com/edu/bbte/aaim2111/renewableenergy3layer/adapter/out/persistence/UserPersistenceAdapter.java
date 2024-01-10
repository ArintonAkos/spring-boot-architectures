package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistence;

import com.edu.bbte.aaim2111.renewableenergy3layer.adapter.in.web.dto.mapper.UserMapper;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import com.edu.bbte.aaim2111.renewableenergy3layer.application.port.out.UserPersistencePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserPersistenceAdapter implements UserPersistencePort {
    private final UserRepository repository;
    private final UserMapper mapper = UserMapper.INSTANCE;

    @Autowired
    public UserPersistenceAdapter(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User saveUser(User user) {
        UserJpaEntity jpaEntity = mapper.userToUserJpaEntity(user);
        jpaEntity = repository.save(jpaEntity);
        return mapper.userJpaEntityToUser(jpaEntity);
    }

    @Override
    public List<User> findAllUsers() {
        return repository.findAll().stream()
                .map(mapper::userJpaEntityToUser)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUserById(Long id) {
        return repository.findById(id)
                .map(mapper::userJpaEntityToUser);
    }
}