package com.mobile.appuebliar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.AdminDAO;
import com.mobile.appuebliar.dao.UsuarioDAO;
import com.mobile.appuebliar.domain.Admin;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.domain.Usuario;
import com.mobile.appuebliar.util.RolEmum;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class UsuarioService implements UserDetailsService {

	@Autowired
	private UsuarioDAO usuarioDAO;

	@Autowired
	private AdminDAO adminDAO;

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

	public Object obtenerUsuarios() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Usuario> response = (List<Usuario>) usuarioDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

	public Object obtenerUsuario(String cedula) throws NullAppuebliarException, AppuebliarNotFoundException {
		Usuario response = usuarioDAO.findById(cedula).orElse(null);
		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		Usuario usuario;
		Admin admin;
		List<GrantedAuthority> authorities = new ArrayList<>();
		usuario = usuarioDAO.findById(id).orElse(null);
		if (usuario != null) {
			authorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", RolEmum.AVENTURERO.getRol())));
			return new User(usuario.getId(), usuario.getPass(), true, true, true, true, authorities);
		} else {
			admin = adminDAO.findByNickName(id);
			authorities.add(new SimpleGrantedAuthority(String.format("ROLE_%s", RolEmum.ADMIN.getRol())));
			return new User(admin.getNickName(), admin.getPass(), true, true, true, true, authorities);
		}
	}

}
