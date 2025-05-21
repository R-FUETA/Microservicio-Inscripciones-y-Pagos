package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.controller;

import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model.Inscripcion;
import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public Inscripcion inscribir(@RequestParam Long idCurso,
                                  @RequestParam Long idEstudiante,
                                  @RequestParam Double monto,
                                  @RequestParam(required = false) String cupon) {
        return inscripcionService.registrarInscripcion(idCurso, idEstudiante, monto, cupon);
    }

    @GetMapping("/estudiante/{id}")
    public List<Inscripcion> listarPorEstudiante(@PathVariable Long id) {
        return inscripcionService.listarPorEstudiante(id);
    }
}
