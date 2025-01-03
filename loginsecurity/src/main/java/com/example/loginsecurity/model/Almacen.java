package com.example.loginsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacen")
public class Almacen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer almacenid;
    private String nombrealmacen;
    private String direccionalmacen;

    public Integer getAlmacenid() {
        return almacenid;
    }

    public void setAlmacenid(Integer almacenid) {
        this.almacenid = almacenid;
    }

    public String getNombrealmacen() {
        return nombrealmacen;
    }

    public void setNombrealmacen(String nombrealmacen) {
        this.nombrealmacen = nombrealmacen;
    }

    public String getDireccionalmacen() {
        return direccionalmacen;
    }

    public void setDireccionalmacen(String direccionalmacen) {
        this.direccionalmacen = direccionalmacen;
    }

}