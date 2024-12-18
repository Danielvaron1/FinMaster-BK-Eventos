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
public class AsistenciasController {
    @GetMapping("/{eventoId}/Asistencias")
    public ResponseEntity<String> getAsistencias(@PathVariable String eventoId) {
        return ResponseEntity.status(HttpStatus.OK).body("Asistencias del evento");
    }

    @GetMapping("/{eventoId}/Asistencias/{asistenciaId}")
    public ResponseEntity<Evento> getAsistencia(@PathVariable String eventoId, @PathVariable String asistenciaId) {
        return null;
    }

    @PostMapping("/{eventoId}/Asistencias")
    public ResponseEntity<Evento> createAsistencia(@PathVariable String eventoId,@RequestParam String usuarioId) {
        return null;
    }

    @DeleteMapping("/{eventoId}/Asistencias/{asistenciaId}")
    public ResponseEntity<Evento> deleteAsistencia(@PathVariable String eventoId, @PathVariable String asistenciaId) {
        return null;
    }
}
