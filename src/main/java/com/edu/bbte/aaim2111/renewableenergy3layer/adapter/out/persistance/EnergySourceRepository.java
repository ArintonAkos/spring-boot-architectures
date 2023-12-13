package com.edu.bbte.aaim2111.renewableenergy3layer.adapter.out.persistance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergySourceRepository extends JpaRepository<EnergySourceJpaEntity, Long> {
}
