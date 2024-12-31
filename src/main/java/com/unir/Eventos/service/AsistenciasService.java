package com.unir.Eventos.service;

import com.unir.Eventos.data.AsistenciasJpaRepository;
import com.unir.Eventos.model.db.Asistencia;
import com.unir.Eventos.model.db.Evento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AsistenciasService {
    @Autowired
    private AsistenciasJpaRepository asistenciasRepository;

    @Autowired
    @Lazy
    private EventosService eventosService;

    public List<Asistencia> getAsistencias(String eventoId) throws Exception {
        try {
            Evento evento = eventosService.getEvento(eventoId);
            return asistenciasRepository.findByEvento(evento);
        } catch (Exception e) {
            throw new Exception("Evento no encontrado");
        }
    }

    public Asistencia createAsistencia(String eventoId, String usuarioId) throws Exception {
        try {
            Evento evento = eventosService.getEvento(eventoId);
            Asistencia asistencia = new Asistencia(Long.valueOf(usuarioId),evento);
            return asistenciasRepository.save(asistencia);
        } catch (Exception e) {
            throw new Exception("Evento no encontrado");
        }

    }

    public Asistencia deleteAsistencia(String eventoId, String usuarioId) throws Exception {
        Evento evento = eventosService.getEvento(eventoId);
        Asistencia asistencia = asistenciasRepository.findByUsuarioIdAndEvento(Long.valueOf(usuarioId), evento);
        if(asistencia!= null){
            asistenciasRepository.delete(asistencia);
            return asistencia;
        } else {
            throw new Exception("No se encontro asistencia");
        }
    }

    public void deleteAsistencias(List<Asistencia> asistencias) {
        asistenciasRepository.deleteAll(asistencias);
    }
}
