package com.mobile.appuebliar.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.UsuarioDAO;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.domain.Usuario;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public Usuario guardarUsuario(Usuario usuario) throws NullAppuebliarException, AppuebliarNotFoundException {
		Usuario response = usuarioDAO.save(usuario);
		return response;
	}

	public Status borrarUsuario(String cedula) throws NullAppuebliarException, AppuebliarNotFoundException {
		usuarioDAO.deleteById(cedula);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public List<Usuario> obtenerUsuarios() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Usuario>) usuarioDAO.findAll();
	}

	public Usuario obtenerUsuario(String cedula) throws NullAppuebliarException, AppuebliarNotFoundException {
		return usuarioDAO.findById(cedula).orElse(null);
	}

}
