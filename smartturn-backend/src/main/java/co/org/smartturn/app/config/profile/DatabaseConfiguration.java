package co.org.smartturn.app.config.profile;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Clase de configuracion para la base de datos.
 * 
 * @author joseanor
 *
 */
@Configuration
@ConfigurationProperties(prefix = "spring")
@EntityScan(basePackages = {"co.org.smartturn.persistent"})
public class DatabaseConfiguration {
	
	/**
	 * Tipo de datasource (conexion a base de datos).
	 */
	@Value("${spring.datasource.type}")
	private String datasourceType;
	
	/**
	 * Url usada por datasource (conexion a base de datos)
	 */
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	
	/**
	 * Nombre de usuario usado por el datasource (conexion a base de datos)
	 */
	@Value("${spring.datasource.username}")
	private String datasourceUsername;
	
	/**
	 * Clave del usuario usado por el datasource  (conexion a base de datos)
	 */
	@Value("${spring.datasource.password}")
	private String datasourcePassword;
	
	/**
	 * Controlador que se debe usar (conexion a base de datos)
	 */
    @Value("${spring.datasource.driver}")
    private String hibernateDriver;
	
	/**
	 * Nombre de la clase a usar por el datasource  (conexion a base de datos)
	 */
    @Value("${spring.datasource.dataSourceClassName}")
    private String datasourceClassname;
	
    /**
     * Indica si debe realizar auto-commit.
     */
    @Value("${spring.datasource.hikari.data-source-properties.autocommit}")
    private Boolean hikariAutocommit;

    /**
     * Define el nombre del pool para temas de conectividad  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.poolName}")
    private String hikariPoolName;

    /**
     * Tiempo limite de espera  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.connectionTimeout}")
    private Long hikariConnectionTimeout;

    /**
     * Maximo tiempo de vida  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.maxLifetime}")
    private Long hikariMaxLifetime;

    /**
     * Maxima tamano del pool  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.maximumPoolSize}")
    private Integer hikariMaximumPoolSize;

    /**
     * Minima cantidad de hilos de conexion (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.minimumIdle}")
    private Integer hikariMinimumIdle;

    /**
     * Tiempo limite por hilo de conexion  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.idleTimeout}")
    private Long hikariIdleTimeout;

    /**
     * Indica si maneja prueba de conexion con consulta  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.connectionTestQuery}")
    private String hikariConnectionTestQuery;

    /**
     * Indica el cache para sentencias prepareStatement  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.cachePrepStmts}")
    private Boolean hikariCachePrepStmts;

    /**
     * Indica la capacidad del cache para las sentencias prepareStatement  (conexion a base de datos)
     */
    @Value("${spring.datasource.hikari.data-source-properties.prepStmtCacheSize}")
    private Integer hikariPrepStmtCacheSize;

    @Value("${spring.datasource.hikari.data-source-properties.prepStmtCacheSqlLimit}")
    private Integer hikariPrepStmtCacheSqlLimit;

    @Value("${spring.datasource.hikari.data-source-properties.useServerPrepStmts}")
    private Boolean hikariUseServerPrepStmts;

    @Value("${spring.datasource.hikari.data-source-properties.levelHikariConfig}")
    private String hikariLevelHikariConfig;
	

    @Value("${spring.jpa.dialect}")
    private String hibernateDialect;

    @Value("${spring.jpa.show-sql}")
    private String hibernateShowSQL;

    @Value("${spring.jpa.format-sql}")
    private String hibernateFormatSQL;

    
    @Value("${spring.jpa.properties.hibernate.cache.use_second_level_cache}")
    private String hibernateSecondLevelCache;

    @Value("${spring.jpa.properties.hibernate.cache.use_query_cache}")
    private String hibernateQueryCache;

    @Value("${spring.jpa.properties.hibernate.generate_statistics}")
    private String hibernateGenerateStatistics;

    @Value("${spring.jpa.properties.hibernate.cache.region.factory_class}")
    private String hibernateFactoryClass;

    @Value("${spring.jpa.properties.hibernate.connection.provider_class}")
    private String hibernateProviderClass;

