package com.unir.Eventos.service;

import com.unir.Eventos.data.ComentariosJpaRepository;
import com.unir.Eventos.model.db.Comentario;
import com.unir.Eventos.model.db.Evento;
import com.unir.Eventos.model.request.ComentarioRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ComentariosService {

    @Autowired
    private ComentariosJpaRepository comentariosRepository;

    @Autowired
    @Lazy
    private EventosService eventosService;

    public List<Comentario> getComentarios(String eventoId) throws Exception {
        Evento evento = eventosService.getEvento(eventoId);
        return comentariosRepository.findAllByEventoOrderByFechaDesc(evento);
    }

    public Comentario getComentario(String eventoId, String comentarioId) throws Exception {
        Evento evento = eventosService.getEvento(eventoId);
        return comentariosRepository.findByIdAndEvento(Long.valueOf(comentarioId), evento);
    }

    public Comentario createComentario(String eventoId, ComentarioRequest comentario) throws Exception {

        Evento evento = eventosService.getEvento(eventoId);
        Comentario comentarioDb = new Comentario(evento, comentario.getUsuarioId(), comentario.getComentario(), comentario.getUsuarioNombre());
        return comentariosRepository.save(comentarioDb);
    }

    public Comentario updateComentario(String eventoId, String comentarioId, String comentario) throws Exception {
        Comentario comentarioDb = getComentario(eventoId, comentarioId);
        if (comentarioDb!= null) {
            comentarioDb.setComentario(comentario);
            return comentariosRepository.save(comentarioDb);
        } else {
            throw new Exception("Comentario no encontrado");
        }
    }

    public Comentario deleteComentario(String eventoId, String comentarioId) throws Exception {
        Comentario comentarioDb = getComentario(eventoId, comentarioId);
        if (comentarioDb!= null) {
            comentariosRepository.delete(comentarioDb);
            return comentarioDb;
        } else {
            throw new Exception("Comentario no encontrado");
        }
    }


    public void deleteComentarios(List<Comentario> comentarios) {
        comentariosRepository.deleteAll(comentarios);
    }
}
