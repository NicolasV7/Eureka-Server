package com.villota.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.villota.service.CommonService;

public class CommonServiceImpl <E , R extends CrudRepository<E, Long>> implements CommonService<E>{

  @Autowired
  private R alumnoRepository;

  @Override
  @Transactional(readOnly = true)
  public Iterable<E> findAll() {
    return alumnoRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true)
  public Optional<E> findById(Long id) {
    return alumnoRepository.findById(id);
  }

  @Override
  @Transactional
  public E save(E entity) {
    return alumnoRepository.save(entity);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    alumnoRepository.deleteById(id);
  }
}
