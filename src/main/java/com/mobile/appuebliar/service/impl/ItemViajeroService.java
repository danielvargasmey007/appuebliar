package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ItemViajeroDAO;
import com.mobile.appuebliar.domain.ItemViajero;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class ItemViajeroService {

	@Autowired
	private ItemViajeroDAO ItemViajeroDAO;

	public ItemViajero guardarItemViajero(ItemViajero ItemViajero)
			throws NullAppuebliarException, AppuebliarNotFoundException {
		ItemViajero response = ItemViajeroDAO.save(ItemViajero);
		return response;
	}

	public Status borrarItemViajero(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		ItemViajeroDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public Object obtenerItemViajeros() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<ItemViajero> response = (List<ItemViajero>) ItemViajeroDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}

		return response;
	}

	public Object obtenerItemViajero(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		ItemViajero response = ItemViajeroDAO.findById(id).orElse(null);
		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}

		return response;
	}

}
