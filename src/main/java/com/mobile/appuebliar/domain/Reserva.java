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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "RESERVA")
public class Reserva implements Serializable {

	private static final long serialVersionUID = -1317704959761047610L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String vendedor;

	@Column
	private String iva;

	@Column
	private String fecha;

	@Column(name = "cantidad_personas")
	private String cantidadPersonas;

	@Column
	private String total;

	@Column
	private String descripcion;

	@Column(name = "medio_pago")
	private String medioPago;

	@ManyToOne
	@JoinColumn(name = "plan_id")
	private Plan plan;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVendedor() {
		return vendedor;
	}

	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getCantidadPersonas() {
		return cantidadPersonas;
	}

	public void setCantidadPersonas(String cantidadPersonas) {
		this.cantidadPersonas = cantidadPersonas;
	}

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMedioPago() {
		return medioPago;
	}

	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	public Plan getPlan() {
		return plan;
	}

	public void setPlan(Plan plan) {
		this.plan = plan;
	}

	@JsonIgnore
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Reserva() {
	}

}
