package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.AdminDAO;
import com.mobile.appuebliar.domain.Admin;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class AdminService {

	@Autowired
	private AdminDAO AdminDAO;

	public Admin guardarAdmin(Admin Admin) throws NullAppuebliarException, AppuebliarNotFoundException {
		Admin response = AdminDAO.save(Admin);
		return response;
	}

	public Status borrarAdmin(String nickname) throws NullAppuebliarException, AppuebliarNotFoundException {
		AdminDAO.deleteById(nickname);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");
		return response;
	}

	public Object obtenerAdmines() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Admin> response = (List<Admin>) AdminDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}

		return response;
	}

	public Object obtenerAdmin(String nickname) throws NullAppuebliarException, AppuebliarNotFoundException {
		Admin response = AdminDAO.findByNickName(nickname);
		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}

		return response;
	}

}
