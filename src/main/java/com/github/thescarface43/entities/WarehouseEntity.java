package com.github.thescarface43.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;

import java.util.List;

@Entity
@Table(name = "warehouse")
public class WarehouseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, unique = true, length = 64)
    private String name;
    @Column(name = "location", length = 128)
    private String location;
    @ManyToOne
    @JoinColumn(name = "warehouse_type_id", nullable = false)
    private WarehouseTypeEntity type;
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<PermissionEntity> permissions;
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<LocationEntity> locations;
}
