package COMUN;

import java.util.ArrayList;

public class clsVuelo
{
	private String codVuelo;
	private Aeropuerto aeropuertoOrigen;
	private Aeropuerto aeropuertoDestino;
	private Date fechaIda;
	private Date fechaVuelta;
	private int numAsientos;
	private int numAsientosLibres;
	private double precio;
	
	private ArrayList<Reserva> listaReservas;

	public clsVuelo() 
	{
		this.codVuelo = null;
		this.aeropuertoOrigen = null;
		this.aeropuertoDestino = null;
		this.fechaIda = null;
		this.fechaVuelta = null;
		this.numAsientos = 0;
		this.numAsientosLibres = 0;
		this.precio = 0;
		this.listaReservas = null;
	}
	
	public clsVuelo(String codVuelo, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, Date fechaIda, Date fechaVuelta, int numAsientos, int numAsientosLibres, double precio, ArrayList<Reserva> listaReservas) 
	{
		this.codVuelo = codVuelo;
		this.aeropuertoOrigen = aeropuertoOrigen;
		this.aeropuertoDestino = aeropuertoDestino;
		this.fechaIda = fechaIda;
		this.fechaVuelta = fechaVuelta;
		this.numAsientos = numAsientos;
		this.numAsientosLibres = numAsientosLibres;
		this.precio = precio;
		this.listaReservas = listaReservas;
	}

	public String getCodVuelo() {
		return codVuelo;
	}

	public void seCodVuelo(String codVuelo) {
		this.codVuelo = codVuelo;
	}

	public Aeropuerto getAeropuertoOrigen() {
		return aeropuertoOrigen;
	}

	public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
		this.aeropuertoOrigen = aeropuertoOrigen;
	}

	public Aeropuerto getAeropuertoDestino() {
		return aeropuertoDestino;
	}

	public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
		this.aeropuertoDestino = aeropuertoDestino;
	}

	public Date getFechaIda() {
		return fechaIda;
	}

	public void setFechaIda(Date fechaIda) {
		this.fechaIda = fechaIda;
	}

	public Date getFechaVuelta() {
		return fechaVuelta;
	}

	public void setFechaVuelta(Date fechaVuelta) {
		this.fechaVuelta = fechaVuelta;
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

	public ArrayList<Reserva> getListaReservas() {
		return listaReservas;
	}

	public void setListaReservas(ArrayList<Reserva> listaReservas) {
		this.listaReservas = listaReservas;
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
