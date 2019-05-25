package ObjetosDominio;

import java.util.ArrayList;

import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class clsAerolinea 
{
	@PrimaryKey
	private String codAerolinea;
	private double comision;
	private double acumulado;
	
	@Element(column="FK_aerolinea")
	private ArrayList<clsVuelo> lVuelos;
	
	public clsAerolinea() 
	{
		this.codAerolinea = null;
		this.comision = 0.0;
		this.lVuelos = null; 
		this.acumulado = 0.0;
	}
	
	public clsAerolinea(String codAerolinea, double comision, ArrayList<clsVuelo> lVuelos, double acumulado) 
	{
		this.codAerolinea = codAerolinea;
		this.comision = comision;
		this.lVuelos = lVuelos;
		this.acumulado = acumulado;
	}

	public ArrayList<clsVuelo> getlVuelos()
	{
		return lVuelos;
	}

	public void setlVuelos(ArrayList<clsVuelo> lVuelos)
	{
		this.lVuelos = lVuelos;
	}

	public String getCodAerolinea()
	{
		return codAerolinea;
	}

	public void setCodAerolinea(String codAerolinea)
	{
		this.codAerolinea = codAerolinea;
	}

	public double getComision()
	{
		return comision;
	}

	public void setComision(double comision)
	{
		this.comision = comision;
	}

	public void calcularComisionDebida(double precio)
	{
		double retorno = 0;
		this.acumulado += precio*this.comision/100;
	}

	public double getAcumulado() {
		return acumulado;
	}

	public void setAcumulado(double acumulado) {
		this.acumulado = acumulado;
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
