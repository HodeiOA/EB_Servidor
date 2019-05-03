package Gateway;

import java.sql.Date;
import java.util.ArrayList;

import APIs.itfCargaVuelos;
import APIs.itfPasarela;
import APIs.itfSistAutorizacion;
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
	
	boolean ValidarUsuario (String email, itfSistAutorizacion Sistema)
	{
		boolean retorno = false;
		//Antes de llamar a este método, sistema tendrá que haber sido inicializado con facebook o google
		Sistema.ValidarUsuario(email);
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
