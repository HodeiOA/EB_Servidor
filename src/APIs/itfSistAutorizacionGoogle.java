package APIs;

import java.rmi.RemoteException;

public interface itfSistAutorizacionGoogle
{
	boolean ValidarUsuario (String email)throws RemoteException;
}
