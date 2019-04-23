package COMUN;

import java.io.Serializable;
import java.util.Date;

public class VueloDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Date fecha;
	private int numAsientosLibres;
	private double precio;
	
	public VueloDTO(Date fecha, int numAsientosLibres, double precio) 
	{
		this.fecha = fecha;
		this.numAsientosLibres = numAsientosLibres;
		this.precio = precio;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
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
