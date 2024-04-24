package com.villota.usuarios.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.villota.usuarios.entity.Alumno;
import com.villota.usuarios.service.AlumnoService;

@RestController
public class AlumnoController {
  @Autowired
  AlumnoService alumnoService;

  @Value("${config.balanceador.test}")
  private String balanceadorTest;

  @GetMapping("/balanceadorTest")
  public ResponseEntity<?> balanceadorTest(){
    Map<String, Object> response = new HashMap<String, Object>();
    response.put("balanceador", balanceadorTest);
    response.put("alumnos", alumnoService.findAll());

    return ResponseEntity.ok(response);
  }

  @GetMapping("/listarAlumnos")
  public ResponseEntity<?> listarAlumnos(){
    return ResponseEntity.ok().body(alumnoService.findAll());
  }

  @GetMapping("/buscarAlumno/{id}")
  public ResponseEntity<?> buscarAlumno(@PathVariable Long id){
    Optional<?> alumno = alumnoService.findById(id);

    if(alumno.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(alumno);
  }

  @PostMapping("/guardarAlumno")
  public ResponseEntity<?> guardarAlumno(@RequestBody Alumno alumno){
    Alumno alumnoGuardado = alumnoService.save(alumno);
    return ResponseEntity.ok().body(alumnoGuardado);
  }

  @PutMapping("/actualizarAlumno/{id}")
  public ResponseEntity<?> actualizarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
    Optional<Alumno> alumnoBuscado = alumnoService.findById(id);

    if(alumnoBuscado.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    Alumno alumnoActualizado = alumnoBuscado.get();
    alumnoActualizado.setNombre(alumno.getNombre());
    alumnoActualizado.setApellido(alumno.getApellido());
    alumnoActualizado.setEmail(alumno.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoActualizado));
  }

  @DeleteMapping("/eliminarAlumno/{id}")
  public ResponseEntity<?> eliminarAlumno(@PathVariable Long id){
    alumnoService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
