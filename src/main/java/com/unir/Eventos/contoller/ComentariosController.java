package com.unir.Eventos.contoller;

import com.unir.Eventos.model.db.Evento;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/Eventos")
public class ComentariosController {
    @GetMapping("/{eventoId}/Comentarios")
    public ResponseEntity<String> getComentarios(@PathVariable String eventoId) {
        return ResponseEntity.status(HttpStatus.OK).body("Comentarios del evento");
    }

    @PostMapping("/{eventoId}/Comentarios")
    public ResponseEntity<Evento> createComentario(@PathVariable String eventoId,@RequestParam String usuarioId) {
        return null;
    }

    @DeleteMapping("/{eventoId}/Comentario/{comentarioId}")
    public ResponseEntity<Evento> deleteComentario(@PathVariable String eventoId, @PathVariable String comentarioId) {
        return null;
    }
}
