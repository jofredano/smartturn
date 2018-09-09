package co.org.smartturn.data.model.filter;

import co.org.smartturn.exception.ConvertException;

/**
 * Interfaz que se encarga de realizar transformacion
 * del dato a un String para aplicar al objeto RangeData
 * 
 * @author joseanor
 *
 */
public interface TransformData<D extends java.io.Serializable> {

	/**
	 * Convierte el dato a String
	 * @param 	data		Dato a ser convertido
	 * @return	String
	 * @throws 	ConvertException
	 */
	public String convert(D data) throws ConvertException;
	
}
