package com.villota.usuarios.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.villota.usuarios.entity.Alumno;
import com.villota.usuarios.repository.AlumnoRepository;
import com.villota.usuarios.service.AlumnoService;


@Service
public class AlumnoServiceImpl implements AlumnoService{
  private AlumnoRepository alumnoRepository;

  @Override
  @Transactional(readOnly = true)
  public Iterable<Alumno> findAll() {
    return alumnoRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<Alumno> findById(Long id) {
    return alumnoRepository.findById(id);
  }

  @Override
  @Transactional
  public Alumno save(Alumno alumno) {
    return alumnoRepository.save(alumno);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    alumnoRepository.deleteById(id);
  }
}
