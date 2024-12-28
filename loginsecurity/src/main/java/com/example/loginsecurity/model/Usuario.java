package com.example.loginsecurity.model;

import jakarta.persistence.*;
import java.util.Collection;

@Entity // Declaramos que nuestra clase será una entidad
@Table(name = "usuarios", // Declaramos y nombramos nuestra tabla
        uniqueConstraints = @UniqueConstraint(columnNames = "email") // Configuramos para que el campo email sea único
)
public class Usuario {

    // Declaramos nuestras variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(unique = true) // Aseguramos que el email sea único
    private String email;

    private String password;

    // Generamos nuestra relación de tablas de muchos a muchos
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_rol", // Nombre de la tabla intermedia
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
    private Collection<Rol> roles;

    // Generamos una función pública de Usuario
    public Usuario() {
    }

    // Generamos nuestro constructor
    public Usuario(String firstName, String lastName, String email, String password, Collection<Rol> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    // Generamos nuestros métodos get y set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Rol> roles) {
        this.roles = roles;
    }
}
