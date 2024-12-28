package com.example.loginsecurity.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.loginsecurity.services.UsuarioService;
import com.example.loginsecurity.controller.UsuarioRegistroDto;

@SuppressWarnings("unused")
@Controller
@RequestMapping("/registro") // Colocamos una ruta para nuestro controlador
public class RegistroController {

    // Creamos una variable con los servicios de usuario a utilizar
    private final UsuarioService userService;

    // Generamos un controlador que traiga las funciones de UsuarioService
    public RegistroController(UsuarioService userService) {
        super();
        this.userService = userService;
    }

    // Generamos una función que enviará los datos al modelo
    @ModelAttribute("user")
    public UsuarioRegistroDto userRegistrationDto() {
        return new UsuarioRegistroDto();
    }

    // Generamos una función que activará el formulario de registro
    @GetMapping
    public String showRegistrationForm() {
        return "registro";
    }

    // Generamos una función que registrará la información y enviará un mensaje
    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UsuarioRegistroDto registrationDto) {
        try {
            userService.save(registrationDto);
            return "redirect:/registro?success";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "redirect:/registro?email_invalid";
        }
    }
}
