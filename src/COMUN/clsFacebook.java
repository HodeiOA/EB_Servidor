package COMUN;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class clsFacebook extends UnicastRemoteObject implements itfSistAutorizacionFacebook
{
	private static final long serialVersionUID = 1L;
	private ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();
	
	protected clsFacebook() throws RemoteException 
	{
		super();
	
		//usuario 1
		clsUsuario usuario1 = new clsUsuario();
		usuario1.setEmail("nagorecb@opendeusto.es");	
		//usuario2
		clsUsuario usuario2 = new clsUsuario();
		usuario2.setEmail("maiderc@opendeusto.es");	
		//usuario3
		clsUsuario usuario3 = new clsUsuario();
		usuario3.setEmail("hodei.olaskoaga@opendeusto.es");	
		
		listaUsuarios.add(usuario1);
		listaUsuarios.add(usuario2);
		listaUsuarios.add(usuario3);
	}

	public clsFacebook(ArrayList<clsUsuario> listaUsuarios) throws RemoteException 
	{
		super();
		this.listaUsuarios = listaUsuarios;
	}

	public boolean ValidarUsuario (String email)
	{
		for (clsUsuario usuario : listaUsuarios) 
		{
			if(usuario.getEmail().equals(email))
			{
				return true;
			}
		}
		return false;	
	}
}
