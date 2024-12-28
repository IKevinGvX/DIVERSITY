package com.example.loginsecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.loginsecurity.model.usuarios;
import com.example.loginsecurity.services.usuariosservice;

@Controller
public class UsuariosController {
    @Autowired
    private usuariosservice usuariosService;

    @PostMapping("/modermusers")
    public String actualizaciondata(@ModelAttribute("usuarios") usuarios users) {
        usuariosService.updateusers(users);
        return "redirect:/usuarios";
    }

    @GetMapping("/formregisterusers")
    public String userformulario(Model model) {
        usuarios use = new usuarios();
        model.addAttribute("usuarios", use);
        return "registarusuario";
    }

    @PostMapping("/saveusers")
    public String crearusers(@ModelAttribute("usuarios") usuarios use) {
        usuariosService.createusers(use);
        return "redirect:/usuarios";
    }

    @GetMapping("/updateusers/{id}")
    public String formybyidusers(@PathVariable(value = "id") long id, Model model) {
        usuarios usuarios = usuariosService.getusersbyid(id);
        model.addAttribute("usuarios", usuarios);
        return "actualizarusers";
    }

    @GetMapping("/deleteusers/{id}")
    public String eliminandousers(@PathVariable(value = "id") long id) {
        this.usuariosService.deleteusers(id);
        return "redirect:/usuarios";
    }
}
