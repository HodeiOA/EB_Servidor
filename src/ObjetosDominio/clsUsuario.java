package ObjetosDominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import APIs.itfSistAutorizacionFacebook;

@PersistenceCapable
public class clsUsuario implements Serializable
{
	@PrimaryKey
	private String email;
	private String numTarjetaCredito;
	
	@Column(name="FK_aeroPreder")
	private clsAeropuerto aeroPreder;
	
	@Persistent(mappedBy="usuario")
	private ArrayList<clsReserva> ListReservas;
	
	public clsUsuario()
	{	
		this.email = null;
		this.ListReservas = new ArrayList<clsReserva>();
		this.aeroPreder = null;	
		this.numTarjetaCredito = null;
	}
	
	public clsUsuario(String email, clsAeropuerto aeroPreder,  ArrayList<clsReserva> Listpagos, String numTarjetaCredito)
	{
		this.email = email;
		this.ListReservas = Listpagos;
		this.aeroPreder = aeroPreder;
		this.numTarjetaCredito = numTarjetaCredito;
	}
	
	public clsUsuario(String email, clsAeropuerto aeroPreder, String numTarjetaCredito)
	{
		this.email = email;
		this.aeroPreder = aeroPreder;
		this.numTarjetaCredito = numTarjetaCredito;
	}

	public void addReserva(clsReserva reserva) 
	{
		ListReservas.add(reserva);
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

	public clsAeropuerto getAeroPreder() {
		return aeroPreder;
	}

	public void setAeroPreder(clsAeropuerto aeroPreder) {
		this.aeroPreder = aeroPreder;
	}
	
	public ArrayList<clsReserva> getListReservas() {
		return ListReservas;
	}

	public void setListReservas(ArrayList<clsReserva> ListReservas) {
		this.ListReservas = ListReservas;
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
