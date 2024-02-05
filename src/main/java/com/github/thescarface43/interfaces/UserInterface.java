package com.github.thescarface43.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.thescarface43.entities.WarehouseUserEntity;

public interface UserInterface extends JpaRepository<WarehouseUserEntity, Long> {
    Optional<WarehouseUserEntity> findById (Long id);
}
