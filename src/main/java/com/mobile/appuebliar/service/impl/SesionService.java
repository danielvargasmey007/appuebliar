package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.SesionDAO;
import com.mobile.appuebliar.domain.Sesion;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class SesionService {

	@Autowired
	private SesionDAO SesionDAO;

	public Sesion guardarSesion(Sesion Sesion) throws NullAppuebliarException, AppuebliarNotFoundException {
		Sesion response = SesionDAO.save(Sesion);
		return response;
	}

	public Status borrarSesion(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		SesionDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public List<Sesion> obtenerSesions() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Sesion>) SesionDAO.findAll();
	}

	public Sesion obtenerSesion(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return SesionDAO.findById(id).orElse(null);
	}

	public List<Sesion> obtenerSesionPorUsuario(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return SesionDAO.findByUsuarioId(id);
	}

}
