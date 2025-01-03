package com.example.loginsecurity.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginsecurity.model.Proveedor;
import com.example.loginsecurity.repository.ProveedorRepository;

@Controller
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepo;

    @GetMapping("/proveedores")
    public String listarProveedores(Model model) {
        model.addAttribute("listproveedores", proveedorRepo.findAll());
        return "proveedores";
    }

    @GetMapping("/formregisterproveedores")
    public String formregistrarproveedor(Model model) {
        Proveedor prov = new Proveedor();
        model.addAttribute("proveedor", prov);
        return "registrarproveedores";
    }

    @GetMapping("/backproveedores")
    public String backproveedores() {
        return "proveedores";
    }

    @PostMapping("/saveproveedores")
    public String saveproveedores(@ModelAttribute("proveedor") Proveedor prov) {
        proveedorRepo.save(prov);
        return "redirect:/proveedores";
    }

    @PostMapping("/updateproveedores")
    public String updateproveedores(@ModelAttribute("proveedor") Proveedor prov) {
        proveedorRepo.save(prov);
        return "redirect:/proveedores";
    }

    @GetMapping("/openupdateproveedores/{id}")
    public String getproveedorbyid(@PathVariable(value = "id") Integer id, Model model) {
        Proveedor prov = proveedorRepo.findById(id).orElse(null);
        model.addAttribute("proveedor", prov);
        return "actualizarproveedores";
    }

    @GetMapping("/deleteproveedores/{id}")
    public String deleteproveedores(@PathVariable(value = "id") Integer id) {
        proveedorRepo.deleteById(id);
        return "redirect:/proveedores";
    }
}