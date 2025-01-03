package com.unir.Eventos.contoller;

import com.unir.Eventos.model.db.Comentario;
import com.unir.Eventos.model.request.ComentarioRequest;
import com.unir.Eventos.service.ComentariosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/Eventos")
public class ComentariosController {

    private final ComentariosService service;

    @GetMapping("/{eventoId}/Comentarios")
    public ResponseEntity<List<Comentario>> getComentarios(@PathVariable String eventoId) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getComentarios(eventoId));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/{eventoId}/Comentarios")
    public ResponseEntity<Comentario> createComentario(@PathVariable String eventoId,@RequestBody ComentarioRequest request) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createComentario(eventoId,request));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/{eventoId}/Comentarios/{comentarioId}")
    public ResponseEntity<Comentario> updateComentario(@PathVariable String eventoId,@PathVariable String comentarioId,@RequestBody Map<String, String> comentario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.updateComentario(eventoId,comentarioId,comentario.get("comentario")));
    }

    @DeleteMapping("/{eventoId}/Comentarios/{comentarioId}")
    public ResponseEntity<Comentario> deleteComentario(@PathVariable String eventoId, @PathVariable String comentarioId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteComentario(eventoId,comentarioId));
    }
}
