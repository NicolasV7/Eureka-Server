package com.villota.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.villota.commons.controller.CommonController;
import com.villota.common.usuario.entity.Alumno;
import com.villota.common.usuario.entity.Curso;
import com.villota.service.CursoService;


@RestController
public class CursoController extends CommonController<Curso, CursoService> {
	@PutMapping("/asignarAlumno/{id}")
    public ResponseEntity<?> asignarAlumno(@PathVariable Long id, @RequestBody List<Alumno> alumnos) {
        Optional<Curso> cursoGuardado = service.findById(id);

        if (cursoGuardado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoActualizado = cursoGuardado.get();
        alumnos.forEach(alumno -> {
        	cursoActualizado.addAlumno(alumno);
        });

        return ResponseEntity.status(HttpStatus.OK).body(service.save(cursoActualizado));
    }
	
	@PutMapping("/eliminarAlumno/{id}")
    public ResponseEntity<?> eliminarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
        Optional<Curso> cursoGuardado = service.findById(id);

        if (cursoGuardado.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        Curso cursoActualizado = cursoGuardado.get();
        cursoActualizado.removeAlumno(alumno);

        return ResponseEntity.status(HttpStatus.OK).body(service.save(cursoActualizado));
    }
}
