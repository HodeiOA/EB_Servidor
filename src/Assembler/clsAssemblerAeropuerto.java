package Assembler;

import java.util.ArrayList;
import java.util.List;

import ObjetosDominio.clsAeropuerto;

public class clsAssemblerAeropuerto 
{
	public static ArrayList <clsAeropuerto> todosAeropuertos;
	
	public static List<clsAeropuertoDTO> assembleToAeropuertoDTO(ArrayList<clsAeropuerto> aeropuertos) 
	{
		List<clsAeropuertoDTO> aeropuertosDTO = new ArrayList<>();

		for (clsAeropuerto a: aeropuertos)
		{
			aeropuertosDTO.add(new clsAeropuertoDTO(a.getCodAeropuerto(),a.getCiudad(),a.getPais()));
		}
		
		System.out.println("* Assembling aeropuertos ...");
		
		return aeropuertosDTO;
	}
	
	public static List<clsAeropuerto> assembleToAeropuerto(ArrayList<clsAeropuertoDTO> aeropuertosDTO) 
	{
		List<clsAeropuerto> aeropuertos = new ArrayList<>();

		for (clsAeropuertoDTO a: aeropuertosDTO) 
		{
			aeropuertos.add(new clsAeropuerto(a.getCodAeropuerto(),a.getCiudad(),a.getPais()));
		}
		System.out.println("* Assembling aeropuertos ...");
		
		return aeropuertos;
	}
	public static clsAeropuerto assembleToAeropuerto(clsAeropuertoDTO aeropuertoDTO) 
	{
		clsAeropuerto aeropuerto = new clsAeropuerto();

		aeropuerto = new clsAeropuerto(aeropuertoDTO.getCodAeropuerto(), aeropuertoDTO.getCiudad(), aeropuertoDTO.getPais());
		
		return aeropuerto;
	}
	
	public static clsAeropuerto assembleToAeropuerto(String stringAeropuerto) 
	{
		String[] datosAeropuerto = stringAeropuerto.split(";");
		clsAeropuerto aeropuerto = new clsAeropuerto();

		aeropuerto.setCodAeropuerto(datosAeropuerto[0]);
		aeropuerto.setCiudad(datosAeropuerto[1]);
		aeropuerto.setPais(datosAeropuerto[2]);
		
		for (clsAeropuerto aero: todosAeropuertos) {
			if (aero.getCodAeropuerto() == datosAeropuerto[0]) {
				aeropuerto.setlLLegadas(aero.getlLLegadas());				
				aeropuerto.setlSalidas(aero.getlSalidas());
				aeropuerto.setlUsuarios(aero.getlUsuarios());
			}
		}
		
		return aeropuerto;
	}

	public static List<clsAeropuerto> assembleToAeropuerto(List<String> datosAeropuertos)
	{
		List<clsAeropuerto> aeropuertos = new ArrayList<clsAeropuerto>();
		
		for (String datosAeropuerto : datosAeropuertos) {
			aeropuertos.add(assembleToAeropuerto(datosAeropuerto));
		}
		
		return aeropuertos;
	}
}
