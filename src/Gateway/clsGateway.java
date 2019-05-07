package Gateway;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Date;
import java.util.ArrayList;

import APIs.itfCargaVuelosAmericanAirlines;
import APIs.itfCargaVuelosIberia;
import APIs.itfCargaVuelosLufthansa;
import APIs.itfPasarela;
import APIs.itfSistAutorizacion;
import ObjetosDominio.clsVuelo;

public class clsGateway 
{
	ArrayList <clsVuelo> cargarIda(String ciudadOrigen, String  ciudadDestino, Date fecha, String[] args)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		try {
			Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String nameIberia = "//" + args[0] + ":" + args[1] + "/" + args[2];
			itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
			retorno = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String nameLufthansa = "//" + args[0] + ":" + args[1] + "/" + args[2];
			itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
			aux = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			
			for(clsVuelo v: aux)
			{
				retorno.add(v);
			}
			
			Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String nameAmericanAirlines = "//" + args[0] + ":" + args[1] + "/" + args[2];
			itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
			aux = AmericanAirlines.cargarIda(ciudadOrigen, ciudadDestino, fecha);
			for(clsVuelo v: aux)
			{
				retorno.add(v);
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
	
	ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, Date fechaIda,Date fechaVuelta, String[] args)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
				try {
					Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
					String nameIberia = "//" + args[0] + ":" + args[1] + "/" + args[2];
					itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
					retorno = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
					String nameLufthansa = "//" + args[0] + ":" + args[1] + "/" + args[2];
					itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
					aux = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					
					for(clsVuelo v: aux)
					{
						retorno.add(v);
					}
					
					Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
					String nameAmericanAirlines = "//" + args[0] + ":" + args[1] + "/" + args[2];
					itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
					aux = AmericanAirlines.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
					for(clsVuelo v: aux)
					{
						retorno.add(v);
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
	
	ArrayList <clsVuelo> cargarCualquierMomento(String ciudadOrigen, String ciudadDestino, String args[])
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		try {
			Registry registryIberia = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String nameIberia = "//" + args[0] + ":" + args[1] + "/" + args[2];
			itfCargaVuelosIberia iberia = (itfCargaVuelosIberia)registryIberia.lookup(nameIberia);
			retorno = iberia.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			Registry registryLufthansa = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String nameLufthansa = "//" + args[0] + ":" + args[1] + "/" + args[2];
			itfCargaVuelosLufthansa Lufthansa = (itfCargaVuelosLufthansa)registryLufthansa.lookup(nameLufthansa);
			aux = iberia.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			
			for(clsVuelo v: aux)
			{
				retorno.add(v);
			}
			
			Registry registryAmericanAirlines = LocateRegistry.getRegistry(((Integer.valueOf(args[1]))));
			String nameAmericanAirlines = "//" + args[0] + ":" + args[1] + "/" + args[2];
			itfCargaVuelosAmericanAirlines AmericanAirlines = (itfCargaVuelosAmericanAirlines)registryLufthansa.lookup(nameAmericanAirlines);
			aux = AmericanAirlines.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
			for(clsVuelo v: aux)
			{
				retorno.add(v);
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
	
	boolean ValidarUsuario (String email)
	{
		itfSistAutorizacion Sistema;
		boolean retorno = false;
		//Antes de llamar a este método, sistema tendrá que haber sido inicializado con facebook o google
		//Sistema.ValidarUsuario(email);
		return retorno;		
	}
	
	boolean RealizarPago (String numTarjetaCredito, itfPasarela Pasarela)
	{
		boolean retorno = false;
		//Antes de llamar a este método, pasarela tendrá que haber sido inicializado con paypal o visa
		Pasarela.RealizarPago(numTarjetaCredito);
		return retorno;	
		
	}
}
