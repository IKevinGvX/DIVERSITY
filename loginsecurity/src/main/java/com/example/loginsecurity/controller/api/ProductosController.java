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

import com.example.loginsecurity.model.Productos;
import com.example.loginsecurity.services.api.ProductosService;

@Controller
@RestController
@RequestMapping("/api/products")
public class ProductosController {
    @Autowired
    private ProductosService proservices;

    @GetMapping("/listproducts")
    public List<Productos> getallproducts() {
        return proservices.getallproducts();
    }

    @GetMapping("/productos")
    public String principal() {
        return "productos";
    }

    @GetMapping("/registrar-producto")
    public String registrarproducto() {
        return "registrar-producto";
    }

    @PostMapping("/agregaproducts")
    public Productos registrarproductos(@RequestBody Productos pro) {
        return proservices.createproducts(pro);
    }

    @PostMapping("/updateproducts/{id}")
    public Productos updateproducts(@RequestBody Productos pro, @PathVariable Long id) {
        pro.setProductoid(id);
        return proservices.updateproducts(pro);
    }

    @DeleteMapping("/deleteproducts/{id}")
    public String deleteproducts(@PathVariable Long id) {
        proservices.deleteproducts(id);
        return "Eliminado Correctamente " + id;
    }
}
