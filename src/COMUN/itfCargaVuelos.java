package COMUN;

import java.rmi.Remote;
import java.sql.Date;
import java.util.HashSet;

public interface itfCargaVuelos extends Remote
{
	HashSet <clsVuelo> cargarIda(String aeroOrigen, String ciudadDestino, Date fecha);
	HashSet <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, Date fechaIda,Date fechaVuelta);
	HashSet <clsVuelo> cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino);
}
