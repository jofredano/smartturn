package co.org.smartturn.app.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Clase que maneja la configuracion basica del proyecto
 * 
 * @author joseanor
 *
 */
@Configuration
@ComponentScan(
   basePackages = { 
	 "co.org.smartturn.app.services",
	 "co.org.smartturn.app.resources",
	 "co.org.smartturn.components"
})
public class BasicConfiguration {

}
