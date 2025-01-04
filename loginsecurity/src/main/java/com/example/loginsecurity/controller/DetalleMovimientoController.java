package com.example.loginsecurity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import com.example.loginsecurity.model.DetalleMovimiento;
import com.example.loginsecurity.model.Productos;
import com.example.loginsecurity.model.almacen_productos;
import com.example.loginsecurity.services.DetalleMovimientoService;
import com.example.loginsecurity.services.ProductoServices;
import com.example.loginsecurity.services.almacen_productosservice;

@Controller
public class DetalleMovimientoController {

    @Autowired
    private DetalleMovimientoService service;

    @Autowired
    private almacen_productosservice almacenService;

    @Autowired
    private ProductoServices productoService;

    @GetMapping("/detalle_movimientos")
    public String listarDetalleMovimientos(Model model) {
        model.addAttribute("listdetallemovimientos", service.getAllDetalleMovimientos());
        return "detalle_movimientos"; // Nombre del HTML para listar
    }

    @GetMapping("/registrarDetalleMovimiento")
    public String registrarDetalleMovimiento(Model model) {
        // Obtener las listas de almacenes y productos
        List<almacen_productos> almacenes = almacenService.getallalmpro();
        List<Productos> productos = productoService.getallproducts();

        // Agregar los atributos al modelo
        model.addAttribute("almacenes", almacenes);
        model.addAttribute("productos", productos);

        // Crear un objeto nuevo para registrar
        model.addAttribute("detalle_movimiento", new DetalleMovimiento());

        // Retornar la vista
        return "registrarDetalleMovimiento";
    }

    @PostMapping("/saveDetalleMovimiento")
    public String guardarDetalleMovimiento(@ModelAttribute("detalle_movimiento") DetalleMovimiento detalle) {
        service.saveDetalleMovimiento(detalle);
        return "redirect:/detalle_movimientos";
    }

    @GetMapping("/actualizarDetalleMovimiento/{id}")
    public String obtenerDetalleMovimientoPorId(@PathVariable(value = "id") long id, Model model) {
        // Obtener las listas de almacenes y productos para el formulario de actualización
        List<almacen_productos> almacenes = almacenService.getallalmpro();
        List<Productos> productos = productoService.getallproducts();

        model.addAttribute("almacenes", almacenes);
        model.addAttribute("productos", productos);

        // Obtener el detalle movimiento por ID
        model.addAttribute("detalle_movimiento", service.getDetalleMovimientoById(id));
        return "actualizarDetalleMovimiento"; // Nombre del HTML para actualizar
    }

    @PostMapping("/actualizarDetalleMovimiento")
    public String actualizarDetalleMovimiento(@ModelAttribute("detalle_movimiento") DetalleMovimiento detalle) {
        service.updateDetalleMovimiento(detalle);
        return "redirect:/detalle_movimientos";
    }

    @GetMapping("/deleteDetalleMovimiento/{id}")
    public String eliminarDetalleMovimientoPorId(@PathVariable(value = "id") long id) {
        service.deleteDetalleMovimientoById(id);
        return "redirect:/detalle_movimientos";
    }
}
