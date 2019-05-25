package Facade;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import AppService.clsAppServiceUsuario;
import AppService.clsAppServiceVuelo;
import Assembler.clsAeropuertoDTO;
import Assembler.clsAssemblerAeropuerto;
import Assembler.clsAssemblerUsuario;
import Assembler.clsAssemblerVuelo;
import Assembler.clsUsuarioDTO;
import Assembler.clsVueloDTO;
import ObjetosDominio.clsAerolinea;
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

	public Facade() throws RemoteException 
	{
		super();
		appServiceUsuario = new clsAppServiceUsuario();
		appServiceVuelo = new clsAppServiceVuelo();
	}

	@Override
//	public boolean RegistrarUsuario(clsUsuario nuevoUsuario, boolean modo) 
//	{
//		//cambiar clUsuario a usuario dto
//		
//		//no hace falta crear DTO porque no se devuelve, solo se devuelve un boolean
//		return appServiceUsuario.RegistrarUsuario(nuevoUsuario, modo);
//	}
	public boolean RegistrarUsuario(clsUsuarioDTO nuevoUsuario, boolean modo) 
	{
		clsUsuario usuNormal = new clsUsuario();
		usuNormal = clsAssemblerUsuario.assembleToUsuario(nuevoUsuario);
		
		return appServiceUsuario.RegistrarUsuario(usuNormal, modo);
	}

	@Override
	public clsUsuarioDTO LoginUsuario(clsUsuarioDTO nuevoUsuario, boolean modo) 
	{
		clsUsuario usuNormal = new clsUsuario();
		usuNormal = clsAssemblerUsuario.assembleToUsuario(nuevoUsuario);
		
		clsUsuario usuarioRet = new clsUsuario();
		usuarioRet = appServiceUsuario.LoginUsuario(usuNormal, modo);
		
		clsUsuarioDTO usuDTO = new clsUsuarioDTO();
		usuDTO =clsAssemblerUsuario.assembleToUsuarioDTO(usuarioRet);
		
		return usuDTO;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloIda(clsAeropuertoDTO aeropuertoPred, String fecha, String ciudadOrigen,
			String ciudadDestino) 
	{
		clsAeropuerto aeroNormal = new clsAeropuerto();
		aeroNormal = clsAssemblerAeropuerto.assembleToAeropuerto(aeropuertoPred);
		
		ArrayList<clsVuelo> vuelosIda = new ArrayList();
		vuelosIda = appServiceVuelo.BuscarVueloIda(aeroNormal, fecha, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = clsAssemblerVuelo.assembleToVueloDTO(vuelosIda);

		return vuelos;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloIdayVuelta(clsAeropuertoDTO aeropuertoPred, String fechaIda, String fechaVuelta,
			String ciudadOrigen, String ciudadDestino) 
	{
		clsAeropuerto aeroNormal = new clsAeropuerto();
		aeroNormal = clsAssemblerAeropuerto.assembleToAeropuerto(aeropuertoPred);
		
		ArrayList<clsVuelo> vuelosIdaYVuelta = new ArrayList();
		vuelosIdaYVuelta = appServiceVuelo.BuscarVueloIdayVuelta(aeroNormal, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = clsAssemblerVuelo.assembleToVueloDTO(vuelosIdaYVuelta);

		return vuelos;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloCualquierMomento(clsAeropuertoDTO aeropuertoPred, String ciudadOrigen,
			String ciudadDestino) 
	{
		clsAeropuerto aeroNormal = new clsAeropuerto();
		aeroNormal = clsAssemblerAeropuerto.assembleToAeropuerto(aeropuertoPred);
		
		ArrayList<clsVuelo> vuelosCualquierMomento = new ArrayList();
		vuelosCualquierMomento = appServiceVuelo.BuscarVueloCualquierMomento(aeroNormal, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = clsAssemblerVuelo.assembleToVueloDTO(vuelosCualquierMomento);

		return vuelos;
	}

	@Override
	public boolean RealizarPagoyReserva (clsUsuarioDTO usuario, clsVueloDTO vuelo, int numAsiento, String nomViajero, boolean pasarela)
	{
		clsUsuario usuNormal = new clsUsuario();
		usuNormal = clsAssemblerUsuario.assembleToUsuario(usuario);
		
		clsVuelo vueloNormal = new clsVuelo();
		vueloNormal = clsAssemblerVuelo.assembleToVuelo(vuelo);
		
		return appServiceVuelo.RealizarPagoyReserva(usuNormal, vueloNormal, numAsiento, nomViajero, pasarela);
	}

	@Override
	public List<clsAeropuertoDTO> getListaAeropuertos() 
	{
		ArrayList<clsAeropuerto> listaAerop = new ArrayList();
		listaAerop = appServiceUsuario.getAeropuertos();
		
		List<clsAeropuertoDTO> aeropRet = new ArrayList<>();
		aeropRet = clsAssemblerAeropuerto.assembleToAeropuertoDTO(listaAerop);
		return aeropRet;
	}

	@Override
	public List <clsVuelo> LeerTodosVuelosAPI() 
	{
		ArrayList<clsVuelo> vuelos = new ArrayList<clsVuelo> ();
		vuelos=appServiceVuelo.leerTodosVuelosAPI();
		return vuelos;
	}
	
	public void cerrarConexion()
	{
		appServiceUsuario.cerrarConexion();
	}

	@Override
	public void EscribirTodasAerolineas(List<clsAerolinea> aerolineas) throws RemoteException {
		appServiceVuelo.EscribirTodasAerolineas(aerolineas);
		
	}
}
