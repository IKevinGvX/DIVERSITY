package com.example.loginsecurity.services;

import java.util.List;

import com.example.loginsecurity.model.almacen_productos;

public interface almacen_productosservice {
    List<almacen_productos> getallalmpro();

    void savealmprod(almacen_productos cli);

    almacen_productos getalmprodbyid(long id);

    void deletealmprobyid(long id);

    almacen_productos updatepromalm(almacen_productos cli);
}
