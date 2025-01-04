package com.example.loginsecurity.repository;

import com.example.loginsecurity.model.MovimientoAlmacenDestinado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimientoAlmacenDestinadoRepository extends JpaRepository<MovimientoAlmacenDestinado, Integer> {
}
