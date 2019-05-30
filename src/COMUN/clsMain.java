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

import Assembler.clsAssemblerAeropuerto;
import Assembler.clsAssemblerUsuario;
import Assembler.clsAssemblerVuelo;
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
			ArrayList <clsVuelo> vuelos = new ArrayList<clsVuelo>();
					//(ArrayList<clsVuelo>) objServer.LeerTodosVuelosAPI();
			clsAssemblerVuelo.todosVuelos = vuelos;
			
			ArrayList <clsUsuario> usuarios = new ArrayList <clsUsuario>();
			//Leer todos los usuarios de la api
			clsAssemblerUsuario.todosUsuarios = usuarios;
			
			ArrayList <clsAeropuerto> aeropuertos = new ArrayList <clsAeropuerto>();
			for(clsVuelo v: vuelos)
			{
				if((aeropuertos.contains(v.getAeropuertoDestino())))
				{
					aeropuertos.add(v.getAeropuertoDestino());
				}
				if((aeropuertos.contains(v.getAeropuertoOrigen())))
				{
					aeropuertos.add(v.getAeropuertoOrigen());
				}
			}
			clsAssemblerAeropuerto.todosAeropuertos=aeropuertos;
			
			ArrayList <clsVuelo> vuelosI = new ArrayList <clsVuelo>();
			ArrayList <clsVuelo> vuelosL = new ArrayList <clsVuelo>();
			ArrayList <clsVuelo> vuelosAA= new ArrayList <clsVuelo>();
			
			for ( clsVuelo v : vuelos)
			{
				if(v.getCodVuelo().contains("IB"))
				{
					vuelosI.add(v);
				}
				else if(v.getCodVuelo().contains("LUF"))
				{
					vuelosL.add(v);
				}
				else
				{
					vuelosAA.add(v);
				}
			}
			
			ArrayList <clsAerolinea> aerolineas = new ArrayList<clsAerolinea>();
			clsAerolinea iberia = new clsAerolinea ("IB",5,vuelosI,0);
			aerolineas.add(iberia);
			clsAerolinea lufthansa = new clsAerolinea ("LUF",10,vuelosL,0);
			aerolineas.add(lufthansa);
			clsAerolinea AmericanAirlines = new clsAerolinea ("AA",7.5,vuelosAA,0);
			aerolineas.add(AmericanAirlines);
			objServer.EscribirTodasAerolineas(aerolineas);
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
