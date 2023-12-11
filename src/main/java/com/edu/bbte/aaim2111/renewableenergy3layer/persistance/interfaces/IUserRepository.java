package com.edu.bbte.aaim2111.renewableenergy3layer.persistance.interfaces;

import com.edu.bbte.aaim2111.renewableenergy3layer.domain.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
