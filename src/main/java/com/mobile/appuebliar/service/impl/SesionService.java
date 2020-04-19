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

	public Object obtenerSesions() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Sesion> response = (List<Sesion>) SesionDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

	public Object obtenerSesion(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		Sesion response = SesionDAO.findById(id).orElse(null);
		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

	public Object obtenerSesionPorUsuario(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Sesion> response = SesionDAO.findByUsuarioId(id);
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

}
