package COMUN;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
<<<<<<< HEAD
=======
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.swing.text.html.ListView;
>>>>>>> e82e8d27a80d9dc49801ec6cdf932c2fe296cdce

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
<<<<<<< HEAD
	
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String Service = "Facebook";
=======
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String Service = "";
>>>>>>> e82e8d27a80d9dc49801ec6cdf932c2fe296cdce
	
	public static void main(String[] args)
	{
		if (System.getSecurityManager() == null)
		  {
		   System.setSecurityManager(new SecurityManager());
		  }
		  String name = "//" + IP + ":" + Puerto + "/" +Service;
		  try 
		  {  
<<<<<<< HEAD
		   itfSistAutorizacionFacebook objServer = new clsFacebook();
=======
		   itfFacade objServer = new Facade();
>>>>>>> e82e8d27a80d9dc49801ec6cdf932c2fe296cdce
		   Registry registry = LocateRegistry.createRegistry((Integer.valueOf(args[1])));
		   registry.rebind(name, objServer);
		 //Naming.rebind(name, objServer);
		   System.out.println("* Server '" + name + "' active and waiting...");
		  } 
		  catch (Exception e)
		  {
		   System.err.println("- Exception running the server: " + e.getMessage());
		   e.printStackTrace();
		  }
<<<<<<< HEAD
	}
	
=======

	}
>>>>>>> e82e8d27a80d9dc49801ec6cdf932c2fe296cdce
}
