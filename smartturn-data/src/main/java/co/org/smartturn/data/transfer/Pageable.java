package co.org.smartturn.data.transfer;

import java.io.Serializable;

/**
 * Define la paginacion de una consulta.
 * 
 * @author joseanor
 *
 */
public final class Pageable implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Paginacion inicial.
	 */
	private final long begin;
	
	/**
	 * Paginaion final.
	 */
	private final long end;
	
	/**
	 * Cantidad de registros de la paginacion.
	 */
	private final long count;

	//GETTERs and SETTERs
	
	public long getBegin() {
		return begin;
	}

	public long getEnd() {
		return end;
	}

	public long getCount() {
		return count;
	}
	
	/**
	 * Constructor de la paginacion
	 * @param 	begin	Posicion inicial
	 * @param 	end		Posicion final
	 * @param 	count	Cantidad de registros
	 */
	public Pageable(long begin, long end, long count) {
		this.begin = begin;
		this.end = end;
		this.count = count;
	}

}
