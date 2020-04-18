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
@Table(name = "ITEM_VIAJERO")
public class ItemViajero implements Serializable {

	private static final long serialVersionUID = -7634355818832251174L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String tipo;

	@Column(name = "subtipo")
	private String subTipo;

	@Column
	private String nombre;

	@Column
	private String descripcion;

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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getSubTipo() {
		return subTipo;
	}

	public void setSubTipo(String subTipo) {
		this.subTipo = subTipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public ItemViajero() {
	}

}
