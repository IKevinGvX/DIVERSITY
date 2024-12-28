package com.example.loginsecurity.controller;

// Generamos una clase que enviará los datos de registro
public class UsuarioRegistroDto {

    // Generamos las variables
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    // Generamos un constructor público vacío
    public UsuarioRegistroDto() {
    }

    // Generamos los métodos get y set
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
}
