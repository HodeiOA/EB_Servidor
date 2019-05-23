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
	}

	@Override
	public boolean RegistrarUsuario(clsUsuario nuevoUsuario, boolean modo) 
	{
		//no hace falta crear DTO porque no se devuelve, solo se devuelve un boolean
		return appServiceUsuario.RegistrarUsuario(nuevoUsuario, modo);
	}

	@Override
	public clsUsuario LoginUsuario(clsUsuario nuevoUsuario, boolean modo) 
	{
		clsUsuario usuarioRet = new clsUsuario();
		usuarioRet = appServiceUsuario.LoginUsuario(nuevoUsuario, modo);
		
		clsUsuarioDTO usuDTO = new clsUsuarioDTO();
		usuDTO =clsAssemblerUsuario.assemble(usuarioRet);
		return usuarioRet;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloIda(clsAeropuerto aeropuertoPred, String fecha, String ciudadOrigen,
			String ciudadDestino) 
	{
		ArrayList<clsVuelo> vuelosIda = new ArrayList();
		vuelosIda = appServiceVuelo.BuscarVueloIda(aeropuertoPred, fecha, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = clsAssemblerVuelo.assemble(vuelosIda);

		return vuelos;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloIdayVuelta(clsAeropuerto aeropuertoPred, String fechaIda, String fechaVuelta,
			String ciudadOrigen, String ciudadDestino) 
	{
		ArrayList<clsVuelo> vuelosIdaYVuelta = new ArrayList();
		vuelosIdaYVuelta = appServiceVuelo.BuscarVueloIdayVuelta(aeropuertoPred, fechaIda, fechaVuelta, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = clsAssemblerVuelo.assemble(vuelosIdaYVuelta);

		return vuelos;
	}

	@Override
	public List<clsVueloDTO> BuscarVueloCualquierMomento(clsAeropuerto aeropuesrtoPred, String ciudadOrigen,
			String ciudadDestino) 
	{
		ArrayList<clsVuelo> vuelosCualquierMomento = new ArrayList();
		vuelosCualquierMomento = appServiceVuelo.BuscarVueloCualquierMomento(aeropuesrtoPred, ciudadOrigen, ciudadDestino);
		
		List<clsVueloDTO> vuelos = new ArrayList<>();
		vuelos = clsAssemblerVuelo.assemble(vuelosCualquierMomento);

		return vuelos;
	}

	@Override
	public boolean RealizarPagoyReserva (clsUsuario usuario, clsVuelo vuelo, int numAsiento, String nomViajero, boolean pasarela)
	{
		//no necesito DTO de esto xq se devuelve boolean
		return appServiceVuelo.RealizarPagoyReserva(usuario, vuelo, numAsiento, nomViajero, pasarela);
	}

	@Override
	public List<clsAeropuertoDTO> getListaAeropuertos() 
	{
		ArrayList<clsAeropuerto> listaAerop = new ArrayList();
		listaAerop = appServiceUsuario.getAeropuertos();
		
		List<clsAeropuertoDTO> aeropRet = new ArrayList<>();
		aeropRet = clsAssemblerAeropuerto.assemble(listaAerop);
		return aeropRet;
	}

	@Override
	public void LeerTodosVuelosAPI() 
	{
		
		appServiceVuelo.leerTodosVuelosAPI();
	}
	
	public void cerrarConexion()
	{
		appServiceUsuario.cerrarConexion();
	}
}
