package AppService;

import java.sql.Date;
import java.util.ArrayList;

import APIs.itfPasarela;
import Gateway.clsGateway;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsAppServiceVuelo 
{
	public ArrayList <clsVuelo> BuscarVueloIda (clsAeropuerto aeropuesrtoPred, java.util.Date fecha, String ciudadOrigen, String ciudadDestino)
	{
		//Lee todos los vuelos de DAO
		String args[] = null;
		ArrayList <clsVuelo> TodosVuelos = clsGateway.cargarIda(ciudadOrigen, ciudadDestino, fecha);//LEER DE DAO
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
	
	public ArrayList <clsVuelo> BuscarVueloIdayVuelta (clsAeropuerto aeropuesrtoPred, java.util.Date fechaIda, java.util.Date fechaVuelta, String ciudadOrigen, String ciudadDestino)
	{
		
		//Lee todos los vuelos de DAO
		ArrayList <clsVuelo> TodosVuelos = new ArrayList<clsVuelo>();
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

	public ArrayList <clsVuelo> BuscarVueloCualquierMomento (clsAeropuerto aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)
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

	public boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero, boolean pasarela) //Pasarela = 1 Visa = 0 Paypal
	{
		boolean pago = false;
		clsReserva reserva = new clsReserva(numAsiento, vuelo, usuario, nomViajero, vuelo.getPrecio());
		
			pago = clsGateway.RealizarPago(usuario.getNumTarjetaCredito(), pasarela);
			if(pago)
			{
				//ESCRIBIR RESERVA + CREAR PAGO + VUELO
				vuelo.setNumAsientosLibres(vuelo.getNumAsientosLibres() - 1);
				vuelo.ReservaAsiento(numAsiento);
			}
	
		return pago;		
	}
}
