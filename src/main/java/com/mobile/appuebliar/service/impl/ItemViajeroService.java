package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.ItemViajeroDAO;
import com.mobile.appuebliar.domain.ItemViajero;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class ItemViajeroService {

	@Autowired
	private ItemViajeroDAO ItemViajeroDAO;

	public ItemViajero guardarItemViajero(ItemViajero ItemViajero) throws NullAppuebliarException, AppuebliarNotFoundException {
		ItemViajero response = ItemViajeroDAO.save(ItemViajero);
		return response;
	}

	public String borrarItemViajero(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		ItemViajeroDAO.deleteById(id);
		return "{'status': 'SUCCES'}";
	}

	public List<ItemViajero> obtenerItemViajeros() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<ItemViajero>) ItemViajeroDAO.findAll();
	}

	public ItemViajero obtenerItemViajero(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return ItemViajeroDAO.findById(id).orElse(null);
	}

}
