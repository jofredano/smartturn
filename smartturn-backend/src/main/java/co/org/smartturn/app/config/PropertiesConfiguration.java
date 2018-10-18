package co.org.smartturn.app.config;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;

/**
 * Clase de configuracion para las propiedades
 */
@Configuration
@PropertySource("classpath:constants.properties")
public class PropertiesConfiguration {

	/**
	 * Obtener mensajes
	 * @return
	 */
	@Bean(name = "query")
	public static PropertiesFactoryBean database() {
		PropertiesFactoryBean bean = new PropertiesFactoryBean();
		bean.setLocation(new ClassPathResource("query.properties"));
		return bean;
	}
	
}
