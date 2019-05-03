package Gateway;

import java.sql.Date;
import java.util.ArrayList;

import APIs.itfCargaVuelos;
import ObjetosDominio.clsVuelo;

public class clsGateway 
{
	ArrayList <clsVuelo> cargarIda(String ciudadOrigen, String  ciudadDestino, Date fecha)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		/*
		itfCargaVuelos iberia = new Iberia();
		itfCargaVuelos lufthansa = new Lufthansa();
		itfCargaVuelos americaAirlanes = new AmericaAirlanes();
		
		retorno = iberia.cargarIda(ciudadOrigen, ciudadDestino, fecha);
		aux = lufthansa.cargarIda(ciudadOrigen, ciudadDestino, fecha);
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		aux = americanAirlanes.cargarIda(ciudadOrigen, ciudadDestino, fecha);
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		*/
		return retorno;	
	}
	
	ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, Date fechaIda,Date fechaVuelta)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		/*
		itfCargaVuelos iberia = new Iberia();
		itfCargaVuelos lufthansa = new Lufthansa();
		itfCargaVuelos americaAirlanes = new AmericaAirlanes();
		
		retorno = iberia.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
		aux = lufthansa.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		aux = americanAirlanes.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda,fechaVuelta);
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		*/
		return retorno;	
	}
	
	ArrayList <clsVuelo> cargarCualquierMomento(String ciudadOrigen, String ciudadDestino)
	{
		ArrayList <clsVuelo> aux = new ArrayList<clsVuelo>();
		ArrayList <clsVuelo> retorno = new ArrayList<clsVuelo>();
		//Cargamos los vuelos de cada aerolínea
		/*
		itfCargaVuelos iberia = new Iberia();
		itfCargaVuelos lufthansa = new Lufthansa();
		itfCargaVuelos americaAirlanes = new AmericaAirlanes();
		
		retorno = iberia.cargarCualquierMomento(ciudadoOrigen, ciudadDestino);
		aux = lufthansa.cargarCualquierMomento(ciudadoOrigen, ciudadDestino);
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		aux = americanAirlanes.cargarCualquierMomento(ciudadoOrigen, ciudadDestino);
		for(clsVuelo v: aux)
		{
			retorno.add(v);
		}
		*/
		return retorno;	
		
	}
}
