package co.org.smartturn.utils.constants;

/**
 * Clase que contiene las constantes de la aplicacion.
 * 
 * @author henry
 *
 */
public final class Constants {

	/**
	 * Constructor de la clase.
	 */
	private Constants() {
	    throw new IllegalStateException("Clase de constantes");
	}
	
	/**
	 * URL donde esta definida la configuracion de base de datos
	 */
	public static final String JDNI = "java:/comp/env/jdbc/smartturndb";
	
	/**
	 * Constantes para variables de ambiente de la aplicacion.
	 */
	
	public static final String  TOMCAT_EMBEDDED_SOCKER_WRITE_BUFFER_SIZE 	= "TOMCAT_EMBEDDED_SOCKER_WRITE_BUFFER_SIZE";
 
	public static final String  TOMCAT_EMBEDDED_SOCKER_READ_BUFFER_SIZE 	= "TOMCAT_EMBEDDED_SOCKER_READ_BUFFER_SIZE";
 
	public static final String  TOMCAT_EMBEDDED_SOCKER_RXBUFFER_SIZE 		= "TOMCAT_EMBEDDED_SOCKER_RXBUFFER_SIZE";
 
	public static final String  TOMCAT_EMBEDDED_SOCKER_BUFFER_SIZE 			= "TOMCAT_EMBEDDED_SOCKER_BUFFER_SIZE";
 
	public static final String  TOMCAT_EMBEDDED_MAXIMUM_HEADER_SIZE 		= "TOMCAT_EMBEDDED_MAXIMUM_HEADER_SIZE";
 
	public static final String  TOMCAT_EMBEDDED_MAXIMUM_THREADS 			= "TOMCAT_EMBEDDED_MAXIMUM_THREADS";
 
	public static final String  TOMCAT_EMBEDDED_CONNECTION_TIMOUT 			= "TOMCAT_EMBEDDED_CONNECTION_TIMOUT";
 
	public static final String  TOMCAT_EMBEDDED_REDIRECT_PORT 				= "TOMCAT_EMBEDDED_REDIRECT_PORT";
 
	public static final String  TOMCAT_EMBEDDED_PORT 						= "TOMCAT_EMBEDDED_PORT";
	
	public static final String TOMCAT_EMBEDDED_CONTEXTPATH 					= "TOMCAT_EMBEDDED_CONTEXTPATH";
	
	/**
	 * Cifrado clave para el acceso a la base de datos
	 */
	public static final String SECRET_KEY 		= "MP8UPhoZi4CjneGAeq07EQkqUIJP2veInnGMH1U8jTk=";
}
