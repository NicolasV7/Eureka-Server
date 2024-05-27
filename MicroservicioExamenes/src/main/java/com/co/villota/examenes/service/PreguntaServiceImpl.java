package com.co.villota.examenes.service;

import org.springframework.stereotype.Service;

import com.co.villota.common.service.CommonService;
import com.co.villota.common.service.implementation.CommonServiceImpl;
import com.co.villota.common.usuario.models.entity.Pregunta;
import com.co.villota.examenes.repository.PreguntaRepository;


@Service
public class PreguntaServiceImpl extends CommonServiceImpl<Pregunta, PreguntaRepository> implements CommonService<Pregunta>{

}
