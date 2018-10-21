package co.org.smartturn.app.config.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import co.org.smartturn.app.resources.RestResources;
import co.org.smartturn.components.UserComponent;
import co.org.smartturn.utils.Utilities;

/**
 * Clase encargada de controlar la seguridad de los servicios.
 * 
 * @author joseanor
 *
 */
@WebFilter
public class AuthenticationFilter implements Filter {

	/**
	 * Nombre del token 
	 */
	protected static final String NAME_TOKEN_APP = "X_TOKEN_SMARTTURN";
	
	/**
	 * Contexto dentro de la configuracion del filtro.
	 */
	protected javax.servlet.ServletContext context;
	
	/**
	 * Componente de usuario
	 */
	protected UserComponent component;

	
	public AuthenticationFilter(UserComponent component) {
		this.component = component;
	}
	
	@Override
	public void init(FilterConfig filter) throws ServletException {
		context = filter.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request    = (HttpServletRequest) req;
        HttpServletResponse response  = (HttpServletResponse)res;
		response.setHeader("Access-Control-Allow-Origin"   , "*");
		response.setHeader("Access-Control-Allow-Methods"  , "POST, GET, PUT, OPTIONS, DELETE");
		response.setHeader("Access-Control-Max-Age"        , "3600");
		response.setHeader("Access-Control-Allow-Headers"  , "x-requested-with");
		checkResources( request );
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		//Implementacion
	}
	
	/**
	 * Verifica la seguridad del recurso solicitado en la peticion
	 * @param 	request		Informacion de la peticion
	 * @throws IOException
	 */
	protected void checkResources(HttpServletRequest request) throws IOException {
		Stream<Method> items = Utilities.getDeclaredMethods(RestResources.class, "co.org.smartturn.app.resources")
		 .filter( element -> {
			 String resourcePath = "";
			 TokenSecurity security = null;
		     if(element.isAnnotationPresent(RequestMapping.class)) {
		        RequestMapping parentRest = element.getDeclaringClass().getAnnotation(RequestMapping.class);
		        RequestMapping resourceRest = element.getAnnotation(RequestMapping.class);
		        resourcePath = request.getContextPath() + String.join("/", parentRest.value()) + String.join("/", resourceRest.value());
		     }
		     if(element.isAnnotationPresent(TokenSecurity.class)) {
		    	security = element.getAnnotation(TokenSecurity.class);
		     }
		     //Si logramos encontrar el recurso a validar
		     //Debemos verificar los demas datos de seguridad
		     //De lo contrario debemos buscar los siguientes
		     if(request.getRequestURI().equalsIgnoreCase(resourcePath)) {
		    	return validateHeader(component, security, prepareHeader(request) );
		     } else {
		    	return false;
		     }
		 });
		//Si no encuentra informacion
		//Debe lanzar una excepcion indicando que la peticion no es autorizada
		if(items.count() <= 0) {
		   throw new IOException("La peticion no ha sido autorizada");	
		}
	}
	
	/**
	 * Prepara la informacion de encabezado de la peticion
	 * @param 	request		Informacion de la peticion
	 * @return	Map<String, String>
	 */
	protected static Map<String, String> prepareHeader(HttpServletRequest request) {
        System.err.println("Remote Host     : " + request.getRemoteHost());
        System.err.println("Remote Address  : " + request.getRemoteAddr());
        System.err.println( request.getRequestURI() + " : " + request.getMethod());
		Map<String, String> map = new HashMap<>();
		Enumeration<String> headers = request.getHeaderNames();
        if (!Utilities.isEmpty(headers)) {
            while (headers.hasMoreElements()) {
               String key = headers.nextElement();
               map.put(key.toUpperCase(), request.getHeader(key));
            }
        }
		return map;
	}

	/**
	 * Valida las credenciales suministradas en el servicio
	 * @param 	component	Componente de usuario / acceso
	 * @param 	security	Informacion de seguridad
	 * @param 	request		Informacion de la peticion
	 * @return	boolean
	 */
	protected static boolean validateHeader(UserComponent component, TokenSecurity security, Map<String, String> request) {
		//Si no tiene token debe interrumpir la validacion
		if(security != null && security.checkToken() && !request.containsKey(NAME_TOKEN_APP)) {
		   return false;
		}
		if(security != null && security.checkToken() && request.containsKey(NAME_TOKEN_APP)) {
		   return component.checkToken( request.get(NAME_TOKEN_APP) );
		}
		return true;
	}
}

