package APIs;

import java.rmi.Remote;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import ObjetosDominio.clsVuelo;

public interface itfCargaVuelosLufthansa extends Remote
{
	ArrayList <clsVuelo> cargarIda(String aeroOrigen, String ciudadDestino, Date fecha);
	ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, Date fechaIda,Date fechaVuelta);
	ArrayList <clsVuelo> cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino);
}
