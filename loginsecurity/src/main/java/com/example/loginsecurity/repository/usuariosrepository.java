package com.example.loginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.usuarios;

@Repository
public interface usuariosrepository extends JpaRepository<usuarios, Long> {

}
