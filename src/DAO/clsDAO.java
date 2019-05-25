package DAO;

import java.util.ArrayList;
import java.util.HashSet;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;
import javax.jdo.Query;



import ObjetosDominio.clsAerolinea;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsPago;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsDAO implements itfDAO
{
	//Cargamos el Persistence Manager Factory
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	//Cragamos el Persistence Manager
	static PersistenceManager pm = pmf.getPersistenceManager();;	
	
	@Override
	public void guardarObjeto(Object objeto) 
	{
		Transaction tx = null;
		try{
			tx = pm.currentTransaction();
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
		}
	}

	@Override
	public ArrayList<clsAerolinea> leerTodasAerolineas() {
		ArrayList <clsAerolinea> listaAerolineas = new ArrayList <clsAerolinea>();
		Transaction tx = null;
		try{
			tx = pm.currentTransaction();
			tx.begin();
			//Para hacer la select, usamos extent
			Extent<clsAerolinea> extent = pm.getExtent(clsAerolinea.class, true);
			
			for(clsAerolinea aerolinea: extent)
			{
				listaAerolineas.add(aerolinea);
			}
			
			tx.commit();
			
		} catch (Exception ex)
		{
			ex.printStackTrace();
		} finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		
		return listaAerolineas;
	}

	@Override
	public ArrayList<clsAeropuerto> leerTodosAeropuertos() 
	{
		ArrayList<clsAeropuerto> listaAeropuertos = new ArrayList<clsAeropuerto>();
		Transaction tx = null;
		try{
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		
		return listaAeropuertos;
	}

	@Override
	public ArrayList<clsUsuario> leerTodosUsuarios() 
	{
		ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();
		Transaction tx = null;
		try{
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		
		return listaUsuarios;
	}

	@Override
	public ArrayList<clsVuelo> leerTodosVuelos()
	{
		ArrayList<clsVuelo> listaVuelos = new ArrayList<clsVuelo>();
		Transaction tx = null;
		try{
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		
		return listaVuelos;
	}

	@Override
	public ArrayList<clsReserva> leerTodasReservas() 
	{
		ArrayList<clsReserva> listaReservas = new ArrayList<clsReserva>();
		Transaction tx = null;
		try{
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
		}
		
		return listaReservas;
	}
	public ArrayList<clsPago> leerTodosPagos() 
	{
		ArrayList<clsPago> listaPagos = new ArrayList<clsPago>();
		Transaction tx = null;
		try{
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		
		return listaPagos;
	}

	@Override
	public void ActualizarVuelo(clsVuelo vuelo) 
	{
		
		 Query<clsVuelo> query = pm.newQuery("UPDATE" +clsVuelo.class.getName()+" SET NUMASIENTOS= "+ vuelo.getAsientos()+" AND ASIENTOS="+vuelo.getAsientos()+" WHERE codVuelo ="+vuelo.getCodVuelo());
		 Long number = (Long)query.execute();
		
	}

	@Override
	public void cerrarConexion() 
	{
		if (pm != null && !pm.isClosed()) 
		{
			pm.close();
		}
		
	}

	@Override
	public void ActualizarUsuario(clsUsuario usuario) {
		 Query<clsUsuario> query = pm.newQuery("UPDATE" +clsUsuario.class.getName()+" SET LISTARESERVAS= "+usuario.getListReservas()+" WHERE EMAIL ="+usuario.getEmail());
		 Long number = (Long)query.execute();
		
	}

	@Override
	public void ActualizarAerolinea(clsAerolinea aerolinea) {
		 Query<clsAerolinea> query = pm.newQuery("UPDATE" +clsAerolinea.class.getName()+" SET ACUMULADO= "+aerolinea.getAcumulado()+" WHERE CODAEROLINEA ="+aerolinea.getCodAerolinea());
		 Long number = (Long)query.execute();
		
	}

}
