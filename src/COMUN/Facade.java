package COMUN;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramAssembler;
import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;

public class Facade extends UnicastRemoteObject implements itfFacade 
{
	private AppService appService;

	protected Facade() throws RemoteException 
	{
		super();
	}

	@Override
	public boolean RegistrarUsuario(clsUsuario nuevoUsuario) 
	{
		return appService.registrarUsuario(nuevoUsuario);
	}

	@Override
	public boolean LoginUsuario(clsUsuario nuevoUsuario) 
	{
		return appService.loginUsuario(nuevoUsuario);
	}

	@Override
	public List<VueloDTO> BuscarVueloIda(clsAeropuerto aeropuesrtoPred, Date fecha, String ciudadOrigen,
			String ciudadDestino) 
	{
		HashSet<clsVuelo> vuelosIda = new HashSet();
		vuelosIda = appService.BuscarVueloIda(aeropuesrtoPred, fecha, ciudadOrigen, ciudadDestino);
		
		List<VueloDTO> vuelos = new ArrayList<>();
		vuelos = VueloAssembler.assemble(vuelosIda);

		return vuelos;
	}

	@Override
	public List<VueloDTO> BuscarVueloIdayVuelta(clsAeropuerto aeropuesrtoPred, Date fechaIda, Date fechaVuelta,
			String ciudadOrigen, String ciudadDestino) 
	{
		HashSet<clsVuelo> vuelosIdaYVuelta = new HashSet();
		vuelosIdaYVuelta = appService.BuscarVueloIdayVuelta(aeropuesrtoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
		
		List<VueloDTO> vuelos = new ArrayList<>();
		vuelos = VueloAssembler.assemble(vuelosIdaYVuelta);

		return vuelos;
	}

	@Override
	public List<VueloDTO> BuscarVueloCualquierMomento(clsAeropuerto aeropuesrtoPred, String ciudadOrigen,
			String ciudadDestino) 
	{
		HashSet<clsVuelo> vuelosCualquierMomento = new HashSet();
		vuelosCualquierMomento = appService.BuscarVueloCualquierMomento(aeropuesrtoPred, ciudadOrigen, ciudadDestino);
		
		List<VueloDTO> vuelos = new ArrayList<>();
		vuelos = VueloAssembler.assemble(vuelosCualquierMomento);

		return vuelos;
	}

	@Override
	public boolean RealizarPagoyReserva(clsUsuario usuario, clsVuelo vuelo) 
	{
		return appService.RealizarPagoyReserva(usuario, vuelo);
	}
	
}