    @Value("${spring.jpa.properties.hibernate.javax.cache.provider}")
    private String hibernateJavaxCacheProvider;

    @Value("${spring.jpa.properties.hibernate.level.SQL}")
    private String hibernateLevelSQL;

    @Value("${spring.jpa.properties.hibernate.level.type.sql.BasicBinder}")
    private String hibernateLevelTypeSQLBasicBinder;

    
	public String getDatasourceType() {
		return datasourceType;
	}

	public void setDatasourceType(String datasourceType) {
		this.datasourceType = datasourceType;
	}

	public String getDatasourceUrl() {
		return datasourceUrl;
	}

	public void setDatasourceUrl(String datasourceUrl) {
		this.datasourceUrl = datasourceUrl;
	}

	public String getDatasourceUsername() {
		return datasourceUsername;
	}

	public void setDatasourceUsername(String datasourceUsername) {
		this.datasourceUsername = datasourceUsername;
	}

	public String getDatasourcePassword() {
		return datasourcePassword;
	}

	public void setDatasourcePassword(String datasourcePassword) {
		this.datasourcePassword = datasourcePassword;
	}

	public Boolean getHikariAutocommit() {
		return hikariAutocommit;
	}

	public void setHikariAutocommit(Boolean hikariAutocommit) {
		this.hikariAutocommit = hikariAutocommit;
	}

	public String getHikariPoolName() {
		return hikariPoolName;
	}

	public void setHikariPoolName(String hikariPoolName) {
		this.hikariPoolName = hikariPoolName;
	}

	public Long getHikariConnectionTimeout() {
		return hikariConnectionTimeout;
	}

	public void setHikariConnectionTimeout(Long hikariConnectionTimeout) {
		this.hikariConnectionTimeout = hikariConnectionTimeout;
	}

	public Long getHikariMaxLifetime() {
		return hikariMaxLifetime;
	}

	public void setHikariMaxLifetime(Long hikariMaxLifetime) {
		this.hikariMaxLifetime = hikariMaxLifetime;
	}

	public Integer getHikariMaximumPoolSize() {
		return hikariMaximumPoolSize;
	}

	public void setHikariMaximumPoolSize(Integer hikariMaximumPoolSize) {
		this.hikariMaximumPoolSize = hikariMaximumPoolSize;
	}

	public Integer getHikariMinimumIdle() {
		return hikariMinimumIdle;
	}

	public void setHikariMinimumIdle(Integer hikariMinimumIdle) {
		this.hikariMinimumIdle = hikariMinimumIdle;
	}

	public Long getHikariIdleTimeout() {
		return hikariIdleTimeout;
	}

	public void setHikariIdleTimeout(Long hikariIdleTimeout) {
		this.hikariIdleTimeout = hikariIdleTimeout;
	}

	public String getHikariConnectionTestQuery() {
		return hikariConnectionTestQuery;
	}

	public void setHikariConnectionTestQuery(String hikariConnectionTestQuery) {
		this.hikariConnectionTestQuery = hikariConnectionTestQuery;
	}

	public Boolean getHikariCachePrepStmts() {
		return hikariCachePrepStmts;
	}

	public void setHikariCachePrepStmts(Boolean hikariCachePrepStmts) {
		this.hikariCachePrepStmts = hikariCachePrepStmts;
	}

	public Integer getHikariPrepStmtCacheSize() {
		return hikariPrepStmtCacheSize;
	}

	public void setHikariPrepStmtCacheSize(Integer hikariPrepStmtCacheSize) {
		this.hikariPrepStmtCacheSize = hikariPrepStmtCacheSize;
	}

	public Integer getHikariPrepStmtCacheSqlLimit() {
		return hikariPrepStmtCacheSqlLimit;
	}

	public void setHikariPrepStmtCacheSqlLimit(Integer hikariPrepStmtCacheSqlLimit) {
		this.hikariPrepStmtCacheSqlLimit = hikariPrepStmtCacheSqlLimit;
	}

	public Boolean getHikariUseServerPrepStmts() {
		return hikariUseServerPrepStmts;
	}

