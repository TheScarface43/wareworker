package com.github.thescarface43.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "operation")
public class OperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "type", nullable = false)
    private Integer type;
    @Column(name = "amount", nullable = false, precision = 11, scale = 5)
    private BigDecimal amount;
    @Column(name = "time", nullable = false)
    private LocalDateTime time;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;
    @ManyToOne
    @JoinColumn(name = "warehouse_user_id", nullable = false)
    private WarehouseUserEntity user;
    @ManyToOne
    @JoinColumn(name = "ware_id", nullable = false)
    private WareEntity ware;
    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private LocationEntity location;

    public OperationEntity(Integer type, BigDecimal amount, WarehouseUserEntity user, WareEntity ware, LocationEntity location) {
        this.type = type;
        this.amount = amount;
        this.user = user;
        this.ware = ware;
        this.location = location;
        this.time = LocalDateTime.now();
    }

    public Integer getType() {
        return type;
    }
    public BigDecimal amount() {
        return amount;
    }
    public WareEntity getWare() {
        return ware;
    }
    public LocationEntity getLocation() {
        return location;
    }
}
