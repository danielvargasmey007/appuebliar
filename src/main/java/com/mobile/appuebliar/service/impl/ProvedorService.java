package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ProvedorDAO;
import com.mobile.appuebliar.domain.Proveedor;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class ProvedorService {

	@Autowired
	private ProvedorDAO provedorDAO;

	public Proveedor guardarProvedor(Proveedor proveedor) throws NullAppuebliarException, AppuebliarNotFoundException {
		Proveedor response = provedorDAO.save(proveedor);
		return response;
	}

	public Status borrarProvedor(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		provedorDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public Object obtenerProvedores() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Proveedor> response = (List<Proveedor>) provedorDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

	public Object obtenerProvedor(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		Proveedor response = provedorDAO.findById(id).orElse(null);

		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

}
