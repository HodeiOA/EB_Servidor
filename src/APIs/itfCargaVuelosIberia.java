package APIs;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface itfCargaVuelosIberia extends Remote
{
	ArrayList<String> cargarIda(String ciudadOrigen, String ciudadDestino, String fecha) throws RemoteException;
	ArrayList<String> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda,String fechaVuelta) throws RemoteException;
	ArrayList<String> cargarCualquierMomento(String ciudadoOrigen, String ciudadDestino) throws RemoteException;
	ArrayList<String> cargarTodos() throws RemoteException;
}