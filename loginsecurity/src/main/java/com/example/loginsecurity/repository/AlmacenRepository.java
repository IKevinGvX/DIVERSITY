package com.example.loginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.Almacen;

@Repository
public interface AlmacenRepository extends JpaRepository<Almacen, Integer> {
}