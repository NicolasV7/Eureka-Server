package com.villota.usuario.repository;


import org.springframework.data.repository.CrudRepository;


import com.villota.usuario.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository <Alumno, Long>{

}
