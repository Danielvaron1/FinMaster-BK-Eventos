package com.unir.Eventos.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoRequest {

    @NotEmpty
    @NotNull
    private Long usuarioId;

    @NotEmpty
    @NotNull
    private String titulo;

    @NotEmpty
    @NotNull
    private String precio;

    @NotEmpty
    @NotNull
    private String descripcion;

    @NotEmpty
    @NotNull
    private String fecha;

    @NotEmpty
    @NotNull
    private String ubicacion;

    @NotEmpty
    @NotNull
    private String ciudad;
}