package Assembler;

import java.util.ArrayList;
import java.util.List;

import ObjetosDominio.clsAeropuerto;

public class clsAssemblerAeropuerto 
{
	public static List<clsAeropuertoDTO> assemble(ArrayList<clsAeropuerto> aeropuertos) 
	{
		List<clsAeropuertoDTO> aeropuertosDTO = new ArrayList<>();

		for (clsAeropuerto a : aeropuertos) 
		{
			aeropuertosDTO.add(new clsAeropuertoDTO(a.getCodAeropuerto(),a.getCiudad(),a.getPais()));
		}
//,ArrayList<clsVuelo> lSalidas, ArrayList<clsVuelo> lLLegadas
		System.out.println("* Assembling aeropuertos ...");
		
		return aeropuertosDTO;
	}
}
