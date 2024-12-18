package com.unir.Eventos.model.request;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoRequest {

    private Long usuarioId;
    private String titulo;
    private Long precio;
    private String descripcion;
    private String fecha;
    private String ubicacion;
}
