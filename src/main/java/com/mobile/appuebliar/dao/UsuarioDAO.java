package com.mobile.appuebliar.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Usuario;


@Repository
public interface UsuarioDAO extends CrudRepository<Usuario, String>{

}
