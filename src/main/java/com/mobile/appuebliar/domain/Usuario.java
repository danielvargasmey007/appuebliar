package com.mobile.appuebliar.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "USUARIO")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 5022341805021141326L;

	@Id
	@Column(name = "cedula")
	private String id;

	@Column(name = "primer_nombre")
	private String primerNombre;

	@Column(name = "segundo_nombre")
	private String segundoNombre;

	@Column(name = "primer_apellido")
	private String primerApellido;

	@Column(name = "segundo_apellido")
	private String segundoApellido;

	@Column(name = "ciudad_recidencia")
	private String ciudadRecidencia;

	@Column(name = "edad")
	private Integer edad;

	@Column(name = "tc")
	private String tc;
	
	@Column(name = "pass")
	private String pass;

	@Column(name = "sexo")
	private Integer sexo;

	@OneToMany(mappedBy = "usuario")
	private List<Reserva> misReservas;

	@OneToMany(mappedBy = "usuario")
	private List<Sesion> misSesiones;

	@Column(name = "correo")
	private String correo;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getCiudadRecidencia() {
		return ciudadRecidencia;
	}

	public void setCiudadRecidencia(String ciudadRecidencia) {
		this.ciudadRecidencia = ciudadRecidencia;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getTc() {
		return tc;
	}

	public void setTc(String tc) {
		this.tc = tc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Integer getSexo() {
		return sexo;
	}

	public void setSexo(Integer sexo) {
		this.sexo = sexo;
	}
	
	@JsonIgnore
	public List<Reserva> getMisReservas() {
		return misReservas;
	}

	public void setMisReservas(List<Reserva> misReservas) {
		this.misReservas = misReservas;
	}

	@JsonIgnore
	public List<Sesion> getMisSesiones() {
		return misSesiones;
	}

	public void setMisSesiones(List<Sesion> misSesiones) {
		this.misSesiones = misSesiones;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Usuario() {
	}

}
