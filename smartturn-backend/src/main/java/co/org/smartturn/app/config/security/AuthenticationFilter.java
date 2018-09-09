package co.org.smartturn.app.config.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Clase encargada de controlar la seguridad de los servicios.
 * 
 * @author joseanor
 *
 */
public class AuthenticationFilter implements Filter {

	/**
	 * Configuracion del filtro
	 */
	protected FilterConfig filter;
	
	@Override
	public void init(FilterConfig filter) throws ServletException {
		this.filter = filter;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.err.println("Peticion => " + request.toString());
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		this.filter = null;
	}

}

