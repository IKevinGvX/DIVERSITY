package com.example.loginsecurity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.Productos;

@Repository

public interface ProductoRepository extends JpaRepository<Productos, Long> {
    List<Productos> findByStockLessThan(int stockMinimo);

}
