package com.unir.Eventos.data;

import com.unir.Eventos.model.db.Comentario;
import com.unir.Eventos.model.db.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ComentariosJpaRepository extends JpaRepository<Comentario, Long>, JpaSpecificationExecutor<Comentario> {

    List<Comentario> findAllByEventoOrderByFechaDesc(Evento evento);

    Comentario findByIdAndEvento(Long id, Evento evento);
}
