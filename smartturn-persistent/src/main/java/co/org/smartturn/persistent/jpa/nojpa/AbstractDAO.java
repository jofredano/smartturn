package co.org.smartturn.persistent.jpa.nojpa;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

/**
 * Clase abstracta para manejo de jdbc template
 * 
 * @author joseanor
 *
 */
public abstract class AbstractDAO {

	/**
	 * Instancia de jdbc template
	 */
	protected JdbcTemplate template;
	
	/**
	 * Constructor de la clase abstracta
	 * @param 	template	Template JDBC
	 */
	public AbstractDAO(JdbcTemplate template) {
		this.template = template;
	}

	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	/**
	 * Metodo que define una instancia SimpleJdbcCall
	 * @return	SimpleJdbcCall
	 */
	public SimpleJdbcCall getJdbcCall() {
		return new SimpleJdbcCall(template);
	}
	
}
