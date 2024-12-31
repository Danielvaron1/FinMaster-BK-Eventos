package com.unir.Eventos.model.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioRequest {

    @NotEmpty
    @NotNull
    private Long usuarioId;

    @NotEmpty
    @NotNull
    private String comentario;

    @NotEmpty
    @NotNull
    private String usuarioNombre;

}
