package COMUN;

import java.rmi.Remote;

public interface itfSistAutorizacionFacebook extends Remote
{
	boolean ValidarUsuario (String email);
}
