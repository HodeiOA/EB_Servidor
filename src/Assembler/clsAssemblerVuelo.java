package Assembler;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.ParseInfo;

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
	
	public static clsVuelo assembleToVuelo (String stringVuelo)
	{		
		String[] datosVuelo = stringVuelo.split(";");
		clsVuelo vuelo = new clsVuelo();
		
		vuelo.setCodVuelo(datosVuelo[0]);
		for (clsAeropuerto aero : clsAssemblerAeropuerto.todosAeropuertos) 
		{
			if(aero.getCodAeropuerto()==datosVuelo[1])
			{
				vuelo.setAeropuertoOrigen(aero);
				break;
			}
		}
		for (clsAeropuerto aero : clsAssemblerAeropuerto.todosAeropuertos) 
		{
			if(aero.getCodAeropuerto()==datosVuelo[2])
			{
				vuelo.setAeropuertoDestino(aero);
				break;
			}
		}
		vuelo.setFecha(datosVuelo[3]);
		vuelo.setPrecio(Double.parseDouble(datosVuelo[4]));
		
		ArrayList<Integer> asientos = new ArrayList<Integer>();
		int aux = Integer.parseInt(datosVuelo[5]);
		for (int i = 0; i < aux+1; i++) 
		{
			asientos.add(i);
		}
		vuelo.setAsientos(asientos);
		
		return vuelo;
	}
	
	public static List<clsVuelo> assembleToVuelo(List<String> datosVuelos)
	{
		List<clsVuelo> vuelos = new ArrayList<clsVuelo>();
		
		for (String string : datosVuelos) 
		{
			vuelos.add(assembleToVuelo(string));
		}
		
		return vuelos;
	}

}