	public void setHikariUseServerPrepStmts(Boolean hikariUseServerPrepStmts) {
		this.hikariUseServerPrepStmts = hikariUseServerPrepStmts;
	}

	public String getHikariLevelHikariConfig() {
		return hikariLevelHikariConfig;
	}

	public void setHikariLevelHikariConfig(String hikariLevelHikariConfig) {
		this.hikariLevelHikariConfig = hikariLevelHikariConfig;
	}

	public String getHibernateDialect() {
		return hibernateDialect;
	}

	public void setHibernateDialect(String hibernateDialect) {
		this.hibernateDialect = hibernateDialect;
	}

	public String getHibernateShowSQL() {
		return hibernateShowSQL;
	}

	public void setHibernateShowSQL(String hibernateShowSQL) {
		this.hibernateShowSQL = hibernateShowSQL;
	}

	public String getHibernateFormatSQL() {
		return hibernateFormatSQL;
	}

	public void setHibernateFormatSQL(String hibernateFormatSQL) {
		this.hibernateFormatSQL = hibernateFormatSQL;
	}

	public String getHibernateSecondLevelCache() {
		return hibernateSecondLevelCache;
	}

	public void setHibernateSecondLevelCache(String hibernateSecondLevelCache) {
		this.hibernateSecondLevelCache = hibernateSecondLevelCache;
	}

	public String getHibernateQueryCache() {
		return hibernateQueryCache;
	}

	public void setHibernateQueryCache(String hibernateQueryCache) {
		this.hibernateQueryCache = hibernateQueryCache;
	}

	public String getHibernateGenerateStatistics() {
		return hibernateGenerateStatistics;
	}

	public void setHibernateGenerateStatistics(String hibernateGenerateStatistics) {
		this.hibernateGenerateStatistics = hibernateGenerateStatistics;
	}

	public String getHibernateFactoryClass() {
		return hibernateFactoryClass;
	}

	public void setHibernateFactoryClass(String hibernateFactoryClass) {
		this.hibernateFactoryClass = hibernateFactoryClass;
	}

	public String getHibernateProviderClass() {
		return hibernateProviderClass;
	}

	public void setHibernateProviderClass(String hibernateProviderClass) {
		this.hibernateProviderClass = hibernateProviderClass;
	}

	public String getHibernateJavaxCacheProvider() {
		return hibernateJavaxCacheProvider;
	}

	public void setHibernateJavaxCacheProvider(String hibernateJavaxCacheProvider) {
		this.hibernateJavaxCacheProvider = hibernateJavaxCacheProvider;
	}

	public String getHibernateLevelSQL() {
		return hibernateLevelSQL;
	}

	public void setHibernateLevelSQL(String hibernateLevelSQL) {
		this.hibernateLevelSQL = hibernateLevelSQL;
	}

	public String getHibernateLevelTypeSQLBasicBinder() {
		return hibernateLevelTypeSQLBasicBinder;
	}

	public void setHibernateLevelTypeSQLBasicBinder(String hibernateLevelTypeSQLBasicBinder) {
		this.hibernateLevelTypeSQLBasicBinder = hibernateLevelTypeSQLBasicBinder;
	}

	public String getDatasourceClassname() {
		return datasourceClassname;
	}

	public void setDatasourceClassname(String datasourceClassname) {
		this.datasourceClassname = datasourceClassname;
	}

	public String getHibernateDriver() {
		return hibernateDriver;
	}

	public void setHibernateDriver(String hibernateDriver) {
		this.hibernateDriver = hibernateDriver;
	}

