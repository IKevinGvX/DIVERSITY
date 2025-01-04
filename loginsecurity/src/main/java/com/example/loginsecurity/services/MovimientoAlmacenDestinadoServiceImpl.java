package com.example.loginsecurity.services;

import com.example.loginsecurity.model.MovimientoAlmacenDestinado;
import com.example.loginsecurity.repository.MovimientoAlmacenDestinadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoAlmacenDestinadoServiceImpl implements MovimientoAlmacenDestinadoService {

    @Autowired
    private MovimientoAlmacenDestinadoRepository repository;

    @Override
    public List<MovimientoAlmacenDestinado> getAllMovimientos() {
        return repository.findAll();
    }

    @Override
    public void guardarMovimiento(MovimientoAlmacenDestinado movimiento) {
        repository.save(movimiento);
    }

    @Override
    public MovimientoAlmacenDestinado obtenerMovimientoPorId(Integer id) {
        Optional<MovimientoAlmacenDestinado> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("Movimiento no encontrado con ID: " + id);
        }
    }

    @Override
    public MovimientoAlmacenDestinado actualizarMovimiento(MovimientoAlmacenDestinado movimiento) {
        return repository.save(movimiento);
    }

    @Override
    public void eliminarMovimiento(Integer id) {
        repository.deleteById(id);
    }
}
