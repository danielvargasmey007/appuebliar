package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ProvedorDAO;
import com.mobile.appuebliar.domain.Proveedor;
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

	public String borrarProvedor(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		provedorDAO.deleteById(id);
		return "{'status': 'SUCCES'}";
	}

	public List<Proveedor> obtenerProvedores() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Proveedor>) provedorDAO.findAll();
	}

	public Proveedor obtenerProvedor(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return provedorDAO.findById(id).orElse(null);
	}

}
