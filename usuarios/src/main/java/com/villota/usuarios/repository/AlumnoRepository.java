package com.villota.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.villota.usuarios.entity.Alumno;

@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long>{
  
}
