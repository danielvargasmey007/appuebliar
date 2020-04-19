package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ExcursionistaDAO;
import com.mobile.appuebliar.domain.Excursionista;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class ExcursionistaService {

	@Autowired
	private ExcursionistaDAO ExcursionistaDAO;

	public Excursionista guardarExcursionista(Excursionista Excursionista)
			throws NullAppuebliarException, AppuebliarNotFoundException {
		Excursionista response = ExcursionistaDAO.save(Excursionista);
		return response;
	}

	public Status borrarExcursionista(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		ExcursionistaDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public Object obtenerExcursionistas() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Excursionista> response = (List<Excursionista>) ExcursionistaDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}

		return response;
	}

	public Object obtenerExcursionista(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		Excursionista response = ExcursionistaDAO.findById(id).orElse(null);
		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}

		return response;
	}

}
