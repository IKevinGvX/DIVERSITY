package com.example.loginsecurity.services.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.Clientes;
import com.example.loginsecurity.repository.ClienteRepository;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clients;

    public List<Clientes> getallclient() {
        return clients.findAll();
    }

    public Clientes createclient(Clientes cli) {
        return clients.save(cli);
    }

    public Clientes updateclient(Clientes cli) {
        return clients.save(cli);
    }

    public void deleteclient(Long id) {
        clients.deleteById(id);
    }
}