package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cupones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String codigo;
    private Double porcentajeDescuento;
    private boolean activo;
}
