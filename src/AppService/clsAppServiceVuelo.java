package AppService;

import java.sql.Date;
import java.util.ArrayList;

import DAO.clsDAO;
import DAO.itfDAO;
import Gateway.clsGateway;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsPago;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsAppServiceVuelo 
{
	itfDAO DAO = new clsDAO();
	clsGateway gateway= new clsGateway();
	
	public ArrayList <clsVuelo> BuscarVueloIda (clsAeropuerto aeropuesrtoPred, String fecha, String ciudadOrigen, String ciudadDestino)
	{
		//Lee todos los vuelos de DAO
		ArrayList <clsVuelo> VuelosGateway = gateway.cargarIda(ciudadOrigen, ciudadDestino, fecha);
		ArrayList <clsVuelo> TodosVuelos = DAO.leerTodosVuelos();//LEER DE DAO
		ArrayList <clsVuelo> VuelosRetorno  = new ArrayList<clsVuelo>();
		
		//En la primera vuelta sólo metemos los que tengan destino u origen igual al prefdeterminado
		for (clsVuelo v: TodosVuelos)
		{	for(clsVuelo vuelo: VuelosGateway)
			{
			//Si el vuelo leído por DAO coincide con el leido por Gateway, lo metemos 
				if(v.getCodVuelo().equals(vuelo.getCodVuelo()))
				{
					//Para poner arriba los que tengan el aeropuertio predeterminadp
				   if( (v.getAeropuertoOrigen()).equals(aeropuesrtoPred) || (v.getAeropuertoDestino()).equals(aeropuesrtoPred))
					VuelosRetorno.add(v);
				}
			}
		}
		//Una vez quedan lo más arriba los del aeropuesrto predeterminado, metemos el resto
		for (clsVuelo v: TodosVuelos)
		{	
			for(clsVuelo vuelo: VuelosGateway)
			{
				if(v.getCodVuelo().equals(vuelo.getCodVuelo()))
				{
					if( !((v.getAeropuertoOrigen()).equals(aeropuesrtoPred)) || !((v.getAeropuertoDestino()).equals(aeropuesrtoPred)))
						VuelosRetorno.add(v);
				}
			}
		}
		return VuelosRetorno;
	}
	
	public ArrayList <clsVuelo> BuscarVueloIdayVuelta (clsAeropuerto aeropuesrtoPred, String fechaIda, String fechaVuelta, String ciudadOrigen, String ciudadDestino)
	{
		
		//Lee todos los vuelos de DAO
		ArrayList <clsVuelo> VuelosGateway = gateway.cargarIdaVuelta(ciudadOrigen, ciudadDestino, fechaIda, fechaVuelta);
		ArrayList <clsVuelo> TodosVuelos = DAO.leerTodosVuelos();//LEER DE DAO
		ArrayList <clsVuelo> VuelosRetorno  = new ArrayList<clsVuelo>();
		
		//En la primera vuelta sólo metemos los que tengan destino u origen igual al prefdeterminado
		for (clsVuelo v: TodosVuelos)
		{	for(clsVuelo vuelo: VuelosGateway)
			{
			//Si el vuelo leído por DAO coincide con el leido por Gateway, lo metemos 
				if(v.getCodVuelo().equals(vuelo.getCodVuelo()))
				{
					//Para poner arriba los que tengan el aeropuertio predeterminadp
				   if( (v.getAeropuertoOrigen()).equals(aeropuesrtoPred) || (v.getAeropuertoDestino()).equals(aeropuesrtoPred))
					VuelosRetorno.add(v);
				}
			}
		}
		//Una vez quedan lo más arriba los del aeropuesrto predeterminado, metemos el resto
		for (clsVuelo v: TodosVuelos)
		{	
			for(clsVuelo vuelo: VuelosGateway)
			{
				if(v.getCodVuelo().equals(vuelo.getCodVuelo()))
				{
					if( !((v.getAeropuertoOrigen()).equals(aeropuesrtoPred)) || !((v.getAeropuertoDestino()).equals(aeropuesrtoPred)))
						VuelosRetorno.add(v);
				}
			}
		}
		return VuelosRetorno;
		
	}

	public ArrayList <clsVuelo> BuscarVueloCualquierMomento (clsAeropuerto aeropuesrtoPred, String ciudadOrigen, String ciudadDestino)
	{
		//Lee todos los vuelos de DAO
				ArrayList <clsVuelo> VuelosGateway = gateway.cargarCualquierMomento(ciudadOrigen, ciudadDestino);
				ArrayList <clsVuelo> TodosVuelos = DAO.leerTodosVuelos();//LEER DE DAO
				ArrayList <clsVuelo> VuelosRetorno  = new ArrayList<clsVuelo>();
				
				//En la primera vuelta sólo metemos los que tengan destino u origen igual al prefdeterminado
				for (clsVuelo v: TodosVuelos)
				{	for(clsVuelo vuelo: VuelosGateway)
					{
					//Si el vuelo leído por DAO coincide con el leido por Gateway, lo metemos 
						if(v.getCodVuelo().equals(vuelo.getCodVuelo()))
						{
							//Para poner arriba los que tengan el aeropuertio predeterminadp
						   if( (v.getAeropuertoOrigen()).equals(aeropuesrtoPred) || (v.getAeropuertoDestino()).equals(aeropuesrtoPred))
							VuelosRetorno.add(v);
						}
					}
				}
				//Una vez quedan lo más arriba los del aeropuesrto predeterminado, metemos el resto
				for (clsVuelo v: TodosVuelos)
				{	
					for(clsVuelo vuelo: VuelosGateway)
					{
						if(v.getCodVuelo().equals(vuelo.getCodVuelo()))
						{
							if( !((v.getAeropuertoOrigen()).equals(aeropuesrtoPred)) || !((v.getAeropuertoDestino()).equals(aeropuesrtoPred)))
								VuelosRetorno.add(v);
						}
					}
				}
				return VuelosRetorno;
	}

	public boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero, boolean pasarela) //Pasarela = 1 Visa = 0 Paypal
	{
		boolean pago = false;
		clsReserva reserva = new clsReserva(numAsiento, vuelo, usuario, nomViajero, vuelo.getPrecio());
		
			pago = gateway.RealizarPago(usuario.getNumTarjetaCredito(), pasarela);
			if(pago)
			{
				//ESCRIBIR RESERVA + CREAR PAGO + VUELO
				DAO.guardarObjeto(reserva);
				clsPago pagorealizado = new clsPago(reserva);
				DAO.guardarObjeto(pagorealizado);
				
				//El usuario se ha validado
				ArrayList <clsUsuario> lUsuarios = DAO.leerTodosUsuarios();
				clsUsuario u;
				for(clsUsuario aux: lUsuarios)
				{
					if(usuario.getEmail().equals(aux.getEmail()))
					{
						u = aux;
					}
				}
				usuario.addReserva(reserva);
				//UPDATE de DAO de usuario
				vuelo.addAsientoOcupado(numAsiento);
				vuelo.ReservaAsiento(numAsiento);
				DAO.ActualizarVuelo(vuelo);
			}
	
		return pago;		
	}
	public void leerTodosVuelosAPI()
	{
		ArrayList <clsVuelo> todos = gateway.cargarTodos();
		
		for(clsVuelo v: todos)
			DAO.guardarObjeto(v);
	}
}
