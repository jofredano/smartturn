package co.org.smartturn.utils.filter;

import co.org.smartturn.utils.callback.Callback;

/**
 * Evaluar datos para filtrar informacion
 * 
 * @author joseanor
 *
 * @param <I>
 */
public interface Filter<I extends Object> extends Callback<I, Boolean> {

	public default Boolean eval(I source) { return invoke(source); }
}
