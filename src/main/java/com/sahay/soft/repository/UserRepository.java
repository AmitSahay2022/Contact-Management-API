package com.sahay.soft.repository;

import com.sahay.soft.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
   Optional<User> findByuserName(String name);
}
