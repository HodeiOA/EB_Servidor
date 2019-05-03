package AppService;

import java.sql.Date;
import java.util.ArrayList;

import APIs.itfPasarela;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsAppServiceVuelo 
{
	ArrayList <clsVuelo> BuscarVueloIda (clsAeropuerto aeropuesrtoPred, Date fecha, String ciudadOrigen, String ciudadDestino)
	{
		//Lee todos los vuelos de DAO
		ArrayList <clsVuelo> TodosVuelos = new ArrayList<clsVuelo>(); //Leer de DAO con el método de itfCargaVuelos:cargarIda
		ArrayList <clsVuelo> VuelosRetorno  = new ArrayList<clsVuelo>();
		
		//En la primera vuelta sólo metemos los que tengan destino u origen igual al prefdeterminado
		for (clsVuelo v: TodosVuelos)
		{	
			if( (v.getAeropuertoOrigen()).equals(aeropuesrtoPred) || (v.getAeropuertoDestino()).equals(aeropuesrtoPred))
				VuelosRetorno.add(v);
		}
		
		//Una vez quedan lo más arriba los del aeropuesrto predeterminado, metemos el resto
		for (clsVuelo v: TodosVuelos)
		{	
			if( !((v.getAeropuertoOrigen()).equals(aeropuesrtoPred)) || !((v.getAeropuertoDestino()).equals(aeropuesrtoPred)))
				VuelosRetorno.add(v);
		}
		return VuelosRetorno;
	}
	
	ArrayList <clsVuelo> BuscarVueloIdayVuelta (clsAeropuerto aeropuesrtoPred, Date fechaIda, Date fechaVuelta, String ciudadOrigen, String ciudadDestino)
	{
		
		//Lee todos los vuelos de DAO
		ArrayList <clsVuelo> TodosVuelos = new ArrayList<clsVuelo>(); //Leer de DAO con el método de itfCargaVuelos: cargarIdaVuelta
		ArrayList <clsVuelo> VuelosRetorno  = new ArrayList<clsVuelo>();
		
		//En la primera vuelta sólo metemos los que tengan destino u origen igual al prefdeterminado
		for (clsVuelo v: TodosVuelos)
		{	
			if( (v.getAeropuertoOrigen()).equals(aeropuesrtoPred) || (v.getAeropuertoDestino()).equals(aeropuesrtoPred))
				VuelosRetorno.add(v);
		}
		
		//Una vez quedan lo más arriba los del aeropuesrto predeterminado, metemos el resto
		for (clsVuelo v: TodosVuelos)
		{	
			if( !((v.getAeropuertoOrigen()).equals(aeropuesrtoPred)) || !((v.getAeropuertoDestino()).equals(aeropuesrtoPred)))
				VuelosRetorno.add(v);
		}
		return VuelosRetorno;
		
	}

	ArrayList <clsVuelo> BuscarVueloCualquierMomento (clsAeropuerto aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)
	{
		
		//Lee todos los vuelos de DAO
		ArrayList <clsVuelo> TodosVuelos = new ArrayList<clsVuelo>(); //Leer de DAO con el método de itfCargaVuelos: cargarCualquierMomento
		ArrayList <clsVuelo> VuelosRetorno  = new ArrayList<clsVuelo>();
		
		//En la primera vuelta sólo metemos los que tengan destino u origen igual al prefdeterminado
		for (clsVuelo v: TodosVuelos)
		{	
			if( (v.getAeropuertoOrigen()).equals(aeropuesrtoPred) || (v.getAeropuertoDestino()).equals(aeropuesrtoPred))
				VuelosRetorno.add(v);
		}
		
		//Una vez quedan lo más arriba los del aeropuesrto predeterminado, metemos el resto
		for (clsVuelo v: TodosVuelos)
		{	
			if( !((v.getAeropuertoOrigen()).equals(aeropuesrtoPred)) || !((v.getAeropuertoDestino()).equals(aeropuesrtoPred)))
				VuelosRetorno.add(v);
		}
		return VuelosRetorno;
	}

	boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero)
	{
		boolean pago = false;
		clsReserva reserva = new clsReserva(numAsiento, vuelo, usuario, nomViajero, vuelo.getPrecio());
		itfPasarela p = usuario.getPasarelaDePago();
		pago = p.RealizarPago(usuario.getNumTarjetaCredito());
		
		if(pago)
		{
			//TO DO: Escribimos la reserva con dao
		}
		vuelo.setNumAsientosLibres(vuelo.getNumAsientosLibres() - 1);
		vuelo.ReservaAsiento(numAsiento);
		//TO DO: Escribimos el vuelo con dao
		return pago;		
	}
}
