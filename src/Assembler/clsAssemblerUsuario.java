package Assembler;

import java.util.ArrayList;
import java.util.List;

import ObjetosDominio.clsUsuario;

public class clsAssemblerUsuario 
{
	public static List<clsUsuarioDTO> assembleToUsuarioDTO(ArrayList<clsUsuario> usuarios) 
	{
		List<clsUsuarioDTO> usuariosDTO = new ArrayList<>();

		for (clsUsuario u : usuarios) 
		{
			usuariosDTO.add(new clsUsuarioDTO(u.getEmail(),u.getNumTarjetaCredito(),u.getAeroPreder()));
		}

		System.out.println("* Assembling usuarios ...");
		
		return usuariosDTO;
	}
	
	public static clsUsuarioDTO assembleToUsuarioDTO(clsUsuario usuario) 
	{
		clsUsuarioDTO usuarioDTO = new clsUsuarioDTO();

		usuarioDTO=new clsUsuarioDTO(usuario.getEmail(),usuario.getNumTarjetaCredito(),usuario.getAeroPreder());

		System.out.println("* Assembling usuario ...");
		
		return usuarioDTO;
	
	}
	public static List<clsUsuario> assembleToUsuario(ArrayList<clsUsuarioDTO> usuariosDTO) 
	{
		List<clsUsuario> usuarios = new ArrayList<>();

		for (clsUsuario u : usuarios) 
		{
			usuarios.add(new clsUsuario(u.getEmail(),u.getAeroPreder(),u.getNumTarjetaCredito()));
		}

		System.out.println("* Assembling usuarios ...");
		
		return usuarios;
	}
	
	public static clsUsuario assembleToUsuario(clsUsuarioDTO usuarioDTO) 
	{
		clsUsuario usuario = new clsUsuario();

		usuario=new clsUsuario(usuario.getEmail(),usuario.getAeroPreder(),usuario.getNumTarjetaCredito());

		System.out.println("* Assembling usuario ...");
		
		return usuario;
	
	}
}
