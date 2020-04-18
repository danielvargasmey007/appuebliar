package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Detalle;


@Repository
public interface DetalleDAO extends CrudRepository<Detalle, Long> {

}
