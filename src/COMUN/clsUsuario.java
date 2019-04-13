package COMUN;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class clsUsuario 
{
	 @PrimaryKey
	private String email;
	private ISistAutorizacion sistemaAutorizacion;
	private IPasarela pasarelaDePago;
	private clsAeropuerto aeroPreder;
	
	public clsUsuario()
	{	
		this.email = null;
		this.sistemaAutorizacion = null;
		this.pasarelaDePago = null;
		this.aeroPreder = null;	
	}
	
	public clsUsuario(String email,ISistAutorizacion sistemaAutorizacion, IPasarela pasarelaDePago, clsAeropuerto aeroPreder)
	{
		this.email = email;
		this.sistemaAutorizacion = sistemaAutorizacion;
		this.pasarelaDePago = pasarelaDePago;
		this.aeroPreder = aeroPreder;
	}

	//Getters y setters
	
	
	//HashCode e equals

	@Override
	public int hashCode() 
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	public String getEmail() {
		return email;
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

	public Aeropuerto getAeroPreder() {
		return aeroPreder;
	}

	public void setAeroPreder(Aeropuerto aeroPreder) {
		this.aeroPreder = aeroPreder;
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
