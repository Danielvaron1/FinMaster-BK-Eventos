package com.unir.Eventos.data;

import com.unir.Eventos.model.db.Asistencia;
import com.unir.Eventos.model.db.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface AsistenciasJpaRepository extends JpaRepository<Asistencia, Long>, JpaSpecificationExecutor<Asistencia> {
    List<Asistencia> findByEvento(Evento evento);

    Asistencia findByUsuarioIdAndEvento(Long aLong, Evento evento);
}
