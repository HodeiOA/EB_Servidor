package COMUN;

import java.util.ArrayList;

public class clsAerolinea 
{
	private String codAerolinea;
	private double comision;
	
	public clsAerolinea() 
	{
		this.codAerolinea = null;
		this.comision = 0.0;
	}
	
	public clsAerolinea(String codAerolinea, double comision) 
	{
		this.codAerolinea = codAerolinea;
		this.comision = comision;
	}



	public String getCodAerolinea() {
		return codAerolinea;
	}



	public void setCodAerolinea(String codAerolinea) {
		this.codAerolinea = codAerolinea;
	}



	public double getComision() {
		return comision;
	}



	public void setComision(double comision) {
		this.comision = comision;
	}



	double calcularComisionDebida(ArrayList<Reserva> historicoReservas )
	{
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAerolinea == null) ? 0 : codAerolinea.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		clsAerolinea other = (clsAerolinea) obj;
		if (codAerolinea == null) {
			if (other.codAerolinea != null)
				return false;
		} else if (!codAerolinea.equals(other.codAerolinea))
			return false;
		return true;
	}
	
	
	
}
