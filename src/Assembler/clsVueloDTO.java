package Assembler;

import java.io.Serializable;
import java.util.Date;

public class clsVueloDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String fecha;
	private int numAsientosLibres;
	private double precio;
	
	public clsVueloDTO(String fecha, int numAsientosLibres, double precio) 
	{
		this.fecha = fecha;
		this.numAsientosLibres = numAsientosLibres;
		this.precio = precio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumAsientosLibres() {
		return numAsientosLibres;
	}

	public void setNumAsientosLibres(int numAsientosLibres) {
		this.numAsientosLibres = numAsientosLibres;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
