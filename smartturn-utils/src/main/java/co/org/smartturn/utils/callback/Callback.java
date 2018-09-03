package co.org.smartturn.utils.callback;

/**
 * Interfaz que permite ejecucion controlada de procesos.
 * 
 * @author joseanor
 *
 */
public interface Callback<I extends Object, R extends Object> {

	/**
	 * Metodo que realiza la invocacion del proceso
	 * @param 	source
	 * @return	R
	 */
	public R invoke(I source);

}
