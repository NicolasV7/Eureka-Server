package com.villota.curso.repository;

import org.springframework.data.repository.CrudRepository;

import com.villota.common.usuario.entity.Curso;


public interface CursoRepository extends CrudRepository<Curso, Long> {
}
