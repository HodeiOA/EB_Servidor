package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(detachable="true")
public class clsAeropuerto implements Serializable
{
	@PrimaryKey
	private String codAeropuerto;
	private String ciudad;
	private String pais;
	
	@Persistent(mappedBy="aeroPreder")
	private ArrayList<clsUsuario> lUsuarios;
	
	@Persistent(mappedBy="aeropuertoOrigen")
	private ArrayList<clsVuelo> lSalidas;
	
	@Persistent(mappedBy="aeropuertoDestino")
	private ArrayList<clsVuelo> lLLegadas;
	
	public clsAeropuerto()
	{
		codAeropuerto = null;
		ciudad = null;
		pais = null;
		lUsuarios = null;
		lSalidas = null;
		lLLegadas = null;
	}
	
	public clsAeropuerto(String codAeropueto, String ciudad, String pais)
	{
		this.codAeropuerto =  codAeropueto;
		this.ciudad = ciudad;
		this.pais = pais;
		lUsuarios = new ArrayList<clsUsuario>();
		lSalidas = new ArrayList<clsVuelo>();
		lLLegadas = new ArrayList<clsVuelo>();
	}

	public String getCodAeropuerto()
	{
		return codAeropuerto;
	}

	public String getCiudad()
	{
		return ciudad;
	}

	public String getPais()
	{
		return pais;
	}

	public void setCodAeropuerto(String codAeropuerto)
	{
		this.codAeropuerto = codAeropuerto;
	}

	public void setCiudad(String ciudad)
	{
		this.ciudad = ciudad;
	}

	public void setPais(String pais)
	{
		this.pais = pais;
	}

	public ArrayList<clsUsuario> getlUsuarios()
	{
		return lUsuarios;
	}

	public ArrayList<clsVuelo> getlSalidas()
	{
		return lSalidas;
	}

	public ArrayList<clsVuelo> getlLLegadas()
	{
		return lLLegadas;
	}

	public void setlUsuarios(ArrayList<clsUsuario> lUsuarios)
	{
		this.lUsuarios = lUsuarios;
	}

	public void setlSalidas(ArrayList<clsVuelo> lSalidas)
	{
		this.lSalidas = lSalidas;
	}

	public void setlLLegadas(ArrayList<clsVuelo> lLLegadas)
	{
		this.lLLegadas = lLLegadas;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAeropuerto == null) ? 0 : codAeropuerto.hashCode());
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
		clsAeropuerto other = (clsAeropuerto) obj;
		if (codAeropuerto == null) {
			if (other.codAeropuerto != null)
				return false;
		} else if (!codAeropuerto.equals(other.codAeropuerto))
			return false;
		return true;
	}
	
	
}
