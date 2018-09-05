package co.org.smartturn.data.structure;

import java.io.Serializable;

import co.org.smartturn.data.structure.mapper.Mapper;

/**
 * Esta interfaz permite la obtencion de datos de los objetos.
 * De una manera mas general (para generalizar el concepto). 
 * 
 * @author joseanor
 *
 */
public interface MapEntity extends Struct, Mapper<MapEntity, MapEntity> {

	/**
	 * Obtiene el valor de esta entidad.
	 * @param 	field		Campo a obtener
	 * @return	Serializable
	 */
	public Serializable get(Field field);
	
	/**
	 * Devolver el tipo del campo
	 * @param 	field		Campo a obtener el tipo
	 * @return	Class<?>
	 */
	public default <T extends Object> Class<T> type(Field field) {
		return null;
	}
	
	/**
	 * Asigna un valor a esta entidad.
	 * @param 	field		Campo a asignar.
	 * @param 	value		Valor a asignar (debe corresponder al tipo del atributo)
	 */
	public void put(Field field, Serializable value);

}
