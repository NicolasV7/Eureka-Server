package com.villota.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.villota.service.CommonService;

public class CommonController <E, S extends CommonService<E>> {
  @Autowired
  protected S service;

  @Value("${config.balanceador.test}")
  private String balanceadorTest;

  @GetMapping("/balanceadorTest")
  public ResponseEntity<?> balanceadorTest(){
    Map<String, Object> response = new HashMap<String, Object>();
    response.put("balanceador", balanceadorTest);
    response.put("alumnos", service.findAll());

    return ResponseEntity.ok(response);
  }

  @GetMapping("/listarAlumnos")
  public ResponseEntity<?> listarAlumnos(){
    return ResponseEntity.ok().body(service.findAll());
  }

  @GetMapping("/buscarAlumno/{id}")
  public ResponseEntity<?> buscarAlumno(@PathVariable Long id){
    Optional<?> alumno = service.findById(id);

    if(alumno.isEmpty()){
      return ResponseEntity.notFound().build();
    }
    return ResponseEntity.ok().body(alumno);
  }

  @PostMapping("/guardarAlumno")
  public ResponseEntity<?> guardarAlumno(@RequestBody E alumno){
    E alumnoGuardado = service.save(alumno);
    return ResponseEntity.ok().body(alumnoGuardado);
  }

  @DeleteMapping("/eliminarAlumno/{id}")
  public ResponseEntity<?> eliminarAlumno(@PathVariable Long id){
    service.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
