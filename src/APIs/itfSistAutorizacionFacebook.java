package APIs;

import java.rmi.RemoteException;

public interface itfSistAutorizacionFacebook
{
	boolean ValidarUsuario (String email)throws RemoteException;
}
