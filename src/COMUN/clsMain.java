package COMUN;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.swing.text.html.ListView;

import ObjetosDominio.clsAerolinea;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsPago;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsMain
{
	//Cargamos el Persistence Manager Factory
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	//Cragamos el Persistence Manager
	static PersistenceManager pm = pmf.getPersistenceManager();
	//Transacción para agrupar varias operaciones de BBDD
	static Transaction tx = pm.currentTransaction();;
			
	public static void main(String[] args)
	{
		System.out.println("Prueba de JDO");
		System.out.println("-----------------------------");
		ArrayList <Integer> asientos = new ArrayList <Integer>();
		ArrayList <Integer> asientosOcupados = new ArrayList <Integer>();
		
		for (int i=0; i<120; i++)
		{
			asientos.add(i);
		}
		//Creando objetos y las listas
		clsAerolinea aerolinea = new clsAerolinea("IB", 10.0);
		
		clsAeropuerto aeropuerto1 = new clsAeropuerto("BCN", "Barcelona", "España");
		clsAeropuerto aeropuerto2 = new clsAeropuerto("DUB", "Dublin", "Irlanda");
		
		clsUsuario usuario = new clsUsuario("prueba@prueba.com", null, null, aeropuerto1, null, "123");
		//( ArrayList<Integer> Asientos,  ArrayList<Integer> AsientosOcupados, String codVuelo, clsAeropuerto aeropuertoOrigen, clsAeropuerto aeropuertoDestino, String fecha, double precio, ArrayList<clsReserva> listaReservas, ArrayList <Integer> asientos) 
		clsVuelo vueloIda = new clsVuelo(asientos, asientosOcupados,"IB001", aeropuerto1, aeropuerto2, "23/05/2019", 180.99, null, null);
		clsVuelo vueloVuelta = new clsVuelo(asientos, asientosOcupados, "IB002", aeropuerto2, aeropuerto1, "30/05/2019",200, null, null);
		
		clsReserva reservaIda = new clsReserva(1, vueloIda, usuario, "Juan García", vueloIda.getPrecio());
		clsReserva reservaVuelta = new clsReserva(1, vueloVuelta, usuario, "Juan García", vueloVuelta.getPrecio());
		
		clsPago pagoIda = new clsPago(reservaIda);
		clsPago pagoVuelta = new clsPago(reservaVuelta);
		
		HashSet<clsAerolinea> listaAerolineas = new HashSet<clsAerolinea>();
		listaAerolineas.add(aerolinea);
		
		HashSet<clsAeropuerto> listaAeropuertos = new HashSet<clsAeropuerto>();
		listaAeropuertos.add(aeropuerto1);
		listaAeropuertos.add(aeropuerto2);
		
		HashSet<clsUsuario> listaUsuarios = new HashSet<clsUsuario>();
		listaUsuarios.add(usuario);
		
		HashSet<clsVuelo> listaVuelos = new HashSet<clsVuelo>();
		listaVuelos.add(vueloIda);
		listaVuelos.add(vueloVuelta);
		
		HashSet<clsReserva> listaReservas = new HashSet<clsReserva>();
		listaReservas.add(reservaIda);
		listaReservas.add(reservaVuelta);
		
		HashSet<clsPago> listaPagos = new HashSet<clsPago>();
		listaPagos.add(pagoIda);
		listaPagos.add(pagoVuelta);
		
		//Guardamos los objetos en la BBDD - Con esto no va bien 
		guardarObjeto(aerolinea);
		guardarObjeto(aeropuerto1);
//		guardarObjeto(aeropuerto2);
		guardarUsuario(usuario);
//		guardarObjeto(vueloIda);
//		guardarObjeto(vueloVuelta);
//		guardarObjeto(reservaIda);
//		guardarObjeto(reservaVuelta);
//		guardarObjeto(pagoIda);
//		guardarObjeto(pagoVuelta);
		
//		try
//		{
//			pm = pmf.getPersistenceManager();
//			tx = pm.currentTransaction();
//			tx.begin();
//			//Con esto va bien 
//			pm.makePersistent(aerolinea);
//			pm.makePersistent(aeropuerto1);
//			pm.makePersistent(aeropuerto2);
//			pm.makePersistent(usuario);
//			pm.makePersistent(vueloIda);
//			pm.makePersistent(vueloVuelta);
//			pm.makePersistent(reservaIda);
//			pm.makePersistent(reservaVuelta);
//			pm.makePersistent(pagoIda);
//			pm.makePersistent(pagoVuelta);
//			
//			tx.commit();
//		}
//		catch (Exception ex)
//		{
//			ex.printStackTrace();
//		}
//		
//		finally 
//		{
//			if (tx != null && tx.isActive()) 
//			{
//				tx.rollback();
//			}
//			
//			if (pm != null && !pm.isClosed()) 
//			{
//				pm.close();
//			}
//		}
		
		//Leemos los objetos y los mostramos por pantalla
		HashSet<clsAerolinea> listaAerolineas2 = leerTodasAerolineas();
		HashSet<clsAeropuerto> listaAeropuertos2 = leerTodosAeropuertos();
		HashSet<clsUsuario> listaUsuarios2 = leerTodosUsuarios();
		HashSet<clsVuelo> listaVuelos2 = leerTodosVuelos();
		HashSet<clsReserva> listaReservas2 = leerTodasReservas();
		HashSet<clsPago> listaPagos2 = leerTodosPagos();
		
		//Comparamos las listas
		if(listaAerolineas.equals(listaAerolineas2))
			System.out.println("Aerolineas: Correcto");
		else
			System.out.println("Aerolineas: INCORRECTO");
		
		if(listaAeropuertos.equals(listaAeropuertos2))
			System.out.println("Aeropuertos: Correcto");
		else
			System.out.println("Aeropuertos: INCORRECTO");
		
		if(listaUsuarios.equals(listaUsuarios2))
			System.out.println("Usuarios: Correcto");
		else
			System.out.println("Usuarios: INCORRECTO");
		
		if(listaVuelos.equals(listaVuelos2))
			System.out.println("Vuelos: Correcto");
		else
			System.out.println("Vuelos: INCORRECTO");
		
		if(listaReservas.equals(listaReservas2))
			System.out.println("Reservas: Correcto");
		else
			System.out.println("Reservas: INCORRECTO");
		
		if(listaPagos.equals(listaPagos2))
			System.out.println("Pagos: Correcto");
		else
			System.out.println("Pagos: INCORRECTO");
		
	}
	
	public static void guardarObjeto(Object objeto)
	{
//		//Cargamos el Persistence Manager Factory
//		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
//		//Cragamos el Persistence Manager
//		PersistenceManager pm = null;
//		//Transacción para agrupar varias operaciones de BBDD
//		Transaction tx = null;
		
		try{
//			pm = pmf.getPersistenceManager();
//			tx = pm.currentTransaction();
			tx.begin();
			
			pm.makePersistent(objeto);
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	
	public static void guardarUsuario(clsUsuario usuario)
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			pm.makePersistent(usuario);
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}
	
	public static HashSet<clsAerolinea> leerTodasAerolineas()
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;	
		
		HashSet<clsAerolinea> listaAerolineas = new HashSet<clsAerolinea>();
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			Extent<clsAerolinea> extent = pm.getExtent(clsAerolinea.class, true);
			
			for(clsAerolinea aerolinea: extent)
			{
				listaAerolineas.add(aerolinea);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaAerolineas;
	}
	
	public static HashSet<clsAeropuerto> leerTodosAeropuertos()
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;
		
		HashSet<clsAeropuerto> listaAeropuertos = new HashSet<clsAeropuerto>();
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			Extent<clsAeropuerto> extent = pm.getExtent(clsAeropuerto.class, true);
			
			for(clsAeropuerto aeropuerto: extent)
			{
				listaAeropuertos.add(aeropuerto);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaAeropuertos;
	}
	
	public static HashSet<clsUsuario> leerTodosUsuarios()
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;
		
		HashSet<clsUsuario> listaUsuarios = new HashSet<clsUsuario>();
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			Extent<clsUsuario> extent = pm.getExtent(clsUsuario.class, true);
			
			for(clsUsuario usuario: extent)
			{
				listaUsuarios.add(usuario);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaUsuarios;
	}
	
	public static HashSet<clsVuelo> leerTodosVuelos()
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;
		
		HashSet<clsVuelo> listaVuelos = new HashSet<clsVuelo>();
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			Extent<clsVuelo> extent = pm.getExtent(clsVuelo.class, true);
			
			for(clsVuelo vuelo: extent)
			{
				listaVuelos.add(vuelo);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaVuelos;
	}
	
	public static HashSet<clsReserva> leerTodasReservas()
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;
		
		HashSet<clsReserva> listaReservas = new HashSet<clsReserva>();
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			Extent<clsReserva> extent = pm.getExtent(clsReserva.class, true);
			
			for(clsReserva reserva: extent)
			{
				listaReservas.add(reserva);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaReservas;
	}
	
	public static HashSet<clsPago> leerTodosPagos()
	{
		//Cargamos el Persistence Manager Factory
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		//Cragamos el Persistence Manager
		PersistenceManager pm = null;
		//Transacción para agrupar varias operaciones de BBDD
		Transaction tx = null;
		
		HashSet<clsPago> listaPagos = new HashSet<clsPago>();
		
		try{
			pm = pmf.getPersistenceManager();
			tx = pm.currentTransaction();
			tx.begin();
			
			Extent<clsPago> extent = pm.getExtent(clsPago.class, true);
			
			for(clsPago pago: extent)
			{
				listaPagos.add(pago);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		}
		
		return listaPagos;
	}
}
