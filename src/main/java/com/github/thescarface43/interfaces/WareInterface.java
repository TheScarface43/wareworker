package com.github.thescarface43.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.thescarface43.entities.WareEntity;

public interface WareInterface extends JpaRepository<WareEntity, Long> {
    Optional<WareEntity> findById (Long id);
}
