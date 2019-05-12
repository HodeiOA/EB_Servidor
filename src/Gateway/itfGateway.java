package Gateway;

import java.util.ArrayList;

import ObjetosDominio.clsVuelo;

public interface itfGateway 
{
	public ArrayList <clsVuelo> cargarIda(String ciudadOrigen, String  ciudadDestino, java.util.Date fecha);
	public ArrayList <clsVuelo> cargarIdaVuelta(String ciudadOrigen, String ciudadDestino, java.util.Date fechaIda,java.util.Date fechaVuelta);
	public ArrayList <clsVuelo> cargarCualquierMomento(String ciudadOrigen, String ciudadDestino);
	public boolean ValidarUsuario (String email, boolean modo);
	public boolean RealizarPago (String numTarjetaCredito, boolean modo);

}
