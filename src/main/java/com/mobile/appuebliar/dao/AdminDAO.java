package com.mobile.appuebliar.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mobile.appuebliar.domain.Admin;


@Repository
public interface AdminDAO extends CrudRepository<Admin, String> {

	Admin findByNickName(String nickname);

}
