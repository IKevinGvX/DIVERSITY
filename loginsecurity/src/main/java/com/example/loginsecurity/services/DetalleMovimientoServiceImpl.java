package com.example.loginsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.DetalleMovimiento;
import com.example.loginsecurity.repository.DetalleMovimientoRepository;

@Service
public class DetalleMovimientoServiceImpl implements DetalleMovimientoService {

    @Autowired
    private DetalleMovimientoRepository repository;

    @Override
    public List<DetalleMovimiento> getAllDetalleMovimientos() {
        return repository.findAll();
    }

    @Override
    public void saveDetalleMovimiento(DetalleMovimiento detalle) {
        repository.save(detalle);
    }

    @Override
    public DetalleMovimiento getDetalleMovimientoById(long id) {
        Optional<DetalleMovimiento> optional = repository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new RuntimeException("DetalleMovimiento no encontrado por id: " + id);
        }
    }

    @Override
    public void deleteDetalleMovimientoById(long id) {
        repository.deleteById(id);
    }

    @Override
    public DetalleMovimiento updateDetalleMovimiento(DetalleMovimiento detalle) {
        Optional<DetalleMovimiento> optional = repository.findById(detalle.getDetalle_movimiento_id());

        if (optional.isPresent()) {
            DetalleMovimiento existente = optional.get();
            existente.setAlmacen_id(detalle.getAlmacen_id());
            existente.setMovimiento_id(detalle.getMovimiento_id());
            existente.setPrecio(detalle.getPrecio());
            existente.setCantidad(detalle.getCantidad());
            existente.setSubtotal(detalle.getSubtotal());
            existente.setFecha(detalle.getFecha());
            existente.setProducto_id(detalle.getProducto_id());
            return repository.save(existente);
        } else {
            throw new RuntimeException("No se puede actualizar. DetalleMovimiento no encontrado con id: " + detalle.getDetalle_movimiento_id());
        }
    }
}
