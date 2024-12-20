package com.unir.Eventos.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

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
    private Long usuarioId;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    @JsonIgnore
    private Evento evento;

    @JsonProperty("evento_id")
    public Long getEventoId() {
        return evento != null ? evento.getId() : null;
    }

    public Asistencia(Long usuarioId, Evento evento) {
        this.usuarioId = usuarioId;
        this.evento = evento;
    }


}
