package COMUN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class clsUsuario 
{
	@PrimaryKey
	private String email;
	private String numTarjetaCredito;
	private itfSistAutorizacion sistemaAutorizacion;
	private itfPasarela pasarelaDePago;
	
	@Column(name="FK_aeroPreder")
	private clsAeropuerto aeroPreder;
	
	@Persistent(mappedBy="usuario")
	private ArrayList<clsReserva> Listpagos;
	
	public clsUsuario()
	{	
		this.email = null;
		this.Listpagos = new ArrayList<clsReserva>();
		this.sistemaAutorizacion = null;
		this.pasarelaDePago = null;
		this.aeroPreder = null;	
		this.numTarjetaCredito = null;
	}
	
	public clsUsuario(String email,itfSistAutorizacion sistemaAutorizacion, itfPasarela pasarelaDePago, clsAeropuerto aeroPreder,  ArrayList<clsReserva> Listpagos, String numTarjetaCredito)
	{
		this.email = email;
		this.Listpagos = Listpagos;
		this.sistemaAutorizacion = sistemaAutorizacion;
		this.pasarelaDePago = pasarelaDePago;
		this.aeroPreder = aeroPreder;
		this.numTarjetaCredito = numTarjetaCredito;
	}

	//Getters y setters
	
	public String getEmail() {
		return email;
	}

	public String getNumTarjetaCredito() {
		return numTarjetaCredito;
	}

	public void setNumTarjetaCredito(String numTarjetaCredito) {
		this.numTarjetaCredito = numTarjetaCredito;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public itfSistAutorizacion getSistemaAutorizacion() {
		return sistemaAutorizacion;
	}

	public void setSistemaAutorizacion(itfSistAutorizacion sistemaAutorizacion) {
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
	
	
	//HashCode e equals
	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		clsUsuario other = (clsUsuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	
}
