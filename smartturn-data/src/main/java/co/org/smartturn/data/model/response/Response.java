package co.org.smartturn.data.model.response;

import java.io.Serializable;
import java.util.List;

/**
 *  Clase que controla respuestas de procesos.
 * 
 * @author joseanor
 *
 */
public interface Response<T extends Serializable> extends Serializable {

	/**
	 * Obtiene el contenido de la respuesta
	 * @return	content
	 */
	public List<T> getContent() ;
	
	/**
	 * Obtiene la cantidad de elementos
	 * @return	size
	 */
	public long getSize() ;
	
	/**
	 * Asigna el contenido de la respuesta
	 * @param 	content
	 */
	public void setContent(List<T> content) ;
	
	/**
	 * Asigna la cantidad de elementos de la respuesta
	 * @param 	size
	 */
	public void setSize(long size) ;

}
