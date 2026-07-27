package com.thelearnerz.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thelearnerz.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Custom query method used during authentication to fetch matching users
    Optional<User> findByEmail(String email);
}
