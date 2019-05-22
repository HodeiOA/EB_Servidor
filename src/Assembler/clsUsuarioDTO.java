package Assembler;

import java.io.Serializable;
import java.util.ArrayList;

import APIs.itfPasarela;
import APIs.itfSistAutorizacionFacebook;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsReserva;

public class clsUsuarioDTO implements Serializable
{
	private static final long serialVersionUID = 1L;

	private String email;
	private String numTarjetaCredito;
	private clsAeropuerto aeroPreder;
	private ArrayList<clsReserva> Listpagos;
	
	public clsUsuarioDTO(String email, String numTarjetaCredito, clsAeropuerto aeroPreder, ArrayList<clsReserva> listpagos) 
	{
		this.email = email;
		this.numTarjetaCredito = numTarjetaCredito;
		this.aeroPreder = aeroPreder;
		Listpagos = listpagos;
	}

	public clsUsuarioDTO() 
	{
	
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNumTarjetaCredito() {
		return numTarjetaCredito;
	}

	public void setNumTarjetaCredito(String numTarjetaCredito) {
		this.numTarjetaCredito = numTarjetaCredito;
	}

	public clsAeropuerto getAeroPreder() {
		return aeroPreder;
	}

	public void setAeroPreder(clsAeropuerto aeroPreder) {
		this.aeroPreder = aeroPreder;
	}

	public ArrayList<clsReserva> getListpagos() {
		return Listpagos;
	}

	public void setListpagos(ArrayList<clsReserva> listpagos) {
		Listpagos = listpagos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
