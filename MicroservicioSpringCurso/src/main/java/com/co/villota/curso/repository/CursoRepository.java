package com.co.villota.curso.repository;

import org.springframework.data.repository.CrudRepository;

import com.co.villota.common.usuario.models.entity.Curso;

public interface CursoRepository extends CrudRepository<Curso, Long> {

}
