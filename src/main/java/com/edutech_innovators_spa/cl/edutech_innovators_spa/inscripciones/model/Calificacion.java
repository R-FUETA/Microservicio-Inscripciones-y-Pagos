package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "calificaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Calificacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idInscripcion;
    private int puntaje;
    private String comentario;
}
