package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Plan;


@Repository
public interface PlanDAO extends CrudRepository<Plan, Long> {

}
