package ObjetosDominio;

<<<<<<< HEAD:src/COMUN/clsUsuario.java
public class clsUsuario 
{
	private String email;
		
	public clsUsuario()
	{	
		this.email = null;
	}
	
	public clsUsuario(String email)
	{
		this.email = email;
=======
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import APIs.itfPasarela;
import APIs.itfSistAutorizacionFacebook;

@PersistenceCapable
public class clsUsuario 
{
	@PrimaryKey
	private String email;
	private String numTarjetaCredito;
	
	@Column(name="FK_aeroPreder")
	private clsAeropuerto aeroPreder;
	
	@Persistent(mappedBy="usuario")
	private ArrayList<clsReserva> Listpagos;
	
	public clsUsuario()
	{	
		this.email = null;
		this.Listpagos = new ArrayList<clsReserva>();
		this.aeroPreder = null;	
		this.numTarjetaCredito = null;
	}
	
	public clsUsuario(String email, clsAeropuerto aeroPreder,  ArrayList<clsReserva> Listpagos, String numTarjetaCredito)
	{
		this.email = email;
		this.Listpagos = Listpagos;
		this.aeroPreder = aeroPreder;
		this.numTarjetaCredito = numTarjetaCredito;
>>>>>>> e82e8d27a80d9dc49801ec6cdf932c2fe296cdce:src/ObjetosDominio/clsUsuario.java
	}

	//Getters y setters
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

<<<<<<< HEAD:src/COMUN/clsUsuario.java
=======
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
	
	
>>>>>>> e82e8d27a80d9dc49801ec6cdf932c2fe296cdce:src/ObjetosDominio/clsUsuario.java
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
