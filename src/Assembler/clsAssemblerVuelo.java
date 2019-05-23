package Assembler;

import java.util.ArrayList;
import java.util.List;

import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsAssemblerVuelo 
{
	public static List<clsVueloDTO> assemble(ArrayList<clsVuelo> vuelos) 
	{
		List<clsVueloDTO> vuelosDTO = new ArrayList<>();

		for (clsVuelo v : vuelos) 
		{
			vuelosDTO.add(new clsVueloDTO(v.getFecha(),v.getAsientos(), v.getPrecio(), v.getAsientosOcupados()));
		}

		System.out.println("* Assembling Vuelos ...");
		
		return vuelosDTO;
	}
	

}
