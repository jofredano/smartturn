package co.org.smartturn.utils;

import java.io.Serializable;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.exception.transfer.MapperException;

/**
 * Clase que contiene la mayoria de las utilidades de la aplicacion.
 * 
 * @author joseanor
 *
 */
public final class Utilities {
	
	/**
	 * SecretKeySpec
	 */
	private static SecretKeySpec secretKey;
	
	/**
	 * Permite un control de loggeo en las utilidades.
	 */
	protected static Logger logger;

	/**
	 * Constructor de la clase.
	 */
	private Utilities() {
	    throw new IllegalStateException("Clase de Utilidad");
	}
	
	/**
	 * Asigna instancia de log a las utilidades.
	 * @param 	log
	 */
	public static void setLogger(Logger log) {
		logger = log;
	}

	/**
	 * Colocar la clave
	 * @param myKey
	 */
	public static void setKey(String myKey) {
		MessageDigest sha = null;
		try {
			byte[] key = myKey.getBytes("UTF-8");
			sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretKey = new SecretKeySpec(key, "AES");
		} catch (Exception e) {
			Utilities.logger(logger, Level.SEVERE, "[Transformador][setKey] fallo encriptacion de clave", e);	
		}
	}

	/**
	 * Encriptar
	 * @param 	strToEncrypt	Dato a encriptar
	 * @param 	secret			Codigo de cifrado
	 * @return
	 */
	public static String encrypt(String strToEncrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
		} catch (Exception e) {	
			Utilities.logger(logger, Level.SEVERE, "[Transformador][encrypt] fallo encriptacion de clave", e);	
			return null;
		}
	}

	/**
	 * Desencriptar 
	 * @param 	strToDecrypt	Dato a desencriptar
	 * @param 	secret			Codigo de cifrado
	 * @return	String
	 */
	public static String decrypt(String strToDecrypt, String secret) {
		try {
			setKey(secret);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
			return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
		} catch (Exception e) {
			Utilities.logger(logger, Level.SEVERE, "[Transformador][decrypt] fallo desencriptacion de clave", e);
			return null;
		}
	}
	
	/**
	 * Instruccion para loggear errores de la aplicacion.
	 * @param 	log		Instancia del logger
	 * @param 	level	Nivel de loggeo
	 * @param 	message	Mensaje a reportar
	 * @param 	ex		Excepcion a reportar
	 */
	public static void logger(Logger log, Level level, String message, Exception ex) {
        if(log != null) {
           log.log(level, message, ex);            	
        }
	}

	/**
	 * Instruccion para loggear errores de la aplicacion.
	 * @param 	log		Instancia del logger
	 * @param 	level	Nivel de loggeo
	 * @param 	message	Mensaje a reportar
	 */
	public static void logger(Logger log, Level level, String message) {
        if(log != null) {
           log.log(level, message);            	
        }
	}
	
	/**
	 * Convierte a fecha Timestamp
	 * @param 	date	Fecha a convertir
	 * @return	java.sql.Timestamp
	 */
	public static java.sql.Timestamp toTimestampDate(java.util.Date date) {
		if(date == null) {
		   return null;	
		}
		return new java.sql.Timestamp(date.getTime());
	}
	
	/**
	 * Convierte a fecha SQL
	 * @param 	date	Fecha a convertir
	 * @return	java.sql.Date
	 */
	public static java.sql.Date toSqlDate(java.util.Date date) {
		if(date == null) {
		   return null;	
		}
		return new java.sql.Date(date.getTime());
	}
	
	/**
	 * Convierte a fecha SQL
	 * @param 	date	Fecha a convertir
	 * @return	java.sql.Date
	 */
	public static java.util.Date toUtilDate(java.sql.Date date) {
		if(date == null) {
		   return null;	
		}
		return new java.util.Date(date.getTime());
	}
	
	/**
	 * Convierte de Timestamp a Date
	 * @param 	date	Fecha a converir
	 * @return	java.util.Date
	 */
	public static java.util.Date toUtilDate(java.sql.Timestamp date) {
		if(date == null) {
		   return null;	
		}
		return new java.util.Date(date.getTime());
	}

	/**
	 * Metodo que convierte cadena a fecha
	 * @param 	format		Formato de la fecha
	 * @param 	data		Dato cadena a convertir
	 * @return	Date
	 */
	public static java.util.Date stringToDate(String format, String data) {
		java.util.Date result = null;
		try {
			if(data == null) {
			   return null;
			}
			result = (new SimpleDateFormat(format)).parse(data);
		} catch (ParseException e) {
			logger(logger, Level.INFO, "Error en conversion: " + e.getMessage(), e);
		}
		return result;
	}
	
	/**
	 * Metodo que convierte fecha a cadena
	 * @param 	format			Formato de la fecha
	 * @param 	data			Dato fecha a convertir
	 * @return	String
	 */
	public static String dateToString(String format, java.util.Date data) {
		if(data == null) {
		   return null;
		}
		return (new SimpleDateFormat(format)).format(data);
	}
	
	/**
	 * Permite asignar un valor por defecto cuando el valor es nulo
	 * @param 	value			Valor a evaluar
	 * @param 	defaultValue	Valor por defecto cuando sea nulo
	 * @return	String
	 */
	public static String nvl(String value, String defaultValue) {
		return (value != null && !value.isEmpty())?value:defaultValue;
	}
	
	/**
	 * Valida si la lista esta vacia
	 * @param 	items			Listado de elementos
	 * @return	boolean
	 */
	public static <I extends Object> boolean isEmpty(List<I> items) {
		return (items == null || items.isEmpty());
	}
	
	/**
	 * Valida si un objeto es vacio.
	 * @param 	item			Elemento a validar.
	 * @return	boolean
	 */
	public static <I extends Object> boolean isEmpty( I item ) {
		return (item == null);
	}
	
	/**
	 * Asigna un valor al atributo referenciado
	 * @param 	object	Objeto a ser modificado
	 * @param 	field	Campo del objeto a modificarse
	 * @param 	value	Valor a asignar
	 */
	public static <I extends Serializable> void putValue(I object, Field field, I value) {
		if(object != null && object instanceof MapEntity) {
		   MapEntity entity = (MapEntity)object;
		   entity.put(field, value);
		}
	}
	
	/**
	 * Obtiene la propiedad dentro de un objeto mapa
	 * @param 	object	Objeto al que se le pregunta el dato
	 * @param 	field	Campo a obtener
	 * @return	I
	 */
	@SuppressWarnings("unchecked")
	public static <I extends Serializable> I getValue(I object, Field field) {
		I result  = object;
		if(object != null && object instanceof MapEntity) {
		   MapEntity entity = (MapEntity)object;
		   result = (I)entity.get(field);
		}
		return result;
	}
	
	/**
	 * Obtiene la informacion de un atributo de un objeto y lo mappeara
	 * @param 	object	Objeto de lectura
	 * @param 	field	Atributo a leer
	 * @return	I
	 * @throws  MapperException 
	 */
	@SuppressWarnings("unchecked")
	public static <I extends Serializable> I getMapper(I object, Field field, Class<Object> type) throws MapperException {
		I  value  = getValue(object, field);
		if(value != null && value instanceof MapEntity) {
		   value  = (I) ((MapEntity)value).map(type, null);	
		}
		return value;
	}
	
	/**
	 * Convierte un objeto a cadena
	 * @param 	object	Objeto al que se le pregunta el dato
	 * @param 	field	Campo a obtener
	 * @return	String
	 */
	public static <I extends Serializable> String convertString(I object, Field field) {
		I result = getValue(object, field);
		return (result != null)?result.toString():null;
	}
	
	/**
	 * Convierte a texto un mapa
	 * @param 	map				Mapa a convertir
	 * @param 	separatorKey	Separador de claves
	 * @param 	separatorLine	Separador de lineas
	 * @return	String
	 */
	public static String text(Map<String, Object> map, String separatorKey, String separatorLine) {
		StringBuilder builder = new StringBuilder();
		for (Map.Entry<String, Object> entry : map.entrySet()) {
			builder.append( entry.getKey() )
			       .append( separatorKey )
			       .append( entry.getValue() );
			builder.append( separatorLine );
		}
		return builder.toString();
	}
	
	/**
	 * Determina el tipo de dato del objeto
	 * @param 	object		Objeto a evaluar
	 * @return	Class<T>
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Object> Class<T> getType(T object, Class<T> def) {
		return Utilities.isEmpty( object )?def:(Class<T>) object.getClass();
	}

	/**
	 * Convierte elementos de un tipo a otro
	 * @param 	source	Lista de objetos origen
	 * @param 	name	Tipo de objeto destino
	 * @return	List<T>
	 * @throws  MapperException 
	 */
	public static <S extends MapEntity, T extends MapEntity> List<T> toArray(Iterable<S> source, Class<?> name) throws  MapperException {
		List<T> items = new ArrayList<>();
		if(!Utilities.isEmpty(source)) {
		   for(S item : source) {
			   items.add( toMap(name, item) );
		   }
		}
		return items;
	}
	
	/**
	 * Convierte objeto mapa a otro mapa
	 * @param 	item	Entidad origen
	 * @param 	name	Tipo de clase destino
	 * @return	T
	 * @throws 	MapperException
	 */
	@SuppressWarnings("unchecked")
	public static <S extends MapEntity, T extends MapEntity> T toMap(Class<?> name, S item) throws MapperException {
		if(isEmpty( item ) ) {
		   return null;
		}
		return (T) item.map(name, item);
	}

}

