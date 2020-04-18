package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.SalidaDAO;
import com.mobile.appuebliar.domain.Salida;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class SalidaService {

	@Autowired
	private SalidaDAO SalidaDAO;

	public Salida guardarSalida(Salida Salida) throws NullAppuebliarException, AppuebliarNotFoundException {
		Salida response = SalidaDAO.save(Salida);
		return response;
	}

	public Status borrarSalida(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		SalidaDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public List<Salida> obtenerSalidas() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Salida>) SalidaDAO.findAll();
	}

	public Salida obtenerSalida(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return SalidaDAO.findById(id).orElse(null);
	}

}
