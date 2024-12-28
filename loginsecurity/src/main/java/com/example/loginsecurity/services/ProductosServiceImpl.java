package com.example.loginsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.Productos;
import com.example.loginsecurity.repository.ProductoRepository;

@Service
public class ProductosServiceImpl implements ProductoServices {
    @Autowired
    private ProductoRepository prorepository;

    @Override
    public List<Productos> getProductsWithLowStock(int stockMinimo) {
        return prorepository.findByStockLessThan(stockMinimo);
    }

    @Override
    public long gettotalproducts() {
        return prorepository.count();
    }

    @Override
    public List<Productos> getallproducts() {
        return prorepository.findAll();
    }

    @Override
    public void saveproducts(Productos emp) {
        this.prorepository.save(emp);
    }

    @Override
    public Productos getproductsbyid(long id) {
        Optional<Productos> optional = prorepository.findById(id);
        Productos cli = null;
        if (optional.isPresent()) {
            cli = optional.get();
        } else {
            throw new RuntimeException("Empleado no enocontrado por id : " + id);
        }
        return cli;
    }

    @Override
    public Productos updateproducts(Productos productsupds) {
        Optional<Productos> optional = prorepository.findById(productsupds.getProducto_id());

        if (optional.isPresent()) {
            Productos produexists = optional.get();
            produexists.setNombre_producto(productsupds.getNombre_producto());
            produexists.setDescripcion(productsupds.getDescripcion());
            produexists.setPrecio(productsupds.getPrecio());
            produexists.setStock(productsupds.getStock());
            produexists.setIdcategoria(productsupds.getIdcategoria());

            return prorepository.save(produexists);
        } else {
            throw new RuntimeException(
                    "No se puede actualizar. Empleado no encontrado con id: " + productsupds.getProducto_id());
        }
    }

    @Override
    public void deleteproducts(long id) {
        this.prorepository.deleteById(id);
    }
}
