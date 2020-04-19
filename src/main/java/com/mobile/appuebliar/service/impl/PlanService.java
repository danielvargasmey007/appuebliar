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
		if (provedores != null) {
			Plan.setProveedores(new ArrayList<Proveedor>());
			for (Proveedor proveedor : provedores) {
				proveedor = provedorDAO.findById(proveedor.getId()).orElse(new Proveedor());
				proveedor.getPlanes().add(Plan);
				Plan.getProveedores().add(proveedor);
			}
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

	public Object obtenerPlans() throws NullAppuebliarException, AppuebliarNotFoundException {
		List<Plan> response = (List<Plan>) PlanDAO.findAll();
		if (response == null || response.isEmpty()) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

	public Object obtenerPlan(Long id) throws NullAppuebliarException, AppuebliarNotFoundException {
		Plan response = PlanDAO.findById(id).orElse(null);
		if (response == null) {
			return new Status("BLANK", "Operacion No se encontraron datos");
		}
		return response;
	}

}
