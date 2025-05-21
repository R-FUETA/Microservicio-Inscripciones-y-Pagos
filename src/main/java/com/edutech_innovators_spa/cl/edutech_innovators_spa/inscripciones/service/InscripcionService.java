package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.service;

import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model.Cupon;
import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model.Inscripcion;
import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.repository.CuponRepository;
import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Autowired
    private CuponRepository cuponRepository;

    public Inscripcion registrarInscripcion(Long idCurso, Long idEstudiante, Double monto, String codigoCupon) {
        Cupon cupon = null;
        if (codigoCupon != null) {
            cupon = cuponRepository.findByCodigo(codigoCupon)
                    .filter(Cupon::isActivo)
                    .orElse(null);
            if (cupon != null) {
                monto = monto - (monto * cupon.getPorcentajeDescuento() / 100);
            }
        }
        Inscripcion inscripcion = Inscripcion.builder()
                .idCurso(idCurso)
                .idEstudiante(idEstudiante)
                .fechaInscripcion(LocalDate.now())
                .montoPagado(monto)
                .cupon(cupon)
                .finalizado(false)
                .progreso(0.0)
                .build();
        return inscripcionRepository.save(inscripcion);
    }

    public List<Inscripcion> listarPorEstudiante(Long idEstudiante) {
        return inscripcionRepository.findByIdEstudiante(idEstudiante);
    }
}
