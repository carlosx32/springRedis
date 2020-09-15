package com.rdsWebExample.domain;

public class Vehicle {
	private int id;
	private String nombrecomercial;
	private String Pasajeos;
	private String Puertas;
	private String tipo;
	
	
	
	public Vehicle(int id,String nombrecomercial, String pasajeos, String puertas, String tipo) {
		super();
		this.setId(id);
		this.nombrecomercial = nombrecomercial;
		Pasajeos = pasajeos;
		Puertas = puertas;
		this.tipo = tipo;
	}
	
	
	
	public String getNombrecomercial() {
		return nombrecomercial;
	}
	public void setNombrecomercial(String nombrecomercial) {
		this.nombrecomercial = nombrecomercial;
	}
	public String getPasajeos() {
		return Pasajeos;
	}
	public void setPasajeos(String pasajeos) {
		Pasajeos = pasajeos;
	}
	public String getPuertas() {
		return Puertas;
	}
	public void setPuertas(String puertas) {
		Puertas = puertas;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}
	
	

}
