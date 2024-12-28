package com.example.loginsecurity.services.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.Productos;
import com.example.loginsecurity.repository.ProductoRepository;

@Service
public class ProductosService {
    @Autowired
    private ProductoRepository products;

    public List<Productos> getallproducts() {
        return products.findAll();
    }

    public Productos createproducts(Productos pro) {
        return products.save(pro);
    }

    public Productos updateproducts(Productos pro) {
        return products.save(pro);
    }

    public void deleteproducts(Long id) {
        products.deleteById(id);
    }
}
