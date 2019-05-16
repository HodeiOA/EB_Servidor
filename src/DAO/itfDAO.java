package DAO;

import java.util.ArrayList;
import java.util.HashSet;

import ObjetosDominio.clsAerolinea;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsPago;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public interface itfDAO 
{
	public void guardarObjeto(Object objeto);
	public ArrayList<clsAerolinea> leerTodasAerolineas();
	public ArrayList<clsAeropuerto> leerTodosAeropuertos();
	public ArrayList<clsUsuario> leerTodosUsuarios();
	public ArrayList<clsVuelo> leerTodosVuelos();
	public ArrayList<clsReserva> leerTodasReservas();
	public ArrayList<clsPago> leerTodosPagos();
	public void ActualizarVuelo (clsVuelo vuelo);

}
