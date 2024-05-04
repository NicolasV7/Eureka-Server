package com.villota.usuario.service;

import com.villota.commons.service.CommonService;
import com.villota.usuario.models.entity.Alumno;


public interface AlumnoService extends CommonService<Alumno> {

	public Alumno save (Alumno alumno);
	public void deleteById (Long id);

}
