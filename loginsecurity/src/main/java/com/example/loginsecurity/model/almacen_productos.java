package com.example.loginsecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "almacen_productos")
public class almacen_productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long almproid;
    private Integer productoid, almacenid;
    private String fechaenvio, estado;

    public Long getAlmproid() {
        return almproid;
    }

    public void setAlmproid(Long almproid) {
        this.almproid = almproid;
    }

    public Integer getProductoid() {
        return productoid;
    }

    public void setProductoid(Integer productoid) {
        this.productoid = productoid;
    }

    public Integer getAlmacenid() {
        return almacenid;
    }

    public void setAlmacenid(Integer almacenid) {
        this.almacenid = almacenid;
    }

    public String getFechaenvio() {
        return fechaenvio;
    }

    public void setFechaenvio(String fechaenvio) {
        this.fechaenvio = fechaenvio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}