package ObjetosDominio;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class clsPago 
{
	@PrimaryKey
	private String codPago;
	
	@Column(name="FK_reserva")
	private clsReserva reserva;
	
	public clsPago()
	{
		this.codPago = null;
		this.reserva = null;	
	}
	
	public clsPago(clsReserva reserva)
	{
		this.codPago = "P" + reserva.getCodReserva();
		this.reserva = reserva;
	}

	//Getters y Setters
	public String getEmail()
	{
		return codPago;
	}

	public void setEmail(String email)
	{
		this.codPago = email;
	}

	public clsReserva getReserva()
	{
		return reserva;
	}

	public void setReserva(clsReserva reserva)
	{
		this.reserva = reserva;
	}

	//HashCode e Equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codPago == null) ? 0 : codPago.hashCode());
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
		return true;
	}

}
