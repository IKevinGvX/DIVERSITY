package com.example.loginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.roles;

@Repository

public interface rolesRepository extends JpaRepository<roles, Long> {
}