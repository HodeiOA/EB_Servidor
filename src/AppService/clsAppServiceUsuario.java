package AppService;

import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsUsuario;

import java.util.ArrayList;

import APIs.itfSistAutorizacionFacebook;
import DAO.clsDAO;
import DAO.itfDAO;
import Gateway.clsGateway;
import Gateway.itfGateway;

public class clsAppServiceUsuario 
{
	itfDAO DAO = new clsDAO();
	itfGateway gateway= new clsGateway();
	
	public boolean RegistrarUsuario(clsUsuario nuevoUsuario, boolean modo)
	{
		boolean retorno;

		//Vemos si el usuario es reconocido por la API externa
		retorno = gateway.ValidarUsuario(nuevoUsuario.getEmail(), modo);
		
		if(retorno)
		{
			DAO.guardarObjeto(nuevoUsuario);
		}
		else
		{
			//El usuario no se puede validar
		}
		
		return retorno;
	}
	
	public clsUsuario LoginUsuario(clsUsuario nuevoUsuario, boolean modo)
	{
		ArrayList<clsUsuario> lUsuarios;
		clsUsuario u = null;
		
		boolean validar = gateway.ValidarUsuario(nuevoUsuario.getEmail(), modo);
		
		if(validar)
		{
			//El usuario se ha validado
			lUsuarios = DAO.leerTodosUsuarios();
			
			for(clsUsuario aux: lUsuarios)
			{
				if(nuevoUsuario.getEmail().equals(aux.getEmail()))
				{
					u = aux;
				}
			}
		}
		else
		{
			//No se puede validar el email
		}
		
		return u;
	}
	
	public ArrayList <clsAeropuerto>getAeropuertos ()
	{
		ArrayList <clsAeropuerto> retorno = DAO.leerTodosAeropuertos();
		return retorno;
	}
}
