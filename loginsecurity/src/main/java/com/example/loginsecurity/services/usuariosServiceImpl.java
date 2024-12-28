package com.example.loginsecurity.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.loginsecurity.model.usuarios;
import com.example.loginsecurity.repository.usuariosrepository;

@Service
public class usuariosServiceImpl implements usuariosservice {
    @Autowired
    private usuariosrepository userepo;

    @Override
    public List<usuarios> getallusers() {
        return userepo.findAll();
    }

    @Override
    public void createusers(usuarios emp) {
        this.userepo.save(emp);
    }

    @Override
    public usuarios getusersbyid(long id) {
        Optional<usuarios> optional = userepo.findById(id);
        usuarios cli = null;
        if (optional.isPresent()) {
            cli = optional.get();
        } else {
            throw new RuntimeException("Usuario no enocontrado por id : " + id);
        }
        return cli;
    }

    @Override
    public usuarios updateusers(usuarios cliupdate) {
        Optional<usuarios> optional = userepo.findById(cliupdate.getUsuario_id());

        if (optional.isPresent()) {
            usuarios usersexists = optional.get();
            usersexists.setEmail(cliupdate.getEmail());
            usersexists.setContrasena(cliupdate.getContrasena());
            usersexists.setRol_id(cliupdate.getRol_id());
            usersexists.setFecha_creacion(cliupdate.getFecha_creacion());

            return userepo.save(usersexists);
        } else {
            throw new RuntimeException(
                    "No se puede actualizar. Empleado no encontrado con id: " + cliupdate.getUsuario_id());
        }
    }

    @Override
    public void deleteusers(long id) {
        this.userepo.deleteById(id);
    }
}
