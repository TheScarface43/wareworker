package com.github.thescarface43.DTOs;

import java.math.BigDecimal;

import com.github.thescarface43.entities.LocationEntity;
import com.github.thescarface43.entities.WareEntity;

public class WarehouseStateDTO {
    private WareEntity ware;
    private LocationEntity location;
    private BigDecimal totalAmount;

    public WarehouseStateDTO(WareEntity ware, LocationEntity location, BigDecimal positiveValues, BigDecimal negativeValues) {
        this.ware = ware;
        this.location = location;
        this.totalAmount = positiveValues.subtract(negativeValues);
    }

    public WareEntity getWare() {
        return ware;
    }
    public LocationEntity getLocation() {
        return location;
    }
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setWare(WareEntity newWare) {
        ware = newWare;
    }
    public void setLocation(LocationEntity newLocation) {
        location = newLocation;
    }
    public void setTotalAmount(BigDecimal newTotalAmount) {
        totalAmount = newTotalAmount;
    }
}
