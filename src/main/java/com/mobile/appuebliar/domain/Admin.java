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
@Table(name = "ADMIN")
public class Admin implements Serializable {

	private static final long serialVersionUID = 5022341805021141326L;

	@Id
	@Column(name = "nick_name")
	private String nickName;

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

	@Column(name = "correo")
	private String correo;

	@Column(name = "sexo")
	private Integer sexo;

	@Column(name = "pass")
	private String pass;

	@OneToMany(mappedBy = "admin")
	private List<Proveedor> provedoresCreados;

	@OneToMany(mappedBy = "admin")
	private List<Salida> salidasCreadas;

	@OneToMany(mappedBy = "admin")
	private List<ItemViajero> itemViajeroCreados;

	@OneToMany(mappedBy = "admin")
	private List<Detalle> detallesCreados;

	@OneToMany(mappedBy = "admin")
	private List<Plan> planesCreados;

	public List<Proveedor> getProvedoresCreados() {
		return provedoresCreados;
	}

	public void setProvedoresCreados(List<Proveedor> provedoresCreados) {
		this.provedoresCreados = provedoresCreados;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Salida> getSalidasCreadas() {
		return salidasCreadas;
	}

	public void setSalidasCreadas(List<Salida> salidasCreadas) {
		this.salidasCreadas = salidasCreadas;
	}

	public List<ItemViajero> getItemViajeroCreados() {
		return itemViajeroCreados;
	}

	public void setItemViajeroCreados(List<ItemViajero> itemViajeroCreados) {
		this.itemViajeroCreados = itemViajeroCreados;
	}

	public List<Detalle> getDetallesCreados() {
		return detallesCreados;
	}

	public void setDetallesCreados(List<Detalle> detallesCreados) {
		this.detallesCreados = detallesCreados;
	}

	public List<Plan> getPlanesCreados() {
		return planesCreados;
	}

	public void setPlanesCreados(List<Plan> planesCreados) {
		this.planesCreados = planesCreados;
	}

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
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public Admin() {
	}

}
