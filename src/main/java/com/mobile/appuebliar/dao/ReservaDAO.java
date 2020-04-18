package com.mobile.appuebliar.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Reserva;


@Repository
public interface ReservaDAO extends CrudRepository<Reserva, Long> {

	List<Reserva> findByUsuarioId(String id);

}
