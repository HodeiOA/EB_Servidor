package COMUN;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class VueloAssembler 
{
	public static List<VueloDTO> assemble(HashSet<clsVuelo> vuelos) 
	{
		List<VueloDTO> vuelosDTO = new ArrayList<>();

		for (clsVuelo v : vuelos) 
		{
			vuelosDTO.add(new VueloDTO(v.getFechaIda(), v.getNumAsientosLibres(), v.getPrecio()));
		}

		System.out.println("* Assembling Vuelos ...");
		
		return vuelosDTO;
	}
}
