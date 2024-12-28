package com.example.loginsecurity.services;

// Importamos las librerías de Spring Security
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

// Importamos nuestro controlador, modelo y el repositorio de JPA
import com.example.loginsecurity.controller.UsuarioRegistroDto;
import com.example.loginsecurity.model.Rol;
import com.example.loginsecurity.model.Usuario;
import com.example.loginsecurity.repository.UsuarioRepository;

// Importamos nuestras colecciones de datos
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service // Declaramos la clase como un servicio
public class UsuarioServiceImpl implements UsuarioService {

    // Repositorio y codificador de contraseñas
    private final UsuarioRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // Constructor
    public UsuarioServiceImpl(UsuarioRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Función para registrar los usuarios
    @Override
    public Usuario save(UsuarioRegistroDto registrationDto) {
        Usuario user = new Usuario(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()), // Encriptamos la clave
                Arrays.asList(new Rol("Role_Admin")) // Generamos un rol
        // automático
        );
        return userRepository.save(user);
    }

    // Función para validar los accesos del login
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Usuario o contraseña incorrecto.");
        }
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    // Función que mapeará los roles
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Rol> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    // Función que traerá la lista de usuarios
    @Override
    public List<Usuario> getAll() {
        return userRepository.findAll();
    }
}
