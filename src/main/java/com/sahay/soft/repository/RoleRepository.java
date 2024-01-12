package com.sahay.soft.repository;

import com.sahay.soft.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
    Role findByRole(String role);
    boolean existsByRole(String role);
}
