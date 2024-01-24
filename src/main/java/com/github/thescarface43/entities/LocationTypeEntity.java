package com.github.thescarface43.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import java.util.List;

@Entity
@Table(name = "location_type")
public class LocationTypeEntity {
    @Id
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 64)
    private String name;
    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL)
    private List<LocationEntity> locations;
}
