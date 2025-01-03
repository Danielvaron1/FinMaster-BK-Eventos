package com.unir.Eventos.data;

import com.unir.Eventos.model.db.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDateTime;
import java.util.List;

public interface EventosJpaRepository extends JpaRepository<Evento, Long>, JpaSpecificationExecutor<Evento> {

    List<Evento> findByCiudadAndFechaAfterOrderByFechaAsc(String ciudad,LocalDateTime fecha);

    List<Evento> findByUsuarioIdAndFechaAfterOrderByFechaAsc(Long usuarioId, LocalDateTime fecha);

    List<Evento> findByCiudadAndFechaBeforeOrderByFechaAsc(String ciudad,LocalDateTime fecha);

    List<Evento> findByUsuarioIdAndFechaBeforeOrderByFechaAsc(Long usuarioId, LocalDateTime fecha);
}
