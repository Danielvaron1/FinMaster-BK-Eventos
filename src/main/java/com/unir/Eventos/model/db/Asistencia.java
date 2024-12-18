package com.unir.Eventos.model.db;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "asistencias")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Asistencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usuario_id", nullable = false)
    @NotNull
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;


}
