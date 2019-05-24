package COMUN;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.swing.text.html.ListView;

import Facade.Facade;
import Facade.itfFacade;
import ObjetosDominio.clsAerolinea;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsPago;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsMain
{
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String Service = "EasyBooking";
	
	public static void main(String[] args)
	{
		
		itfFacade objServer = null;
		try 
		{
			objServer = new Facade();
//			objServer.LeerTodosVuelosAPI();
		} 
		catch (RemoteException e1) 
		{
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (System.getSecurityManager() == null)
		  {
		   System.setSecurityManager(new SecurityManager());
		  }
		  String name = "//" + IP + ":" + Puerto + "/" +Service;
		  try 
		  {  
		   Registry registry = LocateRegistry.createRegistry((Integer.valueOf(Puerto)));
		   registry.rebind(name, objServer);
		 //Naming.rebind(name, objServer);
		   System.out.println("* Server '" + name + "' active and waiting...");
		  } 
		  catch (Exception e)
		  {
		   System.err.println("- Exception running the server: " + e.getMessage());
		   e.printStackTrace();
		  }
		  try {
			objServer.cerrarConexion();
		} catch (RemoteException e)
		  {
			e.printStackTrace();
		}
		  
	}
}
