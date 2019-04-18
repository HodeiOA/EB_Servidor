package COMUN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
	private ISistAutorizacion sistemaAutorizacion;
	private IPasarela pasarelaDePago;
	private clsAeropuerto aeroPreder;
	//Usuario es el atributo de tipo clsUsuario en Pago
	@Join
	@Persistent(mappedBy="usuario", dependentElement="true")
	private HashSet <clsPago> Listpagos;
	
	public clsUsuario()
	{	
		this.email = null;
		this.Listpagos = new HashSet<clsPago>();
		this.sistemaAutorizacion = null;
		this.pasarelaDePago = null;
		this.aeroPreder = null;	
		this.numTarjetaCredito = null;
	}
	
	public clsUsuario(String email,ISistAutorizacion sistemaAutorizacion, IPasarela pasarelaDePago, clsAeropuerto aeroPreder,  HashSet <clsPago> Listpagos, String numTarjetaCredito)
	{
		this.email = email;
		this.Listpagos =Listpagos;
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

	public ISistAutorizacion getSistemaAutorizacion() {
		return sistemaAutorizacion;
	}

	public void setSistemaAutorizacion(ISistAutorizacion sistemaAutorizacion) {
		this.sistemaAutorizacion = sistemaAutorizacion;
	}

	public IPasarela getPasarelaDePago() {
		return pasarelaDePago;
	}

	public void setPasarelaDePago(IPasarela pasarelaDePago) {
		this.pasarelaDePago = pasarelaDePago;
	}

	public clsAeropuerto getAeroPreder() {
		return aeroPreder;
	}

	public void setAeroPreder(clsAeropuerto aeroPreder) {
		this.aeroPreder = aeroPreder;
	}
	
	public HashSet<clsPago> getListpagos() {
		return Listpagos;
	}

	public void setListpagos(HashSet<clsPago> listpagos) {
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
