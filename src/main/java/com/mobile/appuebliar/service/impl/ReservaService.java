package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ReservaDAO;
import com.mobile.appuebliar.domain.Reserva;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class ReservaService {

	@Autowired
	private ReservaDAO ReservaDAO;

	public Reserva guardarReserva(Reserva Reserva) throws NullAppuebliarException, AppuebliarNotFoundException {
		Reserva response = ReservaDAO.save(Reserva);
		return response;
	}

	public Status borrarReserva(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		ReservaDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public List<Reserva> obtenerReservas() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Reserva>) ReservaDAO.findAll();
	}

	public Reserva obtenerReserva(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return ReservaDAO.findById(id).orElse(null);
	}

	public List<Reserva> obtenerReservas(String id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return ReservaDAO.findByUsuarioId(id);
	}

}
