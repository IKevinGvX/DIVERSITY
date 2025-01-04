package com.example.loginsecurity.controller;

import com.example.loginsecurity.model.MovimientoAlmacenDestinado;
import com.example.loginsecurity.services.MovimientoAlmacenDestinadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovimientoAlmacenDestinadoController {

    @Autowired
    private MovimientoAlmacenDestinadoService movimientoService;

    @GetMapping("/movimientos")
    public String listarMovimientos(Model model) {
        model.addAttribute("movimientos", movimientoService.getAllMovimientos());
        return "movimientos";
    }

    @GetMapping("/movimientos/form")
    public String formularioRegistro(Model model) {
        MovimientoAlmacenDestinado movimiento = new MovimientoAlmacenDestinado();
        model.addAttribute("movimiento", movimiento);
        return "registrarmovimiento"; // Nombre del archivo HTML para registrar un movimiento
    }

    @PostMapping("/movimientos/guardar")
    public String guardarMovimiento(@ModelAttribute("movimiento") MovimientoAlmacenDestinado movimiento) {
        movimientoService.guardarMovimiento(movimiento);
        return "redirect:/movimientos";
    }

    @GetMapping("/movimientos/editar/{id}")
    public String obtenerMovimientoPorId(@PathVariable("id") Integer id, Model model) {
        MovimientoAlmacenDestinado movimiento = movimientoService.obtenerMovimientoPorId(id);
        model.addAttribute("movimiento", movimiento);
        return "actualizarmovimiento"; // Nombre del archivo HTML para editar movimiento
    }

    @PostMapping("/movimientos/actualizar")
    public String actualizarMovimiento(@ModelAttribute("movimiento") MovimientoAlmacenDestinado movimiento) {
        movimientoService.actualizarMovimiento(movimiento);
        return "redirect:/movimientos";
    }

    @GetMapping("/movimientos/eliminar/{id}")
    public String eliminarMovimiento(@PathVariable("id") Integer id) {
        movimientoService.eliminarMovimiento(id);
        return "redirect:/movimientos";
    }
}
