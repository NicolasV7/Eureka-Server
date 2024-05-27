package com.co.villota.usuarios.service;

import com.co.villota.common.service.CommonService;
import com.co.villota.common.service.implementation.CommonServiceImpl;
import com.co.villota.common.usuario.models.entity.Alumno;
import com.co.villota.usuarios.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository> implements CommonService<Alumno>{

}
