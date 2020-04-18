package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.ItemViajero;


@Repository
public interface ItemViajeroDAO extends CrudRepository<ItemViajero, Long> {

}
