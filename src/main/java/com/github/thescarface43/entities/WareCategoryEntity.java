package com.github.thescarface43.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ware_category")
public class WareCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Column(name = "description", length = 256)
    private String description;
    @OneToMany(mappedBy = "category")
    private List<WareEntity> wares;

    public String getName() {
        return name;
    }
}
