package com.unir.Eventos.service;

import com.unir.Eventos.data.ComentariosJpaRepository;
import com.unir.Eventos.model.db.Comentario;
import com.unir.Eventos.model.db.Evento;
import com.unir.Eventos.model.request.ComentarioRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ComentariosService {

    @Autowired
    private ComentariosJpaRepository comentariosRepository;

    @Autowired
    private EventosService eventosService;

    public List<Comentario> getComentarios(String eventoId) {
        Evento evento = eventosService.getEvento(eventoId);
        return comentariosRepository.findAllByEvento(evento);
    }

    public Comentario getComentario(String eventoId, String comentarioId) {
        Evento evento = eventosService.getEvento(eventoId);
        return comentariosRepository.findByIdAndEvento(Long.valueOf(comentarioId), evento);
    }

    public Comentario createComentario(String eventoId, ComentarioRequest comentario) {
        Evento evento = eventosService.getEvento(eventoId);
        Comentario comentarioDb = new Comentario(evento, comentario.getUsuarioId(), comentario.getComentario());
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


}
