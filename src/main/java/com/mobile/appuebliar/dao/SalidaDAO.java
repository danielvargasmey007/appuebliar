package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Salida;

@Repository
public interface SalidaDAO extends CrudRepository<Salida, Long> {

}
