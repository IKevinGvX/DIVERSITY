package com.example.loginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.almacen_productos;

@Repository
public interface almacen_productosreposiroty extends JpaRepository<almacen_productos, Long> {

}
