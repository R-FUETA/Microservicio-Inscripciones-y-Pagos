package com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.controller;

import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.model.Inscripcion;
import com.edutech_innovators_spa.cl.edutech_innovators_spa.inscripciones.service.InscripcionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
@Tag(name = "Inscripciones", description = ("Permite Inscribir a los estudiantes y Visualizar los estudiantes Inscritos en los cursos"))
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;
    @Operation(summary = "Inscribe al Estudiante", description = "Permite Inscribir al Estudiante Al curso")
    @PostMapping
    public Inscripcion inscribir(@RequestParam Long idCurso,
                                  @RequestParam Long idEstudiante,
                                  @RequestParam Double monto,
                                  @RequestParam(required = false) String cupon) {
        return inscripcionService.registrarInscripcion(idCurso, idEstudiante, monto, cupon);
    }
    @Operation(summary = "Estudiantes Inscritos", description = "Permite Visualizar Los estudiantes Inscritos en los Cursos")
    @GetMapping("/estudiante/{id}")
    public List<Inscripcion> listarPorEstudiante(@PathVariable Long id) {
        return inscripcionService.listarPorEstudiante(id);
    }
}
