package APIs;

import java.rmi.Remote;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import ObjetosDominio.clsVuelo;

public interface itfCargaVuelosAmericanAirlines extends Remote
{
	ArrayList<clsVuelo> cargarIda(String aeroOrigen, String ciudadDestino, String fecha);
	ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda,String fechaVuelta);
	ArrayList <clsVuelo> cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino);
}
