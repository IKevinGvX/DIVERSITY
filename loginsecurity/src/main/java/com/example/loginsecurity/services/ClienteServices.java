package com.example.loginsecurity.services;

import java.util.List;

import com.example.loginsecurity.model.Clientes;

public interface ClienteServices {
    List<Clientes> getallcliente();

    void saveclients(Clientes cli);

    Clientes getclientebyid(long id);

    void deleteclientebyid(long id);

    Clientes updatecliente(Clientes cli);
}
