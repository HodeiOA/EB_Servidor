package APIs;

import java.rmi.RemoteException;

public interface itfPasarelaPaypal
{
	boolean RealizarPago (String numTarjetaCredito)throws RemoteException;
}
