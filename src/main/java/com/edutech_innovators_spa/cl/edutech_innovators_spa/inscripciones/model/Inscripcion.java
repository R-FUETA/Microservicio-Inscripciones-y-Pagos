package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "inscripciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inscripcion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCurso;
    private Long idEstudiante;
    private LocalDate fechaInscripcion;
    private Double montoPagado;
    @ManyToOne
    @JoinColumn(name = "cupon_id")
    private Cupon cupon;
    private boolean finalizado;
    private Double progreso;
}
