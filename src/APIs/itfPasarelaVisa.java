package APIs;

import java.rmi.RemoteException;

public interface itfPasarelaVisa
{
	boolean RealizarPago (String numTarjetaCredito)throws RemoteException;
}
