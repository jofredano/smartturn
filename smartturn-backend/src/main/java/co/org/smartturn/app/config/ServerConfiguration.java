package co.org.smartturn.app.config;

import javax.annotation.PostConstruct;

import org.apache.coyote.http11.AbstractHttp11JsseProtocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import co.org.smartturn.app.config.profile.DatabaseConfiguration;
import co.org.smartturn.app.config.profile.EmbbedConfiguration;
import co.org.smartturn.utils.constants.Constants;

/**
 * Configuracion del servidor.
 * 
 * @author joseanor
 *
 */
@Configuration
public class ServerConfiguration {
	
	/**
	 * Instancia de la configuracion del servidor
	 */
	@Autowired
	private EmbbedConfiguration embbed;
	
	/**
	 * Instancia de la configuracion de la base de datos
	 */
	@Autowired
	private DatabaseConfiguration database;
	
	/**
	 * Metodo que inicializa configuracion del servidor
	 */
	@PostConstruct
    public void initEmbbedConfiguration() {
        System.setProperty(Constants.TOMCAT_EMBEDDED_PORT, 
        		Integer.toString( embbed.getServerPort()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_REDIRECT_PORT, 
        		Integer.toString( embbed.getServerRedirectPort()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_CONNECTION_TIMOUT,
                Integer.toString( embbed.getServerConnectionTimeout()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_MAXIMUM_THREADS, 
        		Integer.toString( embbed.getServerMaximumThreads()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_MAXIMUM_HEADER_SIZE,
                Integer.toString( embbed.getServerMaximumHeaderSizes()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_SOCKER_BUFFER_SIZE,
                Integer.toString( embbed.getServerSocketBufferSize()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_SOCKER_RXBUFFER_SIZE,
                Integer.toString( embbed.getServerSocketRxBufSize()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_SOCKER_READ_BUFFER_SIZE,
                Integer.toString( embbed.getServerSocketAppReadBufSize()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_SOCKER_WRITE_BUFFER_SIZE,
                Integer.toString( embbed.getServerSocketAppWriteBufSize()));
        System.setProperty(Constants.TOMCAT_EMBEDDED_CONTEXTPATH, 
        		embbed.getServerContextPath() );
    }
	
	/**
	 * Inicializa configuracion de base de datos
	 */
	@PostConstruct
	public void initDatabaseConfiguration() {
        /* Database connection properties */
        System.setProperty("HIBERNATE_DRIVER",  database.getHibernateDriver());
        System.setProperty("HIBERNATE_URL",  database.getDatasourceUrl());
        System.setProperty("HIBERNATE_USERNAME",  database.getDatasourceUsername());
        System.setProperty("HIBERNATE_PASSWORD",  database.getDatasourcePassword());
        System.setProperty("HIBERNATE_DATASOURCE_CLASSNAME",  database.getDatasourceClassname());
        /* Dialect and format SQL */
        System.setProperty("HIBERNATE_DIALECT",  database.getHibernateDialect());
        System.setProperty("HIBERNATE_SHOWSQL",  database.getHibernateShowSQL());
        System.setProperty("HIBERNATE_FORMATSQL",  database.getHibernateFormatSQL());
        /* Cache */
        System.setProperty("HIBERNATE_CACHE_SECOND_LEVEL",  database.getHibernateSecondLevelCache());
        System.setProperty("HIBERNATE_CACHE_QUERY",  database.getHibernateQueryCache());
        System.setProperty("HIBERNATE_CACHE_REGION_FACTORY_CLASS",  database.getHibernateFactoryClass());
        System.setProperty("HIBERNATE_CACHE_PROVIDER",  database.getHibernateProviderClass());
        System.setProperty("HIBERNATE_GENERATE_STATISTICS",  database.getHibernateGenerateStatistics());
        System.setProperty("HIBERNATE_CACHE_JAVAX_PROVIDER",  database.getHibernateJavaxCacheProvider());
        /* HikariCP */
        System.setProperty("CONNECTION_PROVIDER_CLASS",  database.getHibernateProviderClass());
        System.setProperty("HIKARI_AUTOCOMMIT", String.valueOf( database.getHikariAutocommit()));
        System.setProperty("HIKARI_CONNECTION_TIMEOUT", String.valueOf( database.getHikariConnectionTimeout()));
        System.setProperty("HIKARI_MINIMUM_IDLE", String.valueOf( database.getHikariMinimumIdle()));
        System.setProperty("HIKARI_IDLE_TIMEOUT", String.valueOf( database.getHikariIdleTimeout()));
        System.setProperty("HIKARI_CONNECTION_QUERY",  database.getHikariConnectionTestQuery());
        System.setProperty("HIKARI_MAX_LIFE_TIME", String.valueOf( database.getHikariMaxLifetime()));
        /* Pool de conexiones */
        System.setProperty("HIKARI_POOL_NAME",  database.getHikariPoolName());
        System.setProperty("HIKARI_MAXIMUM_POOL_SIZE", String.valueOf( database.getHikariMaximumPoolSize()));
        System.setProperty("HIKARI_USER_SERVER_PREP_STMTS",
                String.valueOf( database.getHikariUseServerPrepStmts()));
        System.setProperty("HIKARI_PREP_STMT_CACHE_SIZE", String.valueOf( database.getHikariPrepStmtCacheSize()));
        System.setProperty("HIKARI_PREP_STMT_CACHE_SQL_LIMIT",
                String.valueOf( database.getHikariPrepStmtCacheSqlLimit()));
        /* Configure trace level both HikariCP asnd Hibernate */
        System.setProperty("HIBERNATE_LEVEL_SQL",  database.getHibernateLevelSQL());
        System.setProperty("HIKARI_LEVEL_CONFIGURATION",  database.getHikariLevelHikariConfig());
        System.setProperty("HIBERNATE_LEVEL_TYPE_SQL_BINDER",  database.getHibernateLevelTypeSQLBasicBinder());
        System.err.println("Base de datos => " + database);
	}
	
    /**
     * Devuelve la configuracion de objeto embebido de tomcat
     * 
     * @return	EmbeddedServletContainerFactory
     */
	@Bean
	public org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory  getEmbeddedServletContainer() {
		org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory factory = new org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory();
		factory.setContextPath( System.getProperty( Constants.TOMCAT_EMBEDDED_CONTEXTPATH ) );
		factory.addConnectorCustomizers( 
			(TomcatConnectorCustomizer) connector -> {
	            AbstractHttp11JsseProtocol<?> handler = (AbstractHttp11JsseProtocol<?>) connector
	                    .getProtocolHandler();
	            handler.setConnectionTimeout(
	                    Integer.valueOf(System.getProperty(Constants.TOMCAT_EMBEDDED_CONNECTION_TIMOUT)));
	            handler.setMaxThreads(
	            		Integer.valueOf(System.getProperty(Constants.TOMCAT_EMBEDDED_MAXIMUM_THREADS)));
	            handler.setMaxHttpHeaderSize(
	                    Integer.valueOf(System.getProperty(Constants.TOMCAT_EMBEDDED_MAXIMUM_HEADER_SIZE)));
	            handler.setProperty("socket.appReadBufSize",
	                    System.getProperty(Constants.TOMCAT_EMBEDDED_SOCKER_READ_BUFFER_SIZE));
	            handler.setProperty("socket.rxBufSize", 
	            		System.getProperty(Constants.TOMCAT_EMBEDDED_SOCKER_RXBUFFER_SIZE));
	            handler.setProperty("socket.appWriteBufSize",
	                    System.getProperty(Constants.TOMCAT_EMBEDDED_SOCKER_WRITE_BUFFER_SIZE));
	            handler.setProperty("bufferSize", 
	            		System.getProperty(Constants.TOMCAT_EMBEDDED_SOCKER_BUFFER_SIZE));
	            connector.setRedirectPort(
	            		Integer.valueOf(System.getProperty(Constants.TOMCAT_EMBEDDED_REDIRECT_PORT)));
	            //Se le incluyo por temas de funcionamiento...
	            connector.setPort(
	            		Integer.valueOf(System.getProperty(Constants.TOMCAT_EMBEDDED_PORT)));
		   }
        );
		return factory;
	}
}
