package co.org.smartturn.app.config.security;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.org.smartturn.utils.Utilities;

/**
 * Clase encargada de controlar la seguridad de los servicios.
 * 
 * @author joseanor
 *
 */
@WebFilter("/rest/*")
public class AuthenticationFilter implements Filter {
	
	/**
	 * Contexto dentro de la configuracion del filtro.
	 */
	protected javax.servlet.ServletContext context;


	@Override
	public void init(FilterConfig filter) throws ServletException {
		context = filter.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request    = (HttpServletRequest) req;
        HttpServletResponse response  = (HttpServletResponse)res;
        System.err.println("Logging Request : " + request.getRequestURI() + " => " + request.getMethod());
        System.err.println("Remote Host     : " + request.getRemoteHost());
        System.err.println("Remote Address  : " + request.getRemoteAddr());
        validateHeader( request );
		response.setHeader("Access-Control-Allow-Origin"   , "*");
		response.setHeader("Access-Control-Allow-Methods"  , "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age"        , "3600");
		response.setHeader("Access-Control-Allow-Headers"  , "x-requested-with");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		//Implementacion
	}

	/**
	 * Valida las credenciales suministradas en el servicio
	 * @param 	request		Informacion de la peticion
	 * @return	boolean
	 */
	protected boolean validateHeader(HttpServletRequest request) {
		Enumeration<String> headers = request.getHeaderNames();
        if (Utilities.isEmpty(headers)) {
            while (headers.hasMoreElements()) {
               System.out.println("Header: " + request.getHeader(headers.nextElement()));
            }
        }
		return true;
	}
}

