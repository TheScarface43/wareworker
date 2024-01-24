package com.github.thescarface43.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.github.thescarface43.DTOs.WarehouseStateDTO;
import com.github.thescarface43.entities.OperationEntity;

public interface OperationInterface extends JpaRepository<OperationEntity, Long> {
    @Query("SELECT new com.github.thescarface43.DTOs.WarehouseStateDTO(operation.ware, operation.location, " +
            "SUM(CASE WHEN operation.type = 1 THEN operation.amount ELSE 0 END), " +
            "SUM(CASE WHEN operation.type = 2 THEN operation.amount ELSE 0 END)) " +
            "FROM OperationEntity operation " +
            "JOIN operation.ware ware " +
            "JOIN operation.location location " +
            "GROUP BY ware.id, location.id")
    Page<WarehouseStateDTO> getWarehouseState(Pageable pageable);
}
