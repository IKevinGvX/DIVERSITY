package com.example.loginsecurity.repository;

// Importamos las librerías de JPA
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Importamos el modelo Usuario
import com.example.loginsecurity.model.Usuario;

// Declaramos el repositorio para que nos permita interactuar con la base de datos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Declaramos la función para buscar un usuario por su email
    Usuario findByEmail(String email);
}
