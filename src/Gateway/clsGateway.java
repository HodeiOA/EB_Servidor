package Gateway;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

import APIs.itfCargaVuelosAmericanAirlines;
import APIs.itfCargaVuelosIberia;
import APIs.itfCargaVuelosLufthansa;
import APIs.itfPasarela;
import APIs.itfPasarelaPaypal;
import APIs.itfPasarelaVisa;
import APIs.itfSistAutorizacionFacebook;
import APIs.itfSistAutorizacionGoogle;
import ObjetosDominio.clsVuelo;

public class clsGateway implements itfGateway
{
	static String IP = "127.0.0.1";
	static String Puerto = "1099";
	static String Service = "";
	
	public ArrayList <clsVuelo> cargarIda(String ciudadOrigen, String  ciudadDestino, String fecha)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		
		try {
			Service = "iberia";
			Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
			retorno = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			Service = "lufthansa";
			Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameLufthansa = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
			aux = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			for(clsVuelo v: aux)
			{
				retorno.add(v);
			}
			
			Service = "AmericanAirlines";
			Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameAmericanAirlines =  "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
			aux = AmericanAirlines.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			for(clsVuelo v: aux)
			{
				clsVuelo vueloaux = new clsVuelo(v.getAsientos(), v.getAsientosOcupados(), v.getCodVuelo(), v.getAeropuertoOrigen(), v.getAeropuertoDestino(),v.getFecha(), v.getPrecio(),null);
				retorno.add(vueloaux);
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
	
	public ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, String fechaIda,String fechaVuelta)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		String args[] = null;
				try {
					Service = "iberia";
					Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
					String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
					itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
					retorno = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					Service = "Lufthansa";
					Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
					String nameLufthansa = "//" + IP + ":" +Puerto + "/" + Service;
					itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
					aux = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					for(clsVuelo v: aux)
					{
						retorno.add(v);
					}
					Service = "AmericanAirlines";
					Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
					String nameAmericanAirlines = "//" + IP + ":" +Puerto + "/" + Service;
					itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
					aux = AmericanAirlines.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					for(clsVuelo v: aux)
					{
						clsVuelo vueloaux = new clsVuelo(v.getAsientos(), v.getAsientosOcupados(), v.getCodVuelo(), v.getAeropuertoOrigen(), v.getAeropuertoDestino(),v.getFecha(), v.getPrecio(),null);
						retorno.add(vueloaux);
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
	
	public ArrayList <clsVuelo> cargarCualquierMomento(String ciudadOrigen, String ciudadDestino)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		try {
			Service = "iberia";
			Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
			retorno = iberia.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			Service = "Lufthansa";
			Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameLufthansa ="//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
			aux = iberia.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			for(clsVuelo v: aux)
			{
				clsVuelo vueloaux = new clsVuelo(v.getAsientos(), v.getAsientosOcupados(), v.getCodVuelo(), v.getAeropuertoOrigen(), v.getAeropuertoDestino(),v.getFecha(), v.getPrecio(),null);
				retorno.add(vueloaux);
			}
			
			Service = "AmericanAirlines";
			Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
			String nameAmericanAirlines = "//" + IP + ":" +Puerto + "/" + Service;
			itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
			aux = AmericanAirlines.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			for(clsVuelo v: aux)
			{
				clsVuelo vueloaux = new clsVuelo(v.getAsientos(), v.getAsientosOcupados(), v.getCodVuelo(), v.getAeropuertoOrigen(), v.getAeropuertoDestino(),v.getFecha(), v.getPrecio(),null);
				retorno.add(vueloaux);
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
				Service = "Fcebook";
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
	public ArrayList<clsVuelo> cargarTodos() {
		
		ArrayList <clsVuelo> retorno = new ArrayList <clsVuelo> ();
		ArrayList <clsVuelo> aux = new ArrayList <clsVuelo> ();
		Service = "iberia";
		Registry registryIberia;
		try {
			registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
		
		String nameIberia = "//" + IP + ":" +Puerto + "/" + Service;
		itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
		retorno = iberia.cargarTodos();
		
		Service = "lufthansa";
		Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
		String nameLufthansa = "//" + IP + ":" +Puerto + "/" + Service;
		itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
		aux = iberia.cargarTodos();
		
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		
		Service = "AmericanAirlines";
		Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(Puerto))));
		String nameAmericanAirlines =  "//" + IP + ":" +Puerto + "/" + Service;
		itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
		aux = AmericanAirlines.cargarTodos();
		for(clsVuelo v: aux)
		{
			clsVuelo vueloaux = new clsVuelo(v.getAsientos(), v.getAsientosOcupados(), v.getCodVuelo(), v.getAeropuertoOrigen(), v.getAeropuertoDestino(),v.getFecha(), v.getPrecio(),null);
			retorno.add(vueloaux);
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
