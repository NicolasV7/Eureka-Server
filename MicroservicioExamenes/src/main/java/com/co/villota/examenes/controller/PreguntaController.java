package com.co.villota.examenes.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.villota.common.controller.CommonController;
import com.co.villota.common.usuario.models.entity.Pregunta;
import com.co.villota.examenes.service.PreguntaService;

@RestController
public class PreguntaController extends CommonController<Pregunta, PreguntaService>{
	
	private PreguntaService preguntaService;
	
	@PutMapping("/editarPregunta/{id}")
    public ResponseEntity<?> editar(@RequestBody Pregunta pregunta, @PathVariable Long id){
        Optional <Pregunta> ob = service.findById(id);

        if(ob.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        Pregunta preguntaDB = ob.get();
        preguntaDB.setTexto(pregunta.getTexto());
        preguntaDB.setExamen(pregunta.getExamen());
        

        return ResponseEntity.status(HttpStatus.CREATED).body(preguntaService.save(preguntaDB));
    }

}
