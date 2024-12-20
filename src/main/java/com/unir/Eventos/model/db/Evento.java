package com.unir.Eventos.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    private Long usuarioId;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "precio", nullable = false)
    private Long precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;


    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Comentario> comentarios;


    @OneToMany(mappedBy = "evento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Asistencia> asistencias;
}
