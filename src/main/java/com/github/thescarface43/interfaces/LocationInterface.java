package com.github.thescarface43.interfaces;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.thescarface43.entities.LocationEntity;

public interface LocationInterface extends JpaRepository<LocationEntity, Long> {
    Optional<LocationEntity> findById (Long id);
}
