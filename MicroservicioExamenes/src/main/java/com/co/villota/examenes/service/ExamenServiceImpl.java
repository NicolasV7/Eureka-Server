package com.co.villota.examenes.service;

import org.springframework.stereotype.Service;

import com.co.villota.common.service.CommonService;
import com.co.villota.common.service.implementation.CommonServiceImpl;
import com.co.villota.common.usuario.models.entity.Examen;
import com.co.villota.examenes.repository.ExamenRepository;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository> implements CommonService<Examen>{

}
