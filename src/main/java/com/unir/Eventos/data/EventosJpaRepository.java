package com.unir.Eventos.data;

import com.unir.Eventos.model.db.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface EventosJpaRepository extends JpaRepository<Evento, Long>, JpaSpecificationExecutor<Evento> {

    List<Evento> findByUsuarioId(Long usuarioId);

    List<Evento> findByCiudad(String ciudad);
}
