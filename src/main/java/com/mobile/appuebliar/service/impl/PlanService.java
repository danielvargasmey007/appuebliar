package com.mobile.appuebliar.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import com.mobile.appuebliar.dao.PlanDAO;
import com.mobile.appuebliar.dao.ProvedorDAO;
import com.mobile.appuebliar.domain.Plan;
import com.mobile.appuebliar.domain.Proveedor;
import com.mobile.appuebliar.domain.Status;
import com.mobile.appuebliar.util.exception.AppuebliarNotFoundException;
import com.mobile.appuebliar.util.exception.NullAppuebliarException;

@Service
@Transactional
public class PlanService {

	@Autowired
	private PlanDAO PlanDAO;

	@Autowired
	private ProvedorDAO provedorDAO;

	public Plan guardarPlan(Plan Plan) throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Proveedor> provedores = Plan.getProveedores();
		Plan.setProveedores(new ArrayList<Proveedor>());
		for (Proveedor proveedor : provedores) {
			proveedor = provedorDAO.findById(proveedor.getId()).orElse(new Proveedor());
			proveedor.getPlanes().add(Plan);
			Plan.getProveedores().add(proveedor);
		}
		return PlanDAO.save(Plan);
	}

	public Status borrarPlan(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		PlanDAO.deleteById(id);
		Status response = new Status();
		response.setMessage("Operacion ejecutada exitosamente.");
		response.setResponse("SUCCES");

		return response;
	}

	public List<Plan> obtenerPlans() throws NullAppuebliarException, AppuebliarNotFoundException {
		return (List<Plan>) PlanDAO.findAll();
	}

	public Plan obtenerPlan(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		return PlanDAO.findById(id).orElse(null);
	}

}
