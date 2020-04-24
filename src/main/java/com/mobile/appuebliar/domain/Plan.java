package com.mobile.appuebliar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PLAN")
public class Plan implements Serializable {

	private static final long serialVersionUID = -7634355818832251174L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String nombre;

	@Column
	private String precio;

	@ManyToOne
	@JoinColumn(name = "admin_nickname")
	private Admin admin;

	@OneToMany(mappedBy = "plan")
	private List<Reserva> reservas;

	@ManyToOne
	@JoinColumn(name = "excursionista_id")
	private Excursionista excursionista;

	@ManyToOne
	@JoinColumn(name = "detalle_id")
	private Detalle detalle;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "PLAN_PROVEDOR", joinColumns = { @JoinColumn(name = "plan_id") }, inverseJoinColumns = {
			@JoinColumn(name = "provedor_id") })
	private List<Proveedor> proveedores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setExcursionista(Excursionista excursionista) {
		this.excursionista = excursionista;
	}

	public Detalle getDetalle() {
		return detalle;
	}

	public void setDetalle(Detalle detalle) {
		this.detalle = detalle;
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Plan() {
	}

}
