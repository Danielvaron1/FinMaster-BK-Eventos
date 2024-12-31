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
        try{
            return ResponseEntity.status(HttpStatus.OK).body(service.getAsistencias(eventoId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/{eventoId}/Asistencias")
    public ResponseEntity<Asistencia> createAsistencia(@PathVariable String eventoId,@RequestParam String usuarioId) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(service.createAsistencia(eventoId,usuarioId));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{eventoId}/Asistencias")
    public ResponseEntity<Asistencia> deleteAsistencia(@PathVariable String eventoId, @RequestParam String usuarioId) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(service.deleteAsistencia(eventoId, usuarioId));
    }
}
