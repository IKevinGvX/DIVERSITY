package com.example.loginsecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.loginsecurity.model.categoria;

@Repository
public interface Categoriarepository extends JpaRepository<categoria, Long> {

}
