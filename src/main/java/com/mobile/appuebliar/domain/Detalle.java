package com.mobile.appuebliar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DETALLE")
public class Detalle implements Serializable {

	private static final long serialVersionUID = -7634355818832251174L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String tipo;

	@Column
	private String destino;

	@Column
	private String origen;

	@Column
	private String nombre;

	@Column
	private String descripcion;

	@ManyToOne
	@JoinColumn(name = "admin_nickname")
	private Admin admin;

	@OneToMany(mappedBy = "detalle")
	private List<Plan> planes;

	@OneToMany(mappedBy = "detalle")
	private List<Salida> salidas;

	@OneToMany(mappedBy = "detalle")
	private List<ItemViajero> itemViajeros;

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

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
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

	public void setPlanes(List<Plan> planes) {
		this.planes = planes;
	}

	public void setSalidas(List<Salida> salidas) {
		this.salidas = salidas;
	}

	public List<ItemViajero> getItemViajeros() {
		return itemViajeros;
	}

	public List<Salida> getSalidas() {
		return salidas;
	}

	public void setItemViajeros(List<ItemViajero> itemViajeros) {
		this.itemViajeros = itemViajeros;
	}

	public Detalle() {
	}

}
