package co.org.smartturn.persistent.dao.mysql;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.internal.SessionImpl;

import co.org.smartturn.data.structure.Field;
import co.org.smartturn.definitions.DataRepository;
import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.definitions.database.sql.InstructionType;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.entity.FieldSchema;
import co.org.smartturn.utils.callback.Callback;

/**
 * Clase de implementacion de la persistencia (mysql).
 * 
 * @author joseanor
 *
 * @param <T>
 */
public class DataPersistentMysqlHibernate<E extends java.io.Serializable, K extends java.io.Serializable> implements DataRepository<E, K> {

	/**
	 * Cantidad limite de registros a mantener antes de hacer commit
	 */
	public static final int SIZE_LIMIT_RECORDS = 20;
	
	/**
	 * Hilo local para controlar la sesion usada en la transaccion.
	 */
	private static ThreadLocal<Session> threadLocal;
	
    /**
     * Se encarga de encuentrar todos los archivos de mapeo de Hibernate y el
     * dialecto de Hibernate a utilizar (varia segun el gestor de base de datos).
     */
	private static SessionFactory sessionFactory;
	
    /**
     * Mecanismo de complemento para registrar servicios internos (proveedor de
     * conexion, gestion de transacciones).
     */
	private static StandardServiceRegistry registry;
	
	/**
	 * Listado de entidades a matricular.
	 */
	private static Class<?>[] entities = {
		co.org.smartturn.persistent.vo.VOReference.class,
		co.org.smartturn.persistent.vo.VOContact.class,
		co.org.smartturn.persistent.vo.VOProfile.class,
		co.org.smartturn.persistent.vo.VOUser.class
	};
	
	/**
	 * Inicializa la configuracion en los parametros de ambiente 
	 * (base de datos)
	 */
    @PostConstruct
    public void initDatabaseProperties() {
        StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        Map<String, Object> settings = new HashMap<>();
        /* JPA specific configs - Parametros de conexion a la base de datos */
        settings.put(Environment.DRIVER, System.getProperty("HIBERNATE_DRIVER"));
        settings.put(Environment.URL,  System.getProperty("HIBERNATE_URL"));
        settings.put(Environment.USER, System.getProperty("HIBERNATE_USERNAME"));
        settings.put(Environment.PASS, System.getProperty("HIBERNATE_PASSWORD"));
        /* Asignando SQL propiedades */
        settings.put(Environment.DIALECT, System.getProperty("HIBERNATE_DIALECT"));
        settings.put(Environment.SHOW_SQL, System.getProperty("HIBERNATE_SHOWSQL"));
        settings.put(Environment.FORMAT_SQL, System.getProperty("HIBERNATE_FORMATSQL"));
        /* Asignando cache */
        settings.put(Environment.USE_SECOND_LEVEL_CACHE, System.getProperty("HIBERNATE_CACHE_SECOND_LEVEL"));
        settings.put(Environment.USE_QUERY_CACHE, System.getProperty("HIBERNATE_CACHE_QUERY"));
        settings.put(Environment.CACHE_REGION_FACTORY, System.getProperty("HIBERNATE_CACHE_REGION_FACTORY_CLASS"));
        settings.put(Environment.GENERATE_STATISTICS, System.getProperty("HIBERNATE_GENERATE_STATISTICS"));
        settings.put("hibernate.javax.cache.provider", System.getProperty("HIBERNATE_CACHE_JAVAX_PROVIDER"));
        settings.put("hibernate.hikari.autoCommit", System.getProperty("HIKARI_AUTOCOMMIT"));
        settings.put("hibernate.hikari.dataSource.cachePrepStmts", System.getProperty("HIKARI_USER_SERVER_PREP_STMTS"));
        settings.put("hibernate.hikari.dataSource.prepStmtCacheSize",
                System.getProperty("HIKARI_PREP_STMT_CACHE_SIZE"));
        settings.put("hibernate.hikari.dataSource.prepStmtCacheSqlLimit",
                System.getProperty("HIKARI_PREP_STMT_CACHE_SQL_LIMIT"));
        settings.put("hibernate.hikari.minimumIdle", System.getProperty("HIKARI_MINIMUM_IDLE"));
        settings.put("hibernate.hikari.maximumPoolSize", System.getProperty("HIKARI_MAXIMUM_POOL_SIZE"));
        settings.put("hibernate.hikari.idleTimeout", System.getProperty("HIKARI_IDLE_TIMEOUT"));
        settings.put("hibernate.hikari.poolName", System.getProperty("HIKARI_POOL_NAME"));
        settings.put("hibernate.hikari.maxLifetime", System.getProperty("HIKARI_MAX_LIFE_TIME"));
        settings.put("hibernate.hikari.connectionTimeout", System.getProperty("HIKARI_CONNECTION_TIMEOUT"));
        settings.put("hibernate.hikari.connectionTestQuery", System.getProperty("HIKARI_CONNECTION_QUERY"));
        settings.put(Environment.CONNECTION_PROVIDER, System.getProperty("CONNECTION_PROVIDER_CLASS"));
        settings.put("logging.level.org.hibernate.SQL", System.getProperty("HIBERNATE_LEVEL_SQL"));
        settings.put("logging.level.com.zaxxer.hikari.HikariConfig", System.getProperty("HIKARI_LEVEL_CONFIGURATION"));
        settings.put("logging.level.org.hibernate.type.descriptor.sql.BasicBinder",
                System.getProperty("HIBERNATE_LEVEL_TYPE_SQL_BINDER"));
        //Aplicando configuracion, esta generando nullpointerexception
        registryBuilder.applySettings(settings); 
        setRegistry(registryBuilder.build());
        MetadataSources sources = new MetadataSources(registry);
        /* Incorporar DTOs a la configuracion de Hibernate */
        for(Class<?> entity : entities) {
        	sources.addAnnotatedClass(entity);        	
        }
        Metadata metadata = sources.getMetadataBuilder().build();
        setSessionFactory(metadata.getSessionFactoryBuilder().build());
    	setThread(new ThreadLocal<>());
    }
	
