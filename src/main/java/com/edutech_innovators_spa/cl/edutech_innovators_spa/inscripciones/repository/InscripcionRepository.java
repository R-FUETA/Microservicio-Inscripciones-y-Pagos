package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.repository;

import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByIdEstudiante(Long idEstudiante);
}
