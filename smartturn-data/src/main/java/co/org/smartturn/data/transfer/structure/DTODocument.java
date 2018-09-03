package co.org.smartturn.data.transfer.structure;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.exception.transfer.MapperException;
import co.org.smartturn.utils.Utilities;

/**
 * Esta clase define un documento de identificacion
 * dentro del sistema.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public final class DTODocument extends ObjectMap implements MapEntity {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Define el tipo de documento
	 */
	private String type;
	
	/**
	 * Define el numero del documento
	 */
	private String digits;
	
	/**
	 * Constructor de la clase
	 * @param 	type		Tipo de documento
	 * @param 	digits		Numero de documento
	 */
	public DTODocument(String type, String digits) {
		this.type 		= type;
		this.digits 	= digits;
	}
	
	/**
	 * Constructor de la clase.
	 */
	public DTODocument() {
		this("","");
	}
	
	/**
	 * Devuelve el tipo de documento
	 * @return	String
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * Devuelve el numero de documento
	 * @return	String
	 */
	public String getDigits() {
		return digits;
	}
	
	@Override
	public String toString() {
		return (!Utilities.isEmpty(type))?type + "-" + digits:null;
	}
	
	@Override
	public int hashCode() {
		return type.hashCode() + digits.hashCode();
	}
	
	@Override
	public boolean equals(Object object) {
		if(object == null || object.getClass() != this.getClass()) {
		   return false;
		}
		return (this.hashCode() == ((DTODocument)object).hashCode());
	}

	@Override
	public String get(Field field) {
		ColumnFilter name = (ColumnFilter)field;
		if(name == ColumnFilter.IDENTIFICATION_TYPE) {
		   return getType();	
		} else {
		   return getDigits();
		}
	}

	@Override
	public void put(Field field, Serializable value) {
		ColumnFilter name = (ColumnFilter)field;
		if(name == ColumnFilter.IDENTIFICATION_TYPE) {
		   this.type 	= (String)value;	
		} else {
		   this.digits 	= (String)value;
		}
	}
	
	@Override
	public Field[] getFields() {
		return new ColumnFilter[] {
			ColumnFilter.IDENTIFICATION_TYPE,
			ColumnFilter.IDENTIFICATION_DIGITS
		};
	}
	
	
	/**
	 * Convierte string a documento
	 * @param 	documento
	 * @return	Documento
	 */
	public static DTODocument valueOf(String value) {
		String[] parts 	= value.split("-");
		String type 	= null;
		String digits 	= null;
		if(parts != null && parts.length == 2) {
		   type 		= parts[0];	
		   digits 		= parts[1];
		} else {
		   type 		= "CC";
		   digits 		= value;
		}
		return new DTODocument(type, digits);
	}


	/**
	 * Enumerador de los campos.
	 * 
	 * @author joseanor
	 *
	 */
	public enum ColumnFilter implements Field {
		IDENTIFICATION_TYPE   ("type"),
		IDENTIFICATION_DIGITS ("digits");
		
		/**
		 * Nombre del campo
		 */
		private final String name;
		
		private ColumnFilter(String name) {
			this.name = name;
		}
		
		@Override
		public String getName() {
			return name;
		}

		@Override
		public boolean isKey() {
			return false;
		}

		@Override
		public String getDescription() {
			return null;
		}
	}

	@Override
	public MapEntity map(Class<?> name, MapEntity source) throws MapperException {
		return null;
	}
	
} 

