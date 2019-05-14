package Facade;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

import Assembler.clsVueloDTO;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public interface itfFacade extends Remote
{
	boolean RegistrarUsuario (clsUsuario nuevoUsuario, boolean modo)  throws RemoteException;
	clsUsuario LoginUsuario (clsUsuario nuevoUsuario, boolean modo)  throws RemoteException;
	public List<clsVueloDTO> BuscarVueloIda (clsAeropuerto aeropuesrtoPred, String fecha, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	public List<clsVueloDTO>BuscarVueloIdayVuelta (clsAeropuerto aeropuesrtoPred, String fechaIda, String fechaVuelta, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	public List<clsVueloDTO>BuscarVueloCualquierMomento (clsAeropuerto aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero, boolean pasarela)  throws RemoteException;
}
