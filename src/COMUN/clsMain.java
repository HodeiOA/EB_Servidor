package COMUN;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class clsMain
{
	
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String Service = "Facebook";
	
	public static void main(String[] args)
	{
		if (System.getSecurityManager() == null)
		  {
		   System.setSecurityManager(new SecurityManager());
		  }
		  String name = "//" + IP + ":" + Puerto + "/" +Service;
		  try 
		  {  
		   itfSistAutorizacionFacebook objServer = new clsFacebook();
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
	}
	
}
