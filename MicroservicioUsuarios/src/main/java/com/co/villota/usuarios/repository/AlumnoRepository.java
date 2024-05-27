package com.co.villota.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import com.co.villota.common.usuario.models.entity.Alumno;

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
}
