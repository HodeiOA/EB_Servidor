package APIs;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import ObjetosDominio.clsVuelo;

public interface itfCargaVuelosLufthansa extends Remote
{
	ArrayList<clsVuelo> cargarIda(String aeroOrigen, String ciudadDestino, String fecha)throws RemoteException;
	ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda,String fechaVuelta)throws RemoteException;
	ArrayList <clsVuelo> cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino)throws RemoteException;
	ArrayList <clsVuelo> cargarTodos()throws RemoteException;
}
