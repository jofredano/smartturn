package co.org.smartturn.app.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import co.org.smartturn.app.config.security.AuthenticationFilter;

/**
 * Configuracion de la seguridad de la aplicacion.
 * 
 * @author joseanor
 *
 */
@Configuration
@EnableWebMvc
public class SecurityConfiguration implements WebMvcConfigurer {

	/**
	 * Recursos estaticos del proyectos
	 */
    protected static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", 
            "classpath:/resources/",
            "classpath:/static/", 
            "classpath:/public/" 
    };
	
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
            .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addRedirectViewController("/", "index.html");
    }
	
    /**
	 * Filtro de autenticacion y autorizacion.
	 **/
	@Bean
	public FilterRegistrationBean<AuthenticationFilter> securityFilter() {
        FilterRegistrationBean<AuthenticationFilter> registration = new FilterRegistrationBean<>();
        registration.setDispatcherTypes(EnumSet.allOf(DispatcherType.class));
        registration.setFilter(new AuthenticationFilter());
        registration.addInitParameter("service", "smartturn");
        registration.addInitParameter("publicResources: Recursos publicos", ".*\\/recursos\\/.*(gif|js|png|ico)");
        registration.addInitParameter("publicResources: css" , "\\/css\\/.*");
        registration.setEnabled(Boolean.TRUE);
        registration.addUrlPatterns("/smartservices/*");
        registration.setName("SAML2 Security Filter");
        registration.setOrder(1);
        registration.setAsyncSupported(Boolean.TRUE);
        return registration;
    }

}
