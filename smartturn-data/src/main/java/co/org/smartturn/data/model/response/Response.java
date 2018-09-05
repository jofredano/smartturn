package co.org.smartturn.data.model.response;

import java.io.Serializable;

/**
 *  Clase que controla respuestas de procesos.
 * 
 * @author joseanor
 *
 */
public interface Response<T extends Object> extends Serializable {

	/**
	 * Obtiene el contenido de la respuesta
	 * @return	content
	 */
	public T getContent();
	
	/**
	 * Asigna el contenido de la respuesta
	 * @param 	content
	 */
	public void setContent(T content);

	/**
	 * Obtiene la cantidad de elementos
	 * @return	size
	 */
	public long getSize();
	
	/**
	 * Asigna la cantidad de elementos de la respuesta
	 * @param 	size
	 */
	public void setSize(long size);

}
