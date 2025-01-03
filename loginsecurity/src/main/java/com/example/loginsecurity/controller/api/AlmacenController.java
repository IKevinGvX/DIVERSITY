package com.example.loginsecurity.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginsecurity.model.Almacen;
import com.example.loginsecurity.model.almacen_productos;
import com.example.loginsecurity.repository.AlmacenRepository;
import com.example.loginsecurity.services.ProductoServices;
import com.example.loginsecurity.services.almacen_productosservice;

@Controller
public class AlmacenController {
    @Autowired
    private AlmacenRepository almacenRepo;
    @Autowired
    private almacen_productosservice almproservices;
    @Autowired
    private AlmacenRepository almservice;
    @Autowired
    private ProductoServices productoreposi;

    @GetMapping("/almacen")
    public String listarAlmacenes(Model model) {
        model.addAttribute("listalmacenes", almacenRepo.findAll());
        return "almacen";
    }

    @GetMapping("/openalmacenproductos")
    public String obteneralmacen(Model model) {
        List<almacen_productos> productosAlmacen = almproservices.getallalmpro();
        // Add them as attributes to the model
        model.addAttribute("almacen_productos", productosAlmacen);
        model.addAttribute("productos", productoreposi.getallproducts());
        model.addAttribute("almacen", almservice.findAll());
        return "almacenproductos";
    }

    @GetMapping("/formregisteralmacen")
    public String formregistraralmacen(Model model) {
        Almacen alm = new Almacen();
        model.addAttribute("almacen", alm);
        return "registraralmacen";
    }

    @GetMapping("/backalmacen")
    public String backalmacen() {
        return "almacen";
    }

    @PostMapping("/savealmacen")
    public String savealmacen(@ModelAttribute("almacen") Almacen alm) {
        almacenRepo.save(alm);
        return "redirect:/almacen";
    }

    @PostMapping("/updatealmacen")
    public String updatealmacen(@ModelAttribute("almacen") Almacen alm) {
        almacenRepo.save(alm);
        return "redirect:/almacen";
    }

    @GetMapping("/openupdatealmacen/{id}")
    public String getalmacenbyid(@PathVariable(value = "id") Integer id, Model model) {
        Almacen alm = almacenRepo.findById(id).orElse(null);
        model.addAttribute("almacen", alm);
        return "actualizaralmacen";
    }

    @GetMapping("/deletealmacen/{id}")
    public String deletealmacen(@PathVariable(value = "id") Integer id) {
        almacenRepo.deleteById(id);
        return "redirect:/almacen";
    }
}
