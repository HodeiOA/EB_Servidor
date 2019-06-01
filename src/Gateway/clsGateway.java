package Gateway;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import APIs.itfCargaVuelosAmericanAirlines;
import APIs.itfCargaVuelosIberia;
import APIs.itfCargaVuelosLufthansa;
import APIs.itfPasarelaPaypal;
import APIs.itfPasarelaVisa;
import APIs.itfSistAutorizacionFacebook;
import APIs.itfSistAutorizacionGoogle;
import Assembler.clsAssemblerVuelo;
import ObjetosDominio.clsVuelo;

public class clsGateway implements itfGateway
{
	static String IP = "127.0.0.1";
	static String Puerto = "";
	static String Service = "";
	
	public ArrayList<clsVuelo> cargarIda(String ciudadOrigen, String  ciudadDestino, String fecha)
	{
		ArrayList<String> vueloToken = new ArrayList<String>();
		ArrayList<clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		
		try {
			Puerto = "1090";
			Service = "iberia";
			Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
			vueloToken = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			for(String vuelo: vueloToken)
			{
				retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
			}
			
			Puerto = "1091";
			Service = "lufthansa";
			Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameLufthansa = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
			vueloToken = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			for(String vuelo: vueloToken)
			{
				retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
			}
			
			Puerto = "1092";
			Service = "AmericanAirlines";
			Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameAmericanAirlines =  "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
			vueloToken = AmericanAirlines.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			for(String vuelo: vueloToken)
			{
				retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
			}
			
		} catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno;	
	}
	
	public ArrayList<clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda,String fechaVuelta)
	{
		ArrayList<String> vueloToken = new ArrayList<String>();
		ArrayList<clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		String args[] = null;
				try {
					Puerto = "1090";
					Service = "iberia";
					Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
					String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
					itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
					vueloToken = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					for(String vuelo: vueloToken)
					{
						retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
					}
					
					Puerto = "1091";
					Service = "Lufthansa";
					Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
					String nameLufthansa = "//" + IP + ":" +Puerto + "/" + Service;
					itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
					vueloToken = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					for(String vuelo: vueloToken)
					{
						retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
					}
					
					Puerto = "1092";
					Service = "AmericanAirlines";
					Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
					String nameAmericanAirlines = "//" + IP + ":" +Puerto + "/" + Service;
					itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
					vueloToken = AmericanAirlines.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					for(String vuelo: vueloToken)
					{
						retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
					}
					
				} catch (NumberFormatException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				catch (NotBoundException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		return retorno;	
	}
	
	public ArrayList<clsVuelo> cargarCualquierMomento(String ciudadOrigen, String ciudadDestino)
	{
		ArrayList<String> vueloToken = new ArrayList<String>();
		ArrayList<clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		try {
			Puerto = "1090";
			Service = "iberia";
			Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
			vueloToken = iberia.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			for(String vuelo: vueloToken)
			{
				retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
			}
			
			Puerto = "1091";
			Service = "lufthansa";
			Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameLufthansa ="//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
			vueloToken = iberia.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			for(String vuelo: vueloToken)
			{
				retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
			}
			
			Puerto = "1092";
			Service = "AmericanAirlines";
			Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameAmericanAirlines = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
			vueloToken = AmericanAirlines.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			for(String vuelo: vueloToken)
			{
				retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
			}
			
		} catch (NumberFormatException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (NotBoundException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;	
	}
	
	public boolean ValidarUsuario (String email, boolean modo)//modo =0 Google, =1 Facebook
	{
		boolean retorno = false;
		if(modo)
		{
			Registry registry;
			try 
			{
				Puerto = "1093";
				Service = "Facebook";
				registry = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
				String name ="//" + IP + ":" +Puerto + "/" + Service;
				itfSistAutorizacionFacebook facebook  = (itfSistAutorizacionFacebook)registry.lookup(name);
				retorno = facebook.ValidarUsuario(email);
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
			try 
			{
				Puerto = "1094";
				Service = "Google";
				Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
				String name = "//" + IP + ":" +Puerto + "/" + Service;
				itfSistAutorizacionGoogle google  = (itfSistAutorizacionGoogle)registry.lookup(name);
				retorno = google.ValidarUsuario(email);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return retorno;		
	}
	
	public boolean RealizarPago (String numTarjetaCredito, boolean modo)//0 Paypal 1 VISA
	{
		boolean retorno = false;
		if(modo)
		{
			try{
				Puerto = "1095";
				Service = "Visa";
				Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
				String name =  "//" + IP + ":" +Puerto + "/" + Service;
				itfPasarelaVisa visa  = (itfPasarelaVisa)registry.lookup(name);
				retorno = visa.RealizarPago(numTarjetaCredito);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else
		{
			try{
				Puerto = "1096";
				Service = "PayPal";
				Registry registry = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
				String name = "//" + IP + ":" +Puerto + "/" + Service;
				itfPasarelaPaypal paypal  = (itfPasarelaPaypal)registry.lookup(name);
				retorno = paypal.RealizarPago(numTarjetaCredito);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
		return retorno;	
	}

	@Override
	public ArrayList<clsVuelo> cargarTodos()
	{
		ArrayList<String> vueloToken = new ArrayList<String>();
		ArrayList<clsVuelo> retorno = new ArrayList<clsVuelo>();
		
		Puerto = "1090";
		Service = "iberia";
		Registry registryIberia;
		try {
			registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
		
		String nameIberia = "//" + IP + ":" + Puerto + "/" + Service;
		itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
		vueloToken = iberia.cargarTodos();
		
		for(String vuelo: vueloToken)
		{
			retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
		}
		
		Puerto = "1091";
		Service = "lufthansa";
		Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
		String nameLufthansa = "//" + IP + ":" + Puerto + "/" + Service;
		itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
		vueloToken = iberia.cargarTodos();
		
		for(String vuelo: vueloToken)
		{
			retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
		}
		
		Puerto = "1092";
		Service = "AmericanAirlines";
		Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
		String nameAmericanAirlines =  "//" + IP + ":" +Puerto + "/" + Service;
		itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
		vueloToken = AmericanAirlines.cargarTodos();
		
		for(String vuelo: vueloToken)
		{
			retorno.add(clsAssemblerVuelo.assembleToVuelo(vuelo));
		}
		
		} catch (NumberFormatException | RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return retorno;
	}
}
