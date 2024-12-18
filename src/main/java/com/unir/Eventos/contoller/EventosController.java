package com.unir.Eventos.contoller;

import com.unir.Eventos.model.db.Evento;
import com.unir.Eventos.model.request.EventoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/Eventos")
public class EventosController {

    @GetMapping
    public ResponseEntity<String> getEventos(@RequestParam(required= false) String usuarioId) {
        return ResponseEntity.status(HttpStatus.OK).body("Eventos listados correctamente");
    }

    @GetMapping("/{eventoId}")
    public ResponseEntity<Evento> getEvento(@PathVariable String eventoId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Evento> createEvento(@RequestBody EventoRequest request) {
        return null;
    }

    @PutMapping("/{eventoId}")
    public ResponseEntity<Evento> updateEvento(@PathVariable String eventoId, @RequestBody EventoRequest body) {
        return null;
    }

    @DeleteMapping("/{eventoId}")
    public ResponseEntity<Evento> deleteEvento(@PathVariable String eventoId) {
        return null;
    }

}
