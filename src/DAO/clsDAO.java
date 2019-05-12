package DAO;

import java.util.ArrayList;
import java.util.HashSet;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import com.mysql.cj.Query;

import ObjetosDominio.clsAerolinea;
import ObjetosDominio.clsAeropuerto;
import ObjetosDominio.clsReserva;
import ObjetosDominio.clsUsuario;
import ObjetosDominio.clsVuelo;

public class clsDAO implements itfDAO
{
	//Cargamos el Persistence Manager Factory
	static PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	//Cragamos el Persistence Manager
	static PersistenceManager pm;
	//Transacción para agrupar varias operaciones de BBDD
	static Transaction tx;	
	
	@Override
	public void guardarObjeto(Object objeto) 
	{
		try{
			pm = pmf.getPersistenceManager();
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
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
	}

	@Override
	public ArrayList<clsAerolinea> leerTodasAerolineas() {
		ArrayList <clsAerolinea> listaAerolineas = new ArrayList <clsAerolinea>();
		try{
			pm = pmf.getPersistenceManager();
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
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return listaAerolineas;
	}

	@Override
	public ArrayList<clsAeropuerto> leerTodosAeropuertos() 
	{
		ArrayList<clsAeropuerto> listaAeropuertos = new ArrayList<clsAeropuerto>();
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return listaAeropuertos;
	}

	@Override
	public ArrayList<clsUsuario> leerTodosUsuarios() 
	{
		ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();
	
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return listaUsuarios;
	}

	@Override
	public ArrayList<clsVuelo> leerTodosVuelos()
	{
		ArrayList<clsVuelo> listaVuelos = new ArrayList<clsVuelo>();
		
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return listaVuelos;
	}

	@Override
	public ArrayList<clsReserva> leerTodasReservas() 
	{
		ArrayList<clsReserva> listaReservas = new ArrayList<clsReserva>();
		
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
		}finally 
		{
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
			
			if (pm != null && !pm.isClosed()) {
				pm.close();
			}
		}
		
		return listaReservas;
	}

	@Override
	public void ActualizarVuelo(clsVuelo vuelo) 
	{
		//Da error Query<clsVuelo> query = pm.newQuery("UPDATE" +clsVuelo.class.getName()+" SET NUMASIENTOS= "+ vuelo.getNumAsientos()" AND ASIENTOS="+vuelo.getAsientos()+" WHERE codVuelo ="+vuelo.getCodVuelo());
		//Long number = (Long)query.execute();
		
	}

}
