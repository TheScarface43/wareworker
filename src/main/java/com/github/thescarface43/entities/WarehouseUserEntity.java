package com.github.thescarface43.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "warehouse_user")
public class WarehouseUserEntity {
    @Id
    private Long id;
    @Column(name = "login", nullable = false, unique = true, length = 64)
    private String login;
    @Column(name = "password", nullable = false, length = 85)
    private String password;
    @Column(name = "is_enabled", nullable = false) //True by default
    private boolean isEnabled;
    @Column(name = "first_name", nullable = false, length = 32)
    private String firstName;
    @Column(name = "last_name", nullable = false, length = 32)
    private String lastName;
    @Column(length = 64)
    private String email;
    @Column(length = 15)
    private String telephone;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<PermissionEntity> permissions;
    @OneToMany(mappedBy = "user")
    private List<OperationEntity> operations;
}
