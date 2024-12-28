package com.example.loginsecurity.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.loginsecurity.model.Clientes;
import com.example.loginsecurity.services.api.ClienteService;

@Controller
@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    @Autowired
    private ClienteService clienteservice;

    @GetMapping("/listcliente")
    public List<Clientes> Getallemp() {
        return clienteservice.getallclient();
    }

    @PostMapping("/agregacliente")
    public Clientes registeremp(@RequestBody Clientes emp) {
        return clienteservice.createclient(emp);
    }

    @PostMapping("/updatecliente/{id}")
    public Clientes updatemp(@RequestBody Clientes emp, @PathVariable Long id) {
        emp.setCliente_id(id);
        return clienteservice.updateclient(emp);
    }

    @DeleteMapping("/deletecliente/{id}")
    public String deleteemp(@PathVariable Long id) {
        clienteservice.deleteclient(id);
        return "Eliminado Correctamente : " + id;
    }
}