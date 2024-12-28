package com.example.loginsecurity.services;

import java.util.List;

import com.example.loginsecurity.model.Productos;

public interface ProductoServices {

    List<Productos> getallproducts();

    void saveproducts(Productos cli);

    Productos getproductsbyid(long id);

    void deleteproducts(long id);

    Productos updateproducts(Productos cli);

    long gettotalproducts();

    List<Productos> getProductsWithLowStock(int stockMinimo);

}
