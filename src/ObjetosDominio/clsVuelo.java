package ObjetosDominio;

import java.util.ArrayList;
import java.util.Date;

import javax.jdo.annotations.Column;
import javax.jdo.annotations.Element;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class clsVuelo
{
	@PrimaryKey
	private String codVuelo;
	
	@Column(name="aeropuertoOrigen")
	private clsAeropuerto aeropuertoOrigen;
	
	@Column(name="aeropuertoDestino")
	private clsAeropuerto aeropuertoDestino;
	private String fecha;
	private int numAsientos;
	private int numAsientosLibres;
	private double precio;
	
	private ArrayList <Integer> asientos; //Asientos reservados
	
	@Persistent(mappedBy="vuelo")
	private ArrayList<clsReserva> listaReservas;

	public clsVuelo() 
	{
		this.codVuelo = null;
		this.aeropuertoOrigen = null;
		this.aeropuertoDestino = null;
		this.fecha = null;
		this.numAsientos = 0;
		this.numAsientosLibres = 0;
		this.precio = 0;
		this.listaReservas = null;
		this.asientos = null;
	}
	
	public clsVuelo(String codVuelo, clsAeropuerto aeropuertoOrigen, clsAeropuerto aeropuertoDestino, String fecha, int numAsientos, int numAsientosLibres, double precio, ArrayList<clsReserva> listaReservas, ArrayList <Integer> asientos) 
	{
		this.codVuelo = codVuelo;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.fecha = fecha;
		this.numAsientos = numAsientos;
		this.numAsientosLibres = numAsientosLibres;
		this.precio = precio;
		this.listaReservas = listaReservas;
		this.asientos = asientos;
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	public void setCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}

	public clsAeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(clsAeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public clsAeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(clsAeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getNumAsientos() {
		return numAsientos;
	}

	public void setNumAsientos(int numAsientos) {
		this.numAsientos = numAsientos;
	}

	public int getNumAsientosLibres() {
		return numAsientosLibres;
	}

	public void setNumAsientosLibres(int numAsientosLibres) {
		this.numAsientosLibres = numAsientosLibres;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public ArrayList<clsReserva> getListaReservas() {
		return listaReservas;
	}

	public ArrayList<Integer> getAsientos() {
		return asientos;
	}

	public void setAsientos(ArrayList<Integer> asientos) {
		this.asientos = asientos;
	}

	public void setListaReservas(ArrayList<clsReserva> listaReservas) {
		this.listaReservas = listaReservas;
	}

	public void ReservaAsiento (Integer asiento)
	{
		asientos.add(asiento);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codVuelo == null) ? 0 : codVuelo.hashCode());
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
		clsVuelo other = (clsVuelo) obj;
		if (codVuelo == null) {
			if (other.codVuelo != null)
				return false;
		} else if (!codVuelo.equals(other.codVuelo))
			return false;
		return true;
	}
	
}
