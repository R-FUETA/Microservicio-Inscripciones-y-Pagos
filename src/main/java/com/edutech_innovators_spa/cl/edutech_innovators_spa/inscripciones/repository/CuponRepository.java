package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.repository;

import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model.Cupon;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CuponRepository extends JpaRepository<Cupon, Long> {
    Optional<Cupon> findByCodigo(String codigo);
}
