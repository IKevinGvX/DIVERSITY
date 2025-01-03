package com.example.loginsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.loginsecurity.services.ClienteServices;
import com.example.loginsecurity.services.ProductoServices;
import com.example.loginsecurity.services.usuariosservice;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class InicioController {
    @Autowired
    private ClienteServices empleadoserivcio;
    @Autowired
    private usuariosservice usuariosService;
    @Autowired
    private ProductoServices proservices;
    @Autowired
    private ProductoServices productservices;

    // Generamos la vista del login
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/clientes")
    public String view(Model model) {
        model.addAttribute("listclients", empleadoserivcio.getallcliente());
        return "clientes";
    }

    @GetMapping("/productos")
    public String viewproducts(Model model) {
        model.addAttribute("listproducts", productservices.getallproducts());
        long totalProductos = proservices.gettotalproducts();
        model.addAttribute("totalproductos", totalProductos);
        return "productos";
    }

    @GetMapping("/usuarios")
    public String viewotrer(Model model) {
        model.addAttribute("listusuarios", usuariosService.getallusers());
        model.addAttribute("roles", productservices.getallroles());
        return "usuarios";
    }

    // Generamos la vista de inicio de sesión
    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("Administrador")) {
            return "redirect:/admin/index";
        } else if (request.isUserInRole("CLIENTE")) {
            return "redirect:/formulario-cliente";
        } else if (request.isUserInRole("EMPLEADO")) {
            return "redirect:/empleado/dashboard";
        } else if (request.isUserInRole("ALMACEN")) {
            return "redirect:/almacen/inventario";
        } else if (request.isUserInRole("Role_Admin")) {
            return "redirect:/index";
        }
        return "/index";
    }
}
