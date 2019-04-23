package COMUN;

import java.rmi.Remote;
import java.util.Date;
import java.util.List;

public interface itfFacade extends Remote 
{
	boolean RegistrarUsuario (clsUsuario nuevoUsuario);
	boolean LoginUsuario (clsUsuario nuevoUsuario);
	public List<VueloDTO> BuscarVueloIda (clsAeropuerto aeropuesrtoPred, Date fecha, String ciudadOrigen, String ciudadDestino);
	public List<VueloDTO>BuscarVueloIdayVuelta (clsAeropuerto aeropuesrtoPred, Date fechaIda, Date fechaVuelta, String ciudadOrigen, String ciudadDestino);
	public List<VueloDTO>BuscarVueloCualquierMomento (clsAeropuerto aeropuesrtoPred, String ciudadOrigen, String ciudadDestino);
    boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo);
}
