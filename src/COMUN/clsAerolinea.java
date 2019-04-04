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
	
}
