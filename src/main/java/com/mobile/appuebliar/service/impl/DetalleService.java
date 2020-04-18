package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.DetalleDAO;
import com.mobile.appuebliar.domain.Detalle;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class DetalleService {

	@Autowired
	private DetalleDAO DetalleDAO;

	public Detalle guardarDetalle(Detalle Detalle) throws NullAppuebliarException, AppuebliarNotFoundException {
		Detalle response = DetalleDAO.save(Detalle);
		return response;
	}

	public String borrarDetalle(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		DetalleDAO.deleteById(id);
		return "{'status': 'SUCCES'}";
	}

	public List<Detalle> obtenerDetalles() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Detalle>) DetalleDAO.findAll();
	}

	public Detalle obtenerDetalle(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return DetalleDAO.findById(id).orElse(null);
	}

}
