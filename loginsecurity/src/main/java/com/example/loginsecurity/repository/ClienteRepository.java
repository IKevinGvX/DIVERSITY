package com.example.loginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.Clientes;

@Repository
public interface ClienteRepository extends JpaRepository<Clientes, Long> {

}
