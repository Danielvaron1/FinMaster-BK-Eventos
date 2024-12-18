package com.unir.Eventos.model.db;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "comentarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Column(name = "usuario_id", nullable = false)
    @NotNull
    private Long usuarioId;

    @Column(name = "comentario",length = 1000, nullable = false)
    @NotNull
    private String comentario;

    @Column(name = "fecha", nullable = false)
    @NotNull
    private String fecha;
}
