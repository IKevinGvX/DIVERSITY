package com.example.loginsecurity.model;

import jakarta.persistence.*;

@Entity // Declaramos que nuestra clase será una entidad
@Table(name = "rol") // Declaramos y nombramos nuestra tabla que se creará en nuestra BD
public class Rol {

    // Declaramos nuestras variables
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name") // Opcional, pero ayuda a mapear correctamente la columna
    private String name;

    // Generamos una función pública vacía
    public Rol() {
    }

    // Generamos nuestro constructor
    public Rol(String name) {
        super();
        this.name = name;
    }

    // Generamos nuestros métodos get y set
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
