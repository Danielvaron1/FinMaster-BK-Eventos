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
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.getEvento(eventoId));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
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
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.updateEvento(eventoId,body));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{eventoId}")
    public ResponseEntity<Evento> deleteEvento(@PathVariable String eventoId) throws Exception {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.deleteEvento(eventoId));
        } catch (Exception e) {
            log.error("Error deleting event"+e);
            return ResponseEntity.badRequest().build();
        }
    }

}
