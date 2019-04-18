package COMUN;

import java.rmi.Remote;
import java.sql.Date;

public interface itfCargaVuelos extends Remote
{
	clsVuelo cargarIda(String aeroOrigen, String ciudadDestino, Date fecha);
	clsVuelo cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, Date fechaIda,Date fechaVuelta);
	clsVuelo cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino);
}
