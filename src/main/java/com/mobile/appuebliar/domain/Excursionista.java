package com.mobile.appuebliar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EXCURSIONISTA")
public class Excursionista implements Serializable {

	private static final long serialVersionUID = 5022341805021141326L;

	@Id
	@Column
	private String correo;

	@Column
	private String ubicacion;

	@OneToMany(mappedBy = "excursionista")
	private List<Plan> planesVisitados;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Plan> getPlanesVisitados() {
		return planesVisitados;
	}

	public void setPlanesVisitados(List<Plan> planesVisitados) {
		this.planesVisitados = planesVisitados;
	}

	public Excursionista() {
	}

}
