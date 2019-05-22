package Assembler;

import java.io.Serializable;
import java.util.ArrayList;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsAeropuertoDTO implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private String codAeropuerto;
	private String ciudad;
	private String pais;
	private ArrayList<clsUsuario> lUsuarios;
	private ArrayList<clsVuelo> lSalidas;
	private ArrayList<clsVuelo> lLLegadas;
	
	public clsAeropuertoDTO(String codAeropuerto, String ciudad, String pais, ArrayList<clsUsuario> lUsuarios,
			ArrayList<clsVuelo> lSalidas, ArrayList<clsVuelo> lLLegadas) 
	{
		this.codAeropuerto = codAeropuerto;
		this.ciudad = ciudad;
		this.pais = pais;
		this.lUsuarios = lUsuarios;
		this.lSalidas = lSalidas;
		this.lLLegadas = lLLegadas;
	}
	
	public String getCodAeropuerto() {
		return codAeropuerto;
	}
	public void setCodAeropuerto(String codAeropuerto) {
		this.codAeropuerto = codAeropuerto;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public ArrayList<clsUsuario> getlUsuarios() {
		return lUsuarios;
	}
	public void setlUsuarios(ArrayList<clsUsuario> lUsuarios) {
		this.lUsuarios = lUsuarios;
	}
	public ArrayList<clsVuelo> getlSalidas() {
		return lSalidas;
	}
	public void setlSalidas(ArrayList<clsVuelo> lSalidas) {
		this.lSalidas = lSalidas;
	}
	public ArrayList<clsVuelo> getlLLegadas() {
		return lLLegadas;
	}
	public void setlLLegadas(ArrayList<clsVuelo> lLLegadas) {
		this.lLLegadas = lLLegadas;
	}
	
	
}
