package com.github.thescarface43.entities;

import java.math.BigDecimal;
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

@Entity
@Table(name = "ware")
public class WareEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name", nullable = false, length = 64)
    private String name;
    @Column(name = "unit", nullable = false, length = 10)
    private String unit;
    @Column(name = "permit_decimal", nullable = false)
    private boolean permitDecimal;
    @Column(name = "ean", nullable = false, unique = true, length = 13)
    private String ean;
    @Column(name = "price", precision = 10, scale = 2)
    private BigDecimal price;
    @Column(name = "vat", precision = 3)
    private Integer vat;
    @Column(name = "weight", precision = 10, scale = 5)
    private BigDecimal weight;
    @Column(name = "max_per_pallet")
    private Integer maxPerPallet;
    @Column(name = "description", length = 256)
    private String description;
    @ManyToOne
    @JoinColumn(name = "ware_category_id")
    private WareCategoryEntity category;
    @OneToMany(mappedBy = "ware")
    private List<OperationEntity> operations;

    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getUnit() {
        return unit;
    }
    public boolean isDecimalAllowed() {
        return permitDecimal;
    }
    public String getEan() {
        return ean;
    }
    public WareCategoryEntity getCategory() {
        return category;
    }
}
