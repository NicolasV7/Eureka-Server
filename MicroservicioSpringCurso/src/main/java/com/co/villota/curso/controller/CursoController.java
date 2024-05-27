package com.co.villota.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.villota.common.controller.CommonController;
import com.co.villota.common.usuario.models.entity.Curso;
import com.co.villota.curso.service.CursoService;
import com.co.villota.common.usuario.models.entity.Alumno;

@RestController
public class CursoController extends CommonController<Curso, CursoService>{
	
	private CursoService cursoService;
	
	@PutMapping("/editarCurso/{id}")
    public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
        Optional <Curso> ob = service.findById(id);

        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Curso cursoDB = ob.get();
        cursoDB.setNombre(curso.getNombre());
        cursoDB.setCreateAt(curso.getCreateAt());

        return ResponseEntity.status(HttpStatus.CREATED).body(cursoService.save(cursoDB));
    }
	
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumno, @PathVariable Long id) {
		
		Optional<Curso> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Curso cursoDB = ob.get();
		alumno.forEach( a -> {
			cursoDB.addAlumnos(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoDB));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> asignarAlumno(@RequestBody Alumno alumno, @PathVariable Long id) {
		
		Optional<Curso> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Curso cursoDB = ob.get();
		
		cursoDB.removeAlumnos(alumno);
		
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
