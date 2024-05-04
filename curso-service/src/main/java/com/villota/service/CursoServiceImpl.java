package com.villota.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.villota.commons.service.CommonService;
import com.villota.commons.service.CommonServiceImpl;
import com.villota.common.usuario.entity.Curso;
import com.villota.curso.repository.CursoRepository;


@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CommonService<Curso> {
	@Override
	public Iterable<Curso> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Curso> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Curso save(Curso entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
	}
}
