package Assembler;

import java.util.ArrayList;
import java.util.List;

import ObjetosDominio.clsUsuario;

public class clsAssemblerUsuario 
{
	public static List<clsUsuarioDTO> assemble(ArrayList<clsUsuario> usuarios) 
	{
		List<clsUsuarioDTO> usuariosDTO = new ArrayList<>();

		for (clsUsuario u : usuarios) 
		{
			usuariosDTO.add(new clsUsuarioDTO(u.getEmail(),u.getNumTarjetaCredito(),u.getAeroPreder(),u.getListpagos()));
		}

		System.out.println("* Assembling usuarios ...");
		
		return usuariosDTO;
	}
	
	public static clsUsuarioDTO assemble(clsUsuario usuario) 
	{
		clsUsuarioDTO usuarioDTO = new clsUsuarioDTO();

		usuarioDTO=new clsUsuarioDTO(usuario.getEmail(),usuario.getNumTarjetaCredito(),usuario.getAeroPreder(),usuario.getListpagos());

		System.out.println("* Assembling usuario ...");
		
		return usuarioDTO;
	
	}
}
