package com.co.villota.examenes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.villota.common.controller.CommonController;
import com.co.villota.common.usuario.models.entity.Examen;
import com.co.villota.common.usuario.models.entity.Pregunta;
import com.co.villota.examenes.service.ExamenService;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService>{
	
private ExamenService examenService;
	
	@PutMapping("/editarExamen/{id}")
    public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
        Optional <Examen> ob = service.findById(id);

        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Examen examenDB = ob.get();
        examenDB.setNombre(examen.getNombre());
        examenDB.setCreateAt(examen.getCreateAt());
        examenDB.setPreguntas(examen.getPreguntas());

        return ResponseEntity.status(HttpStatus.CREATED).body(examenService.save(examenDB));
    }
	
	@PutMapping("/{id}/asignar-pregunta")
	public ResponseEntity<?> asignarPregunta(@RequestBody List<Pregunta> pregunta, @PathVariable Long id) {
		
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Examen examenDB = ob.get();
		pregunta.forEach( a -> {
			examenDB.addPregunta(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenDB));
	}
	
	@PutMapping("/{id}/eliminar-pregunta")
	public ResponseEntity<?> asignarPregunta(@RequestBody Pregunta pregunta, @PathVariable Long id) {
		
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Examen examenDB = ob.get();
		
		examenDB.removePregunta(pregunta);
		
	    return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
