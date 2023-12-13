package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance;

import com.edu.bbte.aaim2111.renewableenergy3layer.application.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
