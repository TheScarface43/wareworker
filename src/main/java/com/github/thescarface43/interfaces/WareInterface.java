package com.github.thescarface43.interfaces;

import com.github.thescarface43.entities.WareEntity;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WareInterface extends JpaRepository<WareEntity, Long> {

    List<WareEntity> findByName (String name);
    List<WareEntity> findByEan (String ean);
    List<WareEntity> findByNameContaining(String searchString);
}
