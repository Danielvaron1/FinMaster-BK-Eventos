package com.unir.Eventos.contoller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/v1/Eventos")
public class EventosController {

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<String> getEventos() {
        return ResponseEntity.status(HttpStatus.OK).body("Eventos listados correctamente");
    }
}
