package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Proveedor;

@Repository
public interface ProvedorDAO extends CrudRepository<Proveedor, Long> {

}
