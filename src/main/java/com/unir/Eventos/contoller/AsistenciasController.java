package com.unir.Eventos.contoller;

import com.unir.Eventos.model.db.Asistencia;
import com.unir.Eventos.service.AsistenciasService;
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
public class AsistenciasController {

    private final AsistenciasService service;

    @GetMapping("/{eventoId}/Asistencias")
    public ResponseEntity<List<Asistencia>> getAsistencias(@PathVariable String eventoId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getAsistencias(eventoId));
    }

    @PostMapping("/{eventoId}/Asistencias")
    public ResponseEntity<Asistencia> createAsistencia(@PathVariable String eventoId,@RequestParam String usuarioId) {
        return ResponseEntity.status(HttpStatus.OK).body(service.createAsistencia(eventoId,usuarioId));
    }

    @DeleteMapping("/{eventoId}/Asistencias")
    public ResponseEntity<Asistencia> deleteAsistencia(@PathVariable String eventoId, @RequestParam String usuarioId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAsistencia(eventoId, usuarioId));
    }
}
