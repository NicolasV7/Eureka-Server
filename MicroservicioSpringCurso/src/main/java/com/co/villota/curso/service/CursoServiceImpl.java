package com.co.villota.curso.service;

import org.springframework.stereotype.Service;


import com.co.villota.common.service.CommonService;
import com.co.villota.common.service.implementation.CommonServiceImpl;
import com.co.villota.common.usuario.models.entity.Curso;
import com.co.villota.curso.repository.CursoRepository;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository> implements CommonService<Curso>{

}
