package com.mobile.appuebliar.util;

public enum RolEmum {

	ADMIN("ADMIN"), EXCURSIONISTA("EXCURSIONISTA"), AVENTURERO("AVENTURERO");

	private String rol;

	private RolEmum(String rol) {
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
