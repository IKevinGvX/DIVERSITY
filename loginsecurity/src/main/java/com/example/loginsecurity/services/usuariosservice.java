package com.example.loginsecurity.services;

import java.util.List;

import com.example.loginsecurity.model.usuarios;

public interface usuariosservice {
    List<usuarios> getallusers();

    void createusers(usuarios cli);

    usuarios getusersbyid(long id);

    void deleteusers(long id);

    usuarios updateusers(usuarios cli);
}
