package com.github.thescarface43.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.util.List;

@Entity
@Table(name = "warehouse_type")
public class WarehouseTypeEntity {
    @Id
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 64)
    private String name;
    @Column(length = 256)
    private String description;
    @OneToMany(mappedBy = "type")
    private List<WarehouseEntity> warehouse;
}
