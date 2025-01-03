package com.example.loginsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.almacen_productos;
import com.example.loginsecurity.repository.almacen_productosreposiroty;

@Service
public class almacen_productosServiceImpl implements almacen_productosservice {
    @Autowired
    private almacen_productosreposiroty almacenrepository;

    @Override
    public List<almacen_productos> getallalmpro() {
        return almacenrepository.findAll();
    }

    @Override
    public void savealmprod(almacen_productos emp) {
        this.almacenrepository.save(emp);
    }

    @Override
    public almacen_productos getalmprodbyid(long id) {
        Optional<almacen_productos> optional = almacenrepository.findById(id);
        almacen_productos cli = null;
        if (optional.isPresent()) {
            cli = optional.get();
        } else {
            throw new RuntimeException("Empleado no enocontrado por id : " + id);
        }
        return cli;
    }

    @Override
    public almacen_productos updatepromalm(almacen_productos cliupdate) {
        Optional<almacen_productos> optional = almacenrepository.findById(cliupdate.getAlmproid());

        if (optional.isPresent()) {
            almacen_productos proalmexists = optional.get();
            proalmexists.setAlmacenid(cliupdate.getAlmacenid());
            proalmexists.setProductoid(cliupdate.getProductoid());
            proalmexists.setEstado(cliupdate.getEstado());
            proalmexists.setFechaenvio(cliupdate.getFechaenvio());
            return almacenrepository.save(proalmexists);
        } else {
            throw new RuntimeException(
                    "No se puede actualizar. Empleado no encontrado con id: " + cliupdate.getAlmproid());
        }
    }

    @Override
    public void deletealmprobyid(long id) {
        this.almacenrepository.deleteById(id);
    }
}
