package com.github.thescarface43.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "location", uniqueConstraints = @UniqueConstraint(columnNames = {"rack", "spot", "level", "warehouse_id"}))
public class LocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "rack", nullable = false, length = 16)
    private String rack;
    @Column(name = "spot", nullable = false)
    private Integer spot;
    @Column(name = "level", nullable = false)
    private Integer level;
    @ManyToOne
    @JoinColumn(name = "warehouse_id", nullable = false)
    private WarehouseEntity warehouse;
    @ManyToOne
    @JoinColumn(name = "location_type_id", nullable = false)
    private LocationTypeEntity type;
    @OneToMany(mappedBy = "location")
    private List<OperationEntity> operations;

    public Long getId() {
        return id;
    }
    public String getRack() {
        return rack;
    }
    public Integer getSpot() {
        return spot;
    }
    public Integer getLevel() {
        return level;
    }
}
