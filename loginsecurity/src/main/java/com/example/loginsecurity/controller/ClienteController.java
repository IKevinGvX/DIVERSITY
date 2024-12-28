package com.example.loginsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginsecurity.model.Clientes;
import com.example.loginsecurity.services.ClienteServices;

@Controller
public class ClienteController {
    @Autowired
    private ClienteServices empleadoserivcio;

    @PostMapping("/actualizar")
    public String updatecliente(@ModelAttribute("clientes") Clientes empleado) {
        empleadoserivcio.updatecliente(empleado);
        return "redirect:/clientes";
    }

    @GetMapping("/formregistrar")
    public String empleadoformulario(Model model) {
        Clientes emp = new Clientes();
        model.addAttribute("clientes", emp);
        return "registrarclientes";
    }

    @PostMapping("/saveclientes")
    public String saveclients(@ModelAttribute("clientes") Clientes emp) {
        empleadoserivcio.saveclients(emp);
        return "redirect:/clientes";
    }

    @GetMapping("/actualizar/{id}")
    public String getclientebyid(@PathVariable(value = "id") long id, Model model) {
        Clientes empleado = empleadoserivcio.getclientebyid(id);
        model.addAttribute("clientes", empleado);
        return "actualizarclientes";
    }

    @GetMapping("/deleteclients/{id}")
    public String deleteclientebyid(@PathVariable(value = "id") long id) {
        this.empleadoserivcio.deleteclientebyid(id);
        return "redirect:/clientes";
    }
}
