package com.mobile.appuebliar.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SALIDA")
public class Salida implements Serializable {

	private static final long serialVersionUID = -7634355818832251174L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "fecha_inicio")
	private String fechaInicio;

	@Column(name = "fecha_fin")
	private String fechaFin;

	@Column
	private String descripcion;

	@Column
	private String mes;

	@Column
	private String año;

	@ManyToOne
	@JoinColumn(name = "admin_nickname")
	private Admin admin;

	@ManyToOne
	@JoinColumn(name = "detalle_id")
	private Detalle detalle;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMes() {
		return mes;
	}

	public void setMes(String mes) {
		this.mes = mes;
	}

	public String getAño() {
		return año;
	}

	public void setAño(String año) {
		this.año = año;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public Salida() {
	}

}
