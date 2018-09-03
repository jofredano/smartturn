package co.org.smartturn.data.model;

import java.io.Serializable;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.structure.Record;
import co.org.smartturn.data.transfer.fields.ColumnFields;

/**
 * Estructura general de un perfil.
 * Se define asi, porque depende del contexto en el que se hable
 * Objeto de persistencia o objeto de negocio, se puede definir de la misma manera
 * pero cambia de acuerdo a como vaya orientado.
 * 
 * @author joseanor
 *
 */
public interface Profile<R extends Serializable> extends Record, MapEntity {

	/**
	 * Devuelve el codigo del perfil
	 * @return	long
	 */
	public long getCode();
	
	/**
	 * Asigna el codigo del perfil
	 * @param 	code	Codigo
	 */
	public void setCode(long code);
	
	/**
	 * Devuelve el rol asociado al perfil
	 * @return	role
	 */
	public R getRole();

	/**
	 * Asigna el rol al perfil
	 * @param 	role	Rol asociado al perfil
	 */
	public void setRole(R role);

	public default Field[] getFields() { 
		return new ColumnFields[] {
			ColumnFields.PROFILE_CODE,
			ColumnFields.PROFILE_CREATED,
			ColumnFields.PROFILE_MODIFIED,
			ColumnFields.PROFILE_CREATER,
			ColumnFields.PROFILE_MODIFIER,
			ColumnFields.PROFILE_ROLE,
			ColumnFields.PROFILE_STATE
		}; 
	}
}