	@Override
	public String toString() {
		return "DatabaseConfiguration [datasourceType=" + datasourceType + ", datasourceUrl=" + datasourceUrl
				+ ", datasourceUsername=" + datasourceUsername + ", datasourcePassword=" + datasourcePassword
				+ ", hibernateDriver=" + hibernateDriver + ", datasourceClassname=" + datasourceClassname
				+ ", hikariAutocommit=" + hikariAutocommit + ", hikariPoolName=" + hikariPoolName
				+ ", hikariConnectionTimeout=" + hikariConnectionTimeout + ", hikariMaxLifetime=" + hikariMaxLifetime
				+ ", hikariMaximumPoolSize=" + hikariMaximumPoolSize + ", hikariMinimumIdle=" + hikariMinimumIdle
				+ ", hikariIdleTimeout=" + hikariIdleTimeout + ", hikariConnectionTestQuery="
				+ hikariConnectionTestQuery + ", hikariCachePrepStmts=" + hikariCachePrepStmts
				+ ", hikariPrepStmtCacheSize=" + hikariPrepStmtCacheSize + ", hikariPrepStmtCacheSqlLimit="
				+ hikariPrepStmtCacheSqlLimit + ", hikariUseServerPrepStmts=" + hikariUseServerPrepStmts
				+ ", hikariLevelHikariConfig=" + hikariLevelHikariConfig + ", hibernateDialect=" + hibernateDialect
				+ ", hibernateShowSQL=" + hibernateShowSQL + ", hibernateFormatSQL=" + hibernateFormatSQL
				+ ", hibernateSecondLevelCache=" + hibernateSecondLevelCache + ", hibernateQueryCache="
				+ hibernateQueryCache + ", hibernateGenerateStatistics=" + hibernateGenerateStatistics
				+ ", hibernateFactoryClass=" + hibernateFactoryClass + ", hibernateProviderClass="
				+ hibernateProviderClass + ", hibernateJavaxCacheProvider=" + hibernateJavaxCacheProvider
				+ ", hibernateLevelSQL=" + hibernateLevelSQL + ", hibernateLevelTypeSQLBasicBinder="
				+ hibernateLevelTypeSQLBasicBinder + ", getDatasourceType()=" + getDatasourceType()
				+ ", getDatasourceUrl()=" + getDatasourceUrl() + ", getDatasourceUsername()=" + getDatasourceUsername()
				+ ", getDatasourcePassword()=" + getDatasourcePassword() + ", getHikariAutocommit()="
				+ getHikariAutocommit() + ", getHikariPoolName()=" + getHikariPoolName()
				+ ", getHikariConnectionTimeout()=" + getHikariConnectionTimeout() + ", getHikariMaxLifetime()="
				+ getHikariMaxLifetime() + ", getHikariMaximumPoolSize()=" + getHikariMaximumPoolSize()
				+ ", getHikariMinimumIdle()=" + getHikariMinimumIdle() + ", getHikariIdleTimeout()="
				+ getHikariIdleTimeout() + ", getHikariConnectionTestQuery()=" + getHikariConnectionTestQuery()
				+ ", getHikariCachePrepStmts()=" + getHikariCachePrepStmts() + ", getHikariPrepStmtCacheSize()="
				+ getHikariPrepStmtCacheSize() + ", getHikariPrepStmtCacheSqlLimit()="
				+ getHikariPrepStmtCacheSqlLimit() + ", getHikariUseServerPrepStmts()=" + getHikariUseServerPrepStmts()
				+ ", getHikariLevelHikariConfig()=" + getHikariLevelHikariConfig() + ", getHibernateDialect()="
				+ getHibernateDialect() + ", getHibernateShowSQL()=" + getHibernateShowSQL()
				+ ", getHibernateFormatSQL()=" + getHibernateFormatSQL() + ", getHibernateSecondLevelCache()="
				+ getHibernateSecondLevelCache() + ", getHibernateQueryCache()=" + getHibernateQueryCache()
				+ ", getHibernateGenerateStatistics()=" + getHibernateGenerateStatistics()
				+ ", getHibernateFactoryClass()=" + getHibernateFactoryClass() + ", getHibernateProviderClass()="
				+ getHibernateProviderClass() + ", getHibernateJavaxCacheProvider()=" + getHibernateJavaxCacheProvider()
				+ ", getHibernateLevelSQL()=" + getHibernateLevelSQL() + ", getHibernateLevelTypeSQLBasicBinder()="
				+ getHibernateLevelTypeSQLBasicBinder() + ", getDatasourceClassname()=" + getDatasourceClassname()
				+ ", getHibernateDriver()=" + getHibernateDriver() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	
}
