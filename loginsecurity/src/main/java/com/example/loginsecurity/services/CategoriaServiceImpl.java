package com.example.loginsecurity.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.categoria;
import com.example.loginsecurity.repository.Categoriarepository;

@Service
public class CategoriaServiceImpl implements Categoriaservices {
    @Autowired
    private Categoriarepository clirepository;

    @Override
    public List<categoria> getallcategoria() {
        return clirepository.findAll();
    }
}
