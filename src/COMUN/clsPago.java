package COMUN;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class clsPago 
{
	 @PrimaryKey
	private String codPago;
	private clsReserva reserva;
	private clsUsuario usuario;
	
	public clsPago()
	{
		
	}
	
	public clsPago(String email, clsReserva reserva,clsUsuario usuario)
	{
		this.codPago = email;
		this.reserva = reserva;
		this.usuario = usuario;
	}

	//Getters y Setters
	public String getEmail() {
		return codPago;
	}

	public void setEmail(String email) {
		this.codPago = email;
	}

	public clsReserva getReserva() {
		return reserva;
	}

	public void setReserva(clsReserva reserva) {
		this.reserva = reserva;
	}

	public clsUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(clsUsuario usuario) {
		this.usuario = usuario;
	}

	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPago == null) ? 0 : codPago.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
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
		clsPago other = (clsPago) obj;
		if (codPago == null) {
			if (other.codPago != null)
				return false;
		} else if (!codPago.equals(other.codPago))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
