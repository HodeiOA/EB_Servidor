package Facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import AppService.clsAppServiceUsuario;
import AppService.clsAppServiceVuelo;
import Assembler.VueloAssembler;
import Assembler.clsVueloDTO;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class Facade extends UnicastRemoteObject implements itfFacade 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private clsAppServiceUsuario appServiceUsuario;
	private clsAppServiceVuelo appServiceVuelo;

	protected Facade() throws RemoteException 
	{
		super();
	}

	@Override
	public boolean RegistrarUsuario(clsUsuario nuevoUsuario, boolean modo) 
	{
		return appServiceUsuario.RegistrarUsuario(nuevoUsuario, modo);
	}

	@Override
	public clsUsuario LoginUsuario(clsUsuario nuevoUsuario, boolean modo) 
	{
		return appServiceUsuario.LoginUsuario(nuevoUsuario, modo);
	}

	@Override
	public List<clsVueloDTO> BuscarVueloIda(clsAeropuerto aeropuesrtoPred, Date fecha, String ciudadOrigen,
			String ciudadDestino) 
	{
		ArrayList<clsVuelo> vuelosIda = new ArrayList();
		vuelosIda = appServiceVuelo.BuscarVueloIda(aeropuesrtoPred, fecha, ciudadOrigen, ciudadDestino);
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = VueloAssembler.assemble(vuelosIda);

		return vuelos;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloIdayVuelta(clsAeropuerto aeropuesrtoPred, Date fechaIda, Date fechaVuelta,
			String ciudadOrigen, String ciudadDestino) 
	{
		ArrayList<clsVuelo> vuelosIdaYVuelta = new ArrayList();
		vuelosIdaYVuelta = appServiceVuelo.BuscarVueloIdayVuelta(aeropuesrtoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = VueloAssembler.assemble(vuelosIdaYVuelta);

		return vuelos;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloCualquierMomento(clsAeropuerto aeropuesrtoPred, String ciudadOrigen,
			String ciudadDestino) 
	{
		ArrayList<clsVuelo> vuelosCualquierMomento = new ArrayList();
		vuelosCualquierMomento = appServiceVuelo.BuscarVueloCualquierMomento(aeropuesrtoPred, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = VueloAssembler.assemble(vuelosCualquierMomento);

		return vuelos;
	}

	@Override
	public boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero)
	{
		return appServiceVuelo.RealizarPagoyReserva(usuario, vuelo, numAsiento, nomViajero);
	}

}
