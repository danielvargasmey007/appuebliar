package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.AdminDAO;
import com.mobile.appuebliar.domain.Admin;
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

	public String borrarAdmin(String nickname) throws NullAppuebliarException, AppuebliarNotFoundException {
		AdminDAO.deleteById(nickname);
		return "{'status': 'SUCCES'}";
	}

	public List<Admin> obtenerAdmines() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Admin>) AdminDAO.findAll();
	}

	public Admin obtenerAdmin(String nickname) throws NullAppuebliarException, AppuebliarNotFoundException {
		return AdminDAO.findByNickName(nickname);
	}

}
