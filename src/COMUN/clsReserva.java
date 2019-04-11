package COMUN;

import java.io.Serializable;

public class clsReserva implements Serializable
{
	private String codReserva;
	private int numAsiento;
	private clsVuelo vuelo;
	private clsUsuario usuario;
	private String nombreViajero;
	private double importe;
	
	public clsReserva()
	{
		
	}
	
	public clsReserva(int numAsiento, clsVuelo vuelo, clsUsuario usuario, String nombreViajero, double importe)
	{
		this.codReserva = vuelo.getNumVuelo() & numAsiento;
		this.numAsiento = numAsiento;
		this.vuelo = vuelo;
		this.usuario = usuario;
		this.nombreViajero = nombreViajero;
		this.importe = importe;
	}

	public String getCodReserva()
	{
		return codReserva;
	}

	public int getNumAsiento()
	{
		return numAsiento;
	}

	public clsVuelo getVuelo()
	{
		return vuelo;
	}

	public clsUsuario getUsuario()
	{
		return usuario;
	}

	public String getNombreViajero()
	{
		return nombreViajero;
	}

	public double getImporte()
	{
		return importe;
	}

	public void setCodReserva(String codReserva)
	{
		this.codReserva = codReserva;
	}

	public void setNumAsiento(int numAsiento)
	{
		this.numAsiento = numAsiento;
	}

	public void setVuelo(clsVuelo vuelo)
	{
		this.vuelo = vuelo;
	}

	public void setUsuario(clsUsuario usuario)
	{
		this.usuario = usuario;
	}

	public void setNombreViajero(String nombreViajero)
	{
		this.nombreViajero = nombreViajero;
	}

	public void setImporte(double importe)
	{
		this.importe = importe;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codReserva == null) ? 0 : codReserva.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsReserva other = (clsReserva) obj;
		if (codReserva == null) {
			if (other.codReserva != null)
				return false;
		} else if (!codReserva.equals(other.codReserva))
			return false;
		return true;
	}
	
	
}
