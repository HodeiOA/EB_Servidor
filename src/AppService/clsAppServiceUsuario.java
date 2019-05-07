package AppService;

import ObjetosDominio.clsUsuario;
import APIs.itfSistAutorizacionFacebook;
import Gateway.clsGateway;

public class clsAppServiceUsuario 
{
	public boolean RegistrarUsuario (clsUsuario nuevoUsuario, boolean modo)
	{
		boolean retorno = false;

		//Vemos si el usuario es reconocido por la API externa
		String args[] = null;
		boolean b = clsGateway.ValidarUsuario(nuevoUsuario.getEmail(), modo, args);
		
		if(b)
		{
			//El usuario ya estaba en la BD, no se puede rregistrar
			retorno = false;
		}
		else
		{
			retorno = true;
			//TO-DO: Llamada a DAO Para gaurdar
			//DAO.guardarObjeto(nuevoUsuario);
		}
		return false;		
	}
	
	public clsUsuario LoginUsuario (clsUsuario nuevoUsuario, boolean modo)
	{
		clsUsuario u = new clsUsuario();
		boolean retorno = false;
		//Antes de esto, en swing, darle valor a SistemaAutorización de usuario (Google o facebook)
		String args[] = null;
		boolean b = clsGateway.ValidarUsuario(nuevoUsuario.getEmail(), modo, args);
		
		if(b)
		{
			//El usuario ya estaba en la BD, puede loggearse
			retorno = true;
			//Leemos de la BD el usuario con ese email y lo devolvemos con todos sus atributos
			//DAO
		}
		else
		{
			retorno = false;
		}
		return u;	
	}
}
