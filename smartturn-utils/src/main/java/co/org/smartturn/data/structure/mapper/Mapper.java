package co.org.smartturn.data.structure.mapper;

import co.org.smartturn.exception.transfer.MapperException;

/**
 * Interfaz que permite definir como se puede mappear los datos
 * de un objeto a otro
 * 
 * @author joseanor
 *
 */
public interface Mapper<S extends Object, T extends Object> {

	/**
	 * Convierte de un tipo de objeto a otro
	 * @param 	name	Clase a la que será convertido el objeto
	 * @param 	source	Informacion del objeto origen
	 * @return	T
	 * @throws 	MapperException
	 */
	public T map(Class<?> name, S source) throws MapperException;

}
