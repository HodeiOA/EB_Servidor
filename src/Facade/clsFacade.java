package Facade;
//package COMUN;
//
//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramAssembler;
//import es.deusto.ingenieria.sd.sms.server.data.dto.TVProgramDTO;
//
//public class Facade extends UnicastRemoteObject implements itfFacade 
//{
//	private AppService appService;
//
//	protected Facade() throws RemoteException 
//	{
//		super();
//	}
//
//	@Override
//	public boolean RegistrarUsuario(clsUsuario nuevoUsuario) 
//	{
//		return appService.registrarUsuario(nuevoUsuario);
//	}
//
//	@Override
//	public clsUsuario LoginUsuario(clsUsuario nuevoUsuario) 
//	{
//		return appService.loginUsuario(nuevoUsuario);
//	}
//
//	@Override
//	public List<VueloDTO> BuscarVueloIda(clsAeropuerto aeropuesrtoPred, Date fecha, String ciudadOrigen,
//			String ciudadDestino) 
//	{
//		ArrayList<clsVuelo> vuelosIda = new ArrayList();
//		vuelosIda = appService.BuscarVueloIda(aeropuesrtoPred, fecha, ciudadOrigen, ciudadDestino);
//		
//		List<VueloDTO> vuelos = new ArrayList<>();
//		vuelos = VueloAssembler.assemble(vuelosIda);
//
//		return vuelos;
//	}
//
//	@Override
//	public List<VueloDTO> BuscarVueloIdayVuelta(clsAeropuerto aeropuesrtoPred, Date fechaIda, Date fechaVuelta,
//			String ciudadOrigen, String ciudadDestino) 
//	{
//		ArrayList<clsVuelo> vuelosIdaYVuelta = new ArrayList();
//		vuelosIdaYVuelta = appService.BuscarVueloIdayVuelta(aeropuesrtoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
//		
//		List<VueloDTO> vuelos = new ArrayList<>();
//		vuelos = VueloAssembler.assemble(vuelosIdaYVuelta);
//
//		return vuelos;
//	}
//
//	@Override
//	public List<VueloDTO> BuscarVueloCualquierMomento(clsAeropuerto aeropuesrtoPred, String ciudadOrigen,
//			String ciudadDestino) 
//	{
//		ArrayList<clsVuelo> vuelosCualquierMomento = new ArrayList();
//		vuelosCualquierMomento = appService.BuscarVueloCualquierMomento(aeropuesrtoPred, ciudadOrigen, ciudadDestino);
//		
//		List<VueloDTO> vuelos = new ArrayList<>();
//		vuelos = VueloAssembler.assemble(vuelosCualquierMomento);
//
//		return vuelos;
//	}
//
//	@Override
//	boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo, vuelo, int numAsiento, int nomViajero);
//	{
//		return appService.RealizarPagoyReserva(usuario, vuelo, numAsiento, nomViajero);
//	}
//	
//}
