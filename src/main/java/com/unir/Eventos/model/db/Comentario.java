package com.unir.Eventos.model.db;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

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
    @JsonIgnore
    private Evento evento;

    @Column(name = "usuario_id", nullable = false)
    private Long usuarioId;

    @Column(name = "usuario_nombre", nullable = false)
    private String usuarioNombre;

    @Column(name = "comentario",length = 1000, nullable = false)
    private String comentario;

    @Column(name = "fecha", nullable = false)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime fecha;

    @JsonProperty("evento_id")
    public Long getEventoId() {
        return evento != null ? evento.getId() : null;
    }

    public Comentario(Evento evento, Long usuarioId, String comentario, String usuarioNombre) {
        this.evento = evento;
        this.usuarioId = usuarioId;
        this.comentario = comentario;
        this.usuarioNombre = usuarioNombre;
        this.fecha = LocalDateTime.now();
    }
}