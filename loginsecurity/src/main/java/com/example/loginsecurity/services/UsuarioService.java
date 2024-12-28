package com.example.loginsecurity.services;

// Importamos la extensión de los servicios detallados de usuario
import org.springframework.security.core.userdetails.UserDetailsService;

// Importamos el controlador de registro de usuarios y el modelo
import com.example.loginsecurity.controller.UsuarioRegistroDto;
import com.example.loginsecurity.model.Usuario;

// Importamos la librería de colección de datos
import java.util.List;

// Declaramos este servicio como una interfaz
public interface UsuarioService extends UserDetailsService {

    // Declaramos los métodos que se utilizarán
    Usuario save(UsuarioRegistroDto registrationDto);

    List<Usuario> getAll();
}
