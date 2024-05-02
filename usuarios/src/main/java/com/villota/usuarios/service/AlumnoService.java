package com.villota.usuarios.service;

import com.villota.usuarios.entity.Alumno;
public interface AlumnoService extends CommonService<Alumno>{
  public Alumno save(Alumno alumno);
  public void deleteById(Long id);
}
