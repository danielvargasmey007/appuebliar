package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Excursionista;

@Repository
public interface ExcursionistaDAO extends CrudRepository<Excursionista, String> {

}
