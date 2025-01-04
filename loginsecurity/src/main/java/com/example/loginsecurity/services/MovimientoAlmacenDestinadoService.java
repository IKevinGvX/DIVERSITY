package com.example.loginsecurity.services;

import com.example.loginsecurity.model.MovimientoAlmacenDestinado;

import java.util.List;

public interface MovimientoAlmacenDestinadoService {
    List<MovimientoAlmacenDestinado> getAllMovimientos();

    void guardarMovimiento(MovimientoAlmacenDestinado movimiento);

    MovimientoAlmacenDestinado obtenerMovimientoPorId(Integer id);

    MovimientoAlmacenDestinado actualizarMovimiento(MovimientoAlmacenDestinado movimiento);

    void eliminarMovimiento(Integer id);
}
