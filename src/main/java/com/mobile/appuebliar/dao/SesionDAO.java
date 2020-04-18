package com.mobile.appuebliar.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Sesion;

@Repository
public interface SesionDAO extends CrudRepository<Sesion, Long> {

	List<Sesion> findByUsuarioId(String id);

}
