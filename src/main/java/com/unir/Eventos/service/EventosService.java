package com.unir.Eventos.service;

import com.unir.Eventos.data.EventosJpaRepository;
import com.unir.Eventos.model.db.Asistencia;
import com.unir.Eventos.model.db.Comentario;
import com.unir.Eventos.model.db.Evento;
import com.unir.Eventos.model.request.EventoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class EventosService {

    @Autowired
    private EventosJpaRepository eventosRepository;

    @Autowired
    @Lazy
    private AsistenciasService asistenciasService;

    @Autowired
    @Lazy
    private ComentariosService comentariosService;

    public Evento createEvento(EventoRequest request){
        Evento evento = new Evento();
        BeanUtils.copyProperties(request, evento);
        return eventosRepository.save(evento);
    }

    public List<Evento> getEventos(String usuarioId,String ciudad) {
        LocalDateTime hoy = LocalDateTime.now();
        if(StringUtils.hasLength(usuarioId)){
            return eventosRepository.findByUsuarioIdAndFechaAfterOrderByFechaAsc(Long.valueOf(usuarioId),hoy);
        } else if (StringUtils.hasLength(ciudad)) {
            return eventosRepository.findByCiudadAndFechaAfterOrderByFechaAsc(ciudad,hoy);
        } else{
            return eventosRepository.findAll();
        }
    }

    public List<Evento> getEventosFecha(String usuarioId, String ciudad) {
        LocalDateTime hoy = LocalDateTime.now();
        if(StringUtils.hasLength(usuarioId)){
            return eventosRepository.findByUsuarioIdAndFechaBeforeOrderByFechaAsc(Long.valueOf(usuarioId),hoy);
        } else if (StringUtils.hasLength(ciudad)) {
            return eventosRepository.findByCiudadAndFechaBeforeOrderByFechaAsc(ciudad, hoy);
        } else{
            return eventosRepository.findAll();
        }
    }

    public Evento getEvento(String eventoId) throws Exception{
        Evento evento =eventosRepository.findById(Long.valueOf(eventoId)).orElse(null);
        if(evento==null){
            throw new Exception("Evento no encontrado");
        }
        return evento;
    }

    public Evento updateEvento(String eventoId, EventoRequest request) throws Exception {
        Evento evento = getEvento(eventoId);
        if (evento!= null) {
            BeanUtils.copyProperties(request, evento);
            return eventosRepository.save(evento);
        } else {
            throw new Exception("Evento no encontrado");
        }
    }

    public Evento deleteEvento(String eventoId) throws Exception {
        List<Asistencia> asistencias =  asistenciasService.getAsistencias(eventoId);
        if (!asistencias.isEmpty()) {
            asistenciasService.deleteAsistencias(asistencias);
        }
        List<Comentario> comentarios =  comentariosService.getComentarios(eventoId);
        if (!comentarios.isEmpty()) {
            comentariosService.deleteComentarios(comentarios);
        }
        Evento evento = getEvento(eventoId);
        if (evento!= null) {
            eventosRepository.delete(evento);
            return evento;
        } else {
            throw new Exception("Evento no encontrado");
        }
    }

}
