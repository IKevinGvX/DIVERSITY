package com.example.loginsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginsecurity.model.almacen_productos;
import com.example.loginsecurity.repository.AlmacenRepository;
import com.example.loginsecurity.services.ProductoServices;
import com.example.loginsecurity.services.almacen_productosservice;

@Controller
public class AlmacenProductoController {
    @Autowired
    private AlmacenRepository almservice;
    @Autowired
    private ProductoServices productoreposi;
    @Autowired
    private almacen_productosservice almproservices;

    @GetMapping("goupt")
    public String goupt() {
        return "almacen";
    }

    @GetMapping("reporte")
    public String reporte() {
        return "reporte";
    }

    // llevaractualizacion
    @PostMapping("/updatealmpro")
    public String updatepromalm(@ModelAttribute("almacen_productos") almacen_productos alm) {
        almproservices.updatepromalm(alm);
        return "redirect:/openalmacenproductos";
    }

    // openform
    @GetMapping("/formregisteralmp")
    public String formregisteralmp(Model model) {
        almacen_productos productosAlmacen = new almacen_productos();
        model.addAttribute("almacen_productos", productosAlmacen);
        model.addAttribute("productos", productoreposi.getallproducts());
        model.addAttribute("almacen", almservice.findAll());
        return "formregisteralmp";
    }

    // home
    @GetMapping("/almacenproductos")
    public String formregisteralmp1(Model model) {
        almacen_productos productosAlmacen = new almacen_productos();
        model.addAttribute("almacen_productos", productosAlmacen);
        return "almacenproductos";
    }

    // luegodeingresarregistros
    @PostMapping("/savealmprod")
    public String savealmprod(@ModelAttribute("almacen_productos") almacen_productos emp) {
        almproservices.savealmprod(emp);
        return "redirect:/openalmacenproductos";
    }

    // openupdate
    @GetMapping("/updatealmpro/{id}")
    public String getalmprobyid(@PathVariable(value = "id") long id, Model model) {
        almacen_productos empleado = almproservices.getalmprodbyid(id);
        model.addAttribute("almacen_productos", empleado);
        return "updatealmp";
    }

}
