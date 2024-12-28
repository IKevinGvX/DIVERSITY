package com.example.loginsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.Clientes;
import com.example.loginsecurity.repository.ClienteRepository;

@Service
public class ClientesServiceImpl implements ClienteServices {
    @Autowired
    private ClienteRepository clirepository;

    @Override
    public List<Clientes> getallcliente() {
        return clirepository.findAll();
    }

    @Override
    public void saveclients(Clientes emp) {
        this.clirepository.save(emp);
    }

    @Override
    public Clientes getclientebyid(long id) {
        Optional<Clientes> optional = clirepository.findById(id);
        Clientes cli = null;
        if (optional.isPresent()) {
            cli = optional.get();
        } else {
            throw new RuntimeException("Empleado no enocontrado por id : " + id);
        }
        return cli;
    }

    @Override
    public Clientes updatecliente(Clientes cliupdate) {
        Optional<Clientes> optional = clirepository.findById(cliupdate.getCliente_id());

        if (optional.isPresent()) {
            Clientes Empleadiexists = optional.get();
            Empleadiexists.setUsuario_id(cliupdate.getUsuario_id());
            Empleadiexists.setNombre(cliupdate.getNombre());
            Empleadiexists.setApellido(cliupdate.getApellido());
            Empleadiexists.setFecha_nac(cliupdate.getFecha_nac());
            Empleadiexists.setDni(cliupdate.getDni());
            Empleadiexists.setCorreo(cliupdate.getCorreo());
            Empleadiexists.setTelefono(cliupdate.getTelefono());
            Empleadiexists.setDireccion(cliupdate.getDireccion());

            return clirepository.save(Empleadiexists);
        } else {
            throw new RuntimeException(
                    "No se puede actualizar. Empleado no encontrado con id: " + cliupdate.getCliente_id());
        }
    }

    @Override
    public void deleteclientebyid(long id) {
        this.clirepository.deleteById(id);
    }
}
