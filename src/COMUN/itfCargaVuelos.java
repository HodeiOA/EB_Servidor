package COMUN;

import java.rmi.Remote;
import java.sql.Date;

public interface itfCargaVuelos extends Remote
{
	clsVuelo cargarIda(String aeroOrigen, String aeroDestino, Date fecha);
	clsVuelo cargarIdaVuelta(String aeroOrigen, String aeroDestino, Date fechaIda,Date fechaVuelta);
	clsVuelo cargarCualquierMomento(String aeroOrigen, String aeroDestino);
}
