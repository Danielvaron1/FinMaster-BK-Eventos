package com.unir.Eventos.contoller;

import com.unir.Eventos.model.db.Evento;
import com.unir.Eventos.model.request.EventoRequest;
import com.unir.Eventos.service.EventosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/Eventos")
public class EventosController {

    private final EventosService service;

    @GetMapping
    public ResponseEntity<List<Evento>> getEventos(@RequestParam(required= false) String usuarioId, @RequestParam(required= false) String ciudad) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEventos(usuarioId,ciudad));
    }

    @GetMapping("/{eventoId}")
    public ResponseEntity<Evento> getEvento(@PathVariable String eventoId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getEvento(eventoId));
    }

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody EventoRequest request) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createEvento(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{eventoId}")
    public ResponseEntity<Evento> updateEvento(@PathVariable String eventoId, @RequestBody EventoRequest body) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateEvento(eventoId,body));
    }

    @DeleteMapping("/{eventoId}")
    public ResponseEntity<Evento> deleteEvento(@PathVariable String eventoId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteEvento(eventoId));
    }

}
