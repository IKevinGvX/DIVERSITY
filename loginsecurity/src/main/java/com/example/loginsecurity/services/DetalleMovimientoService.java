package com.example.loginsecurity.services;

import java.util.List;

import com.example.loginsecurity.model.DetalleMovimiento;

public interface DetalleMovimientoService {
    List<DetalleMovimiento> getAllDetalleMovimientos();

    void saveDetalleMovimiento(DetalleMovimiento detalle);

    DetalleMovimiento getDetalleMovimientoById(long id);

    void deleteDetalleMovimientoById(long id);

    DetalleMovimiento updateDetalleMovimiento(DetalleMovimiento detalle);
}
