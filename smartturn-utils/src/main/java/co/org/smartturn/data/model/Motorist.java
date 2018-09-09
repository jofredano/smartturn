package co.org.smartturn.data.model;

import java.io.Serializable;

/**
 * Estructura general de un conductor.
 * Se define asi, porque depende del contexto en el que se hable
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface Motorist extends Contact<Serializable> {

	/**
	 * Devuelve el cliente
	 * @return	client
	 */
	public Serializable getClient();
	
	/**
	 * Asigna la informacion del cliente.
	 * @param 	client		Informacion del cliente.
	 */
	public void setClient(Serializable client);

	/**
	 * Devuelve la transportadora
	 * @return	transport
	 */
	public Serializable getTransport();
	
	/**
	 * Asignar la transportadora
	 * @param 	transport	Informacion de la transportadora
	 */
	public void setTransport(Serializable transport);

	/**
	 * Obtiene la informacion del conductor
	 * @return	contact
	 */
	public Serializable getContact();

	/**
	 * Asigna informacion del conductor
	 * @param 	contact		Informacion del conductor
	 */
	public void setContact(Serializable contact);

}
