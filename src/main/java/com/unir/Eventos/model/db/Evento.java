package com.unir.Eventos.model.db;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "eventos")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    @NotNull
    private Long usuarioId;

    @Column(name = "titulo", nullable = false)
    @NotNull
    private String titulo;

    @Column(name = "precio", nullable = false)
    @NotNull
    private Long precio;

    @Column(name = "descripcion", nullable = false)
    @NotNull
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    @NotNull
    private String fecha;

    @Column(name = "ubicacion", nullable = false)
    @NotNull
    private String ubicacion;
}
