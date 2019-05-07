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
	boolean RegistrarUsuario (clsUsuario nuevoUsuario)  throws RemoteException;
	clsUsuario LoginUsuario (clsUsuario nuevoUsuario)  throws RemoteException;
	public List<clsVueloDTO> BuscarVueloIda (clsAeropuerto aeropuesrtoPred, Date fecha, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	public List<clsVueloDTO>BuscarVueloIdayVuelta (clsAeropuerto aeropuesrtoPred, Date fechaIda, Date fechaVuelta, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	public List<clsVueloDTO>BuscarVueloCualquierMomento (clsAeropuerto aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)  throws RemoteException;
	boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero)  throws RemoteException;
}
