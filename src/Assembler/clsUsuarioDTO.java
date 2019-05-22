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
	private itfSistAutorizacionFacebook sistemaAutorizacion;
	private itfPasarela pasarelaDePago;
	private clsAeropuerto aeroPreder;
	private ArrayList<clsReserva> Listpagos;
	
	public clsUsuarioDTO(String email, String numTarjetaCredito, itfSistAutorizacionFacebook sistemaAutorizacion,
			itfPasarela pasarelaDePago, clsAeropuerto aeroPreder, ArrayList<clsReserva> listpagos) 
	{
		this.email = email;
		this.numTarjetaCredito = numTarjetaCredito;
		this.sistemaAutorizacion = sistemaAutorizacion;
		this.pasarelaDePago = pasarelaDePago;
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

	public itfSistAutorizacionFacebook getSistemaAutorizacion() {
		return sistemaAutorizacion;
	}

	public void setSistemaAutorizacion(itfSistAutorizacionFacebook sistemaAutorizacion) {
		this.sistemaAutorizacion = sistemaAutorizacion;
	}

	public itfPasarela getPasarelaDePago() {
		return pasarelaDePago;
	}

	public void setPasarelaDePago(itfPasarela pasarelaDePago) {
		this.pasarelaDePago = pasarelaDePago;
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
