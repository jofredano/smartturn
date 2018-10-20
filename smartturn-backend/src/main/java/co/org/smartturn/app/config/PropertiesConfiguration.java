package co.org.smartturn.app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Clase de configuracion para las propiedades
 */
@Configuration
@PropertySource("classpath:constants.properties")
public class PropertiesConfiguration {

}
