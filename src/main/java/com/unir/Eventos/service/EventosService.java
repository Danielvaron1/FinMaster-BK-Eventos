package com.unir.Eventos.service;

import com.unir.Eventos.data.EventosJpaRepository;
import com.unir.Eventos.model.db.Evento;
import com.unir.Eventos.model.request.EventoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@Slf4j
public class EventosService {

    @Autowired
    private EventosJpaRepository eventosRepository;

    public Evento createEvento(EventoRequest request){
        Evento evento = new Evento();
        BeanUtils.copyProperties(request, evento);
        return eventosRepository.save(evento);
    }

    public List<Evento> getEventos(String usuarioId,String ciudad) {
        if(StringUtils.hasLength(usuarioId)){
            return eventosRepository.findByUsuarioId(Long.valueOf(usuarioId));
        } else if (StringUtils.hasLength(ciudad)) {
            return eventosRepository.findByCiudad(ciudad);
        } else{
            return eventosRepository.findAll();
        }
    }

    public Evento getEvento(String eventoId) {
        return eventosRepository.findById(Long.valueOf(eventoId)).orElse(null);
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
        Evento evento = getEvento(eventoId);
        if (evento!= null) {
            eventosRepository.delete(evento);
            return evento;
        } else {
            throw new Exception("Evento no encontrado");
        }
    }

}
