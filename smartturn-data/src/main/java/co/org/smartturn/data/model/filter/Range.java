package co.org.smartturn.data.model.filter;

import java.io.Serializable;

import co.org.smartturn.exception.ConvertException;

/**
 * Objeto usado para definir rangos de datos.
 * 
 * @author joseanor
 *
 */
public interface Range<I extends Serializable> extends Serializable {

	/**
	 * Obtiene el dato inicial.
	 * @return	begin
	 */
	public I getBegin();

	/**
	 * Obtiene el dato final.
	 * @return	end
	 */
	public I getEnd();
	
	/**
	 * Obtiene el nombre del campo
	 * @return	field
	 */
	public String getField();

	/**
	 * Asigna el nombre del campo al rango
	 * @param 	field
	 */
	public void setField(String field);

	/**
	 * Convierte el rango en string
	 * @param 	expr		Expresion en la que sera convertido el rango
	 * @return	String
	 * @throws  ConvertException 
	 */
	public String format(String expr, TransformData<I> transform) throws ConvertException;

	/**
	 * Convierte el rango en string
	 * @param 	expr		Expresion en la que sera convertido el rango
	 * @return	String
	 * @throws 	ConvertException
	 */
	public String format(String expr) throws ConvertException;

}
