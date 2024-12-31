package com.unir.Eventos.model.db;
import jakarta.persistence.*;
import lombok.*;

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
    private String precio;

    @Column(name = "descripcion", nullable = false)
    private String descripcion;

    @Column(name = "fecha", nullable = false)
    private String fecha;

    @Column(name = "ubicacion", nullable = false)
    private String ubicacion;

    @Column(name = "ciudad", nullable = false)
    private String ciudad;
}
