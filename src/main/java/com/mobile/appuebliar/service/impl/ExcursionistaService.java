package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ExcursionistaDAO;
import com.mobile.appuebliar.domain.Excursionista;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class ExcursionistaService {

	@Autowired
	private ExcursionistaDAO ExcursionistaDAO;

	public Excursionista guardarExcursionista(Excursionista Excursionista) throws NullAppuebliarException, AppuebliarNotFoundException {
		Excursionista response = ExcursionistaDAO.save(Excursionista);
		return response;
	}

	public String borrarExcursionista(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		ExcursionistaDAO.deleteById(id);
		return "{'status': 'SUCCES'}";
	}

	public List<Excursionista> obtenerExcursionistas() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Excursionista>) ExcursionistaDAO.findAll();
	}

	public Excursionista obtenerExcursionista(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return ExcursionistaDAO.findById(id).orElse(null);
	}

}
