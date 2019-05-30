package Assembler;

import java.util.ArrayList;
import java.util.List;

import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsAssemblerVuelo 
{
	public static ArrayList <clsVuelo> todosVuelos;
	public static List<clsVueloDTO> assembleToVueloDTO(ArrayList<clsVuelo> vuelos) 
	{
		List<clsVueloDTO> vuelosDTO = new ArrayList<>();

		for (clsVuelo v : vuelos) 
		{
			vuelosDTO.add(new clsVueloDTO(v.getCodVuelo(),v.getFecha(),v.getAsientos(), v.getPrecio(), v.getAsientosOcupados()));
		}

		System.out.println("* Assembling Vuelos ...");
		
		return vuelosDTO;
	}
	public static List<clsVuelo> assembleToVuelo(ArrayList<clsVueloDTO> vuelosDTO) 
	{
		List<clsVuelo> vuelos = new ArrayList<>();

		for (clsVueloDTO v: vuelosDTO)
		{		
			vuelos.add(new clsVuelo(v.getAsientos(),v.getAsientosOcupados(),v.getCodVuelo(),v.getFecha(),v.getPrecio()));
		}

		System.out.println("* Assembling Vuelos ...");
		
		return vuelos;
	}
	public static clsVuelo assembleToVuelo(clsVueloDTO vueloDTO) 
	{
		clsVuelo vuelo = new clsVuelo();

		vuelo = new clsVuelo(vueloDTO.getAsientos(),vueloDTO.getAsientosOcupados(),vueloDTO.getCodVuelo(),vueloDTO.getFecha(),vueloDTO.getPrecio());
		

		System.out.println("* Assembling Vuelos ...");
		
		return vuelo;
	}

}
