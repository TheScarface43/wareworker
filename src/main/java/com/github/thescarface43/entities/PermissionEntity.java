package com.github.thescarface43.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

@Entity
@Table(name = "permission")
public class PermissionEntity {
    @Id
    private Long id;
    @Column(name = "value")
    private Integer value;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private WarehouseUserEntity user;
    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private WarehouseEntity warehouse;
}
