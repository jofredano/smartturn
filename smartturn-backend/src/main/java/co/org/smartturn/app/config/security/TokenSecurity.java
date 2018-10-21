package co.org.smartturn.app.config.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Anotacion para habilitar metodo como recurso de seguridad.
 * 
 * @author joseanor
 *
 */
@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.METHOD )
public @interface TokenSecurity {

	/**
	 * Determina si verifica token para este modelo de seguridad
	 * @return	value
	 */
	boolean checkToken() default false;
	
	/**
	 * Determina si debe verificar que el usuario tiene acceso a dicho recurso
	 * @return	resource
	 */
	boolean checkResource() default false;
}