	@Override
	public Connection getConnection() {
		Session session = getSession();
		session.beginTransaction();
		return ((SessionImpl)session).connection();
	}

	@Override
	public Session getSession() {
        Session session = threadLocal.get();
        if (session == null) {
            session = sessionFactory.openSession();
            threadLocal.set(session);
        }
        return session;
	}

	@Override
	public void closeSession() {
        Session session = threadLocal.get();
        if (session != null) {
            session.close();
            threadLocal.set(null);
        }
	}
	
	@Override
    public void shutdown() {
        if (registry != null) {
           StandardServiceRegistryBuilder.destroy(registry);
        }
    }

	@Override
	public E execute(E entity, Transaction transaction) throws PersistentException {
        Session session = null;
        try {
            session 	= getSession();
            session.beginTransaction();
            if (transaction == Transaction.DELETE) {
                session.delete(entity);
            } else if(transaction == Transaction.UPDATE) {
                Object result = session.merge(entity);
                if(result == null)
                   return null;	
            } else {
            	Serializable result = session.save(entity);
            	if((result instanceof Number && ((Long)result) == 0) || result == null)
            	   return null;
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	rollback( session );
            throw new PersistentException("P001", e.getMessage(), e);
        } finally {
            if (session != null) {
                closeSession();
            }
        }
        return entity;
	}

	@Override
	public E execute(E entity, Transaction transaction, Callback<E, Boolean> callback) throws PersistentException {
        if(callback == null || callback.invoke(entity)) {
           return entity;        	
        }
        return null;
	}

	@Override
	public List<E> execute(List<E> entities, Transaction transaction) throws PersistentException {
	    	Session session = null;
	    	List<E> items 	= new ArrayList<>();
	    try {
	        session = getSession();
	        session.beginTransaction();
	        if(entities != null && !entities.isEmpty()) {
	           Iterator<E> iterator = entities.iterator();
	           for(int i = 0; i < entities.size(); i++) {
	        	   E entity = iterator.next();
	        	   E result = prepareEntity(session, entity, transaction);
	        	   if(result != null)
	        	      items.add(result);
	        	   //20, same as the JDBC batch size
	        	   if ( i % SIZE_LIMIT_RECORDS == 0 ) {
	        	      session.flush();
	        	      session.clear();
	        	   }
	           }
	        }
	        session.getTransaction().commit();
	    } catch (RuntimeException e) {
	    	rollback( session );
	        throw new PersistentException("P001", e.getMessage(), e);
	    } finally {
	    	closeSession();
	    }
	    return items;
	}

	@Override
	public List<E> execute(List<E> entities, Transaction transaction, Callback<List<E>, Boolean> callback) throws PersistentException {
        if(callback == null || callback.invoke(entities)) {
           return entities;        	
        }
        return Collections.emptyList();
	}

	@Override
	public Integer executeUpdate(InstructionType type, String sql, Transaction transaction) throws PersistentException {
        Session session 	= null;
        int result 			= 0;
        try {
            session 		= getSession();
            session.beginTransaction();
            if(transaction == Transaction.UPDATE) {
            	Query query = createQuery(session, type, null, sql);
            	result 		= query.executeUpdate();
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
        	rollback( session );
            throw new PersistentException("P001", e.getMessage(), e);
        } finally {
            if (session != null) {
                closeSession();
                session 	= null;
            }
        }
        return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends Serializable> T getSingleResult(String sql) {
		Session session = null;
		Query query 	= null; 
		try {
			session = getSession();
			query 	= session.createNativeQuery(sql);
			return (T)query.getSingleResult();
		} finally {
			if(query != null) {
			   query	= null;
			}
			if (session != null) {
				closeSession();
				session = null;
			}
		}
	}

	@Override
	public E getSingleResult(Class<E> entity, K key) {
		StringBuilder where = null;
		StringBuilder sql   = null;
		String alias 		= "a";
		List<Field> fields 	= null;
		try {
			sql   	= new StringBuilder();
			where 	= new StringBuilder();
			fields 	= getEntityFields(entity, alias);
			where.append(" 1 = 1 ");
			while(fields.iterator().hasNext()) {
				Field field = fields.iterator().next();
				where.append( " AND " )
				     .append( field.getName() )
				     .append( " = '" )
				     .append( key.toString() )
				     .append( "'" );
			}
			sql.append( "SELECT " )
			   .append( alias )
			   .append( " FROM " )
			   .append( getEntityName(entity, alias) )
			   .append( " WHERE " )
			   .append( where.toString() );
			return getSingleResult( sql.toString() );
		} finally {
			if(fields != null) {
			   fields.clear();
			   fields = null;				
			}
			if(where != null) {
			   where  = null;
			}
			if(sql != null) {
			   sql    = null;	
			}
		}
	}
	
	/**
	 * Metodo que realiza rollback de la transaccion
	 * @param 	session		Sesion a la que se le aplicara
	 */
	protected static void rollback(Session session) {
		try {
            if (session != null && session.getTransaction() != null) {
            	session.getTransaction().rollback();            	
            }
		} catch(IllegalStateException | PersistenceException e) {
			//veamos
		}
	}

    /**
     * Metodo que permite registrar el servicio.
     * @param registryBuilder
     */
    protected static void setRegistry(StandardServiceRegistry registryBuilder) {
    	registry = registryBuilder;
    }
    
    /**
     * Metodo que permite registrar la sesion.
     * @param session
     */
    protected static void setSessionFactory(SessionFactory session) {
    	sessionFactory = session;
    }
    
    /**
     * Metodo que permite registrar el hilo local.
     * @param thread
     */
    protected static void setThread(ThreadLocal<Session> thread) {
    	threadLocal = thread;
    }
    
	/**
	 * Crea un objeto Query
	 * @param 	session		Sesion de la base de datos
	 * @param 	type		Tipo de instruccion
	 * @param 	result		Clase de resultado definida para la consulta
	 * @param 	sql			Comando SQL
	 * @return	Query
	 */
	protected static <T extends Serializable> Query createQuery(Session session, InstructionType type, Class<T> result, String sql) {
		Query query = null;
		if(type == InstructionType.NATIVE) {
		   if(result != null) 	{ query = session.createNativeQuery(sql, result); 	} 
		   else 				{ query = session.createNativeQuery(sql); 			}
		} else if(type == InstructionType.STOREPROCEDURE) {
		   query = session.createStoredProcedureCall(sql);
		} else {
		   query = session.createQuery(sql);	
		}
		return query;
	}

	/**
	 * Crea un objeto Query
	 * @param 	session		Sesion de la base de datos
	 * @param 	type		Tipo de instruccion
	 * @param 	sql			Comando SQL
	 * @return	Query
	 */
	protected static Query createQuery(Session session, InstructionType type, String sql) {
		return createQuery(session, type, null, sql);
	}
	
	/**
	 * Prepara el resultado de la sesion
	 * @param 	session			Sesion de la transaccion
	 * @param 	entity			Entidad a aplicar
	 * @param 	transaction		Tipo de transaccion
	 * @return	T
	 */
	@SuppressWarnings("unchecked")
	protected static <T extends Object> T prepareEntity(Session session, T entity, Transaction transaction) {
		T results = null;
        if(transaction == Transaction.UPDATE) {
        	results = (T)session.merge(entity);
        } else if(transaction == Transaction.DELETE) {
        	session.delete(entity);
        	results = entity;
        } else {
        	Serializable result = session.save(entity);
        	if( !((result instanceof Number && ((Long)result) == 0) || result == null) )
        	   results = entity;
        }
        return results;
	}
	
	/**
	 * Metodo que retorna los campos de una entity.
	 * @param 	entity		Entidad a obtener los campos.
	 * @param 	alias		Nomenclatura definida a los campos de la entidad.
	 * @return	List<T>
	 */
	@SuppressWarnings("unchecked")
	protected static <T extends Object, F extends Field> List<F> getEntityFields(Class<T> entity, String alias) {
		List<FieldSchema> fields = new ArrayList<>();
		String aliasField 		 = (alias != null)?alias+".":"";
		java.lang.reflect.Field[] fieldsData = entity.getDeclaredFields();
		for(int i = 0; i < fieldsData.length; i++) {
			 if(fieldsData[i].isAnnotationPresent(Column.class)) {
				Column instance  = fieldsData[i].getAnnotation(Column.class);
				fields.add(new FieldSchema(
				   (aliasField + fieldsData[i].getName()), 
				   (aliasField + instance.name()), 
				   (fieldsData[i].isAnnotationPresent(Id.class)))
				);
			 }
        }
		return (List<F>) fields;
	}

	/**
	 * Metodo que retorna el nombre de la entidad.
	 * @return	String
	 */
	protected static <T extends Object> String getEntityName(Class<T> entity, String alias) {
		StringBuilder builder = new StringBuilder();
		builder.append(entity.getName());
		if(alias != null && !"".equals(alias))
			builder.append(" ").append(alias);
		return builder.toString();
	}

}

