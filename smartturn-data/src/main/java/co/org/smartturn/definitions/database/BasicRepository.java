package co.org.smartturn.definitions.database;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.utils.Utilities;

/**
 * Esta clase define de manera general el flujo del control
 * para la conectividad a la base de datos. 
 *  
 * @author joseanor
 */
public abstract class BasicRepository {
    
    /**
     * Instancia para manejo de logs.
     */
    protected static Logger log;
    
	/**
	 * Instancia de la conexion a la base de datos.
	 */
	protected Connection connection;
	
	/**
	 * Constructor de la clase.
	 * @param 	connection		Conexion a la base de datos
	 */
	public BasicRepository(Connection connection) {
		this.connection = connection;
	}

    /**
     * Metodo que asigna instancia para manejo de logs
     * @param 	logger		Informacion del logger 
     */
    public static void setLog(Logger logger) {
        log = logger;
    }
    
	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo numero doble
	 */
	protected static void setParam(PreparedStatement stmt, int position, Double value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.DOUBLE);
		    }
		}
	}
    
	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo numero flotante
	 */
	protected static void setParam(PreparedStatement stmt, int position, Float value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.FLOAT);
		    }
		}
	}
    
	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo numero largo
	 */
	protected static void setParam(PreparedStatement stmt, int position, Long value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.INTEGER);
		    }
		}
	}

	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo numero entero
	 */
	protected static void setParam(PreparedStatement stmt, int position, Integer value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.INTEGER);
		    }
		}
	}

	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo numero entero
	 */
	protected static void setParam(PreparedStatement stmt, int position, Short value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.SMALLINT);
		    }
		}
	}
	
	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo cadena
	 */
	protected static void setParam(PreparedStatement stmt, int position, String value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.VARCHAR);
		    }
		}
	}
	
	/**
	 * Puede asignarle a la sentencia un valor sin importar si esta nulo
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar en la sentencia tipo fecha
	 */
	protected static void setParam(PreparedStatement stmt, int position, java.util.Date value) {
		if(stmt != null) {
			if(value != null) {
		       setValuParam(stmt, position, value);
		    } else {
		       setNullParam(stmt, position, java.sql.Types.DATE);
		    }
		}
	}
	
	/**
	 * Puede asignarle a la sentencia valores no nulos
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	value		Valor a asignar
	 */
	protected static void setValuParam(PreparedStatement stmt, int position, Serializable value) {
		try {
	       //Con esto puede saber de que tipo es la variable
	       //Si realmente es de tipo Date, y lo mismo con las demas
		   if(value instanceof java.util.Date) {
			 stmt.setDate(position , new java.sql.Date(((java.util.Date)value).getTime()));					  
		   } else if(value instanceof String) {
			 stmt.setString(position , (String)value);
		   } else if(value instanceof Long) {
			 stmt.setLong(position , (Long)value);
		   } else if(value instanceof Short) {
			 stmt.setShort(position , (Short)value);
		   } else if(value instanceof Integer) {
			 stmt.setInt(position , (Integer)value);
		   } else if(value instanceof Double) {
			 stmt.setDouble(position , (Double)value);
		   } else if(value instanceof Float) {
			 stmt.setFloat(position , (Float)value);
		   } else if(value instanceof BigDecimal) {
			 stmt.setBigDecimal(position , (BigDecimal)value);
		   }
	   } catch (SQLException e) {
		   Utilities.logger( log, Level.SEVERE, "Problemas asignando valor a sentencia", e);
	   }		
	}
	
	/**
	 * Puede asignarle a la sentencia datos nulos
	 * @param 	stmt		Instancia a realizar asignacion
	 * @param 	position	Posicion dentro de la sentencia para asignar el valor
	 * @param 	type		Se envia que tipo de dato es
	 */
	protected static void setNullParam(PreparedStatement stmt, int position, int type) {
		try {
		   stmt.setNull(position, type);
	   } catch (SQLException e) {
		   Utilities.logger( log, Level.SEVERE, "Problemas asignando valor a sentencia", e);
	   }
	}
	
	/**
	 * Metodo que cierra una sentencia
	 * @param 	stmt	Instancia de la sentencia
	 */
	protected static void close(Statement stmt) {
		if(stmt != null) {
		   try {
			 stmt.close();
		   } catch (SQLException e) {
			  Utilities.logger( log, Level.SEVERE, "No se pudo cerrar la sentencia", e); 
		   }
		}
	}
	
	/**
	 * Metodo que cierra el resultset
	 * @param 	resultSet	Instancia resultset
	 */
	protected static void close(ResultSet resultSet) {
		if(resultSet != null) {
		   try {
			   resultSet.close();
		   } catch (SQLException e) {
			  Utilities.logger( log, Level.SEVERE, "No se pudo cerrar el resultset", e); 
		   }
		}
	}
	
    /**
     * Obtiene la conexion a base de datos.
     * @return javax.sql.Connection
     * @throws co.com.soft.core.exception.DAOException
     */
    public static Connection getConnectionInstance() throws PersistentException {
        try {
            String jndi             = "java:/comp/env/jdbc/TestConnection";
            InitialContext context  = new InitialContext(); 
            return getConnectionInstance(context, jndi);
        } catch (NamingException ex) {
            throw new PersistentException("NAM", ex.getMessage(), ex);
        }
    }
    
    /**
     * Obtiene la conexi�n de base de datos del contexto (hace autocommit)
     * @param   jndi        Recurso JNDI a obtener
     * @return  java.sql.Connection
     */
    public static Connection getConnectionInstance(String jndi) {
        try {
            InitialContext context  = new InitialContext(); 
            return getConnectionInstance(context, jndi, true);
        } catch (NamingException ex) {
        	Utilities.logger( log, Level.SEVERE, "Problemas para obtener la conexion", ex);
        }
        return null;
    }
    
    /**
     * Obtiene la conexi�n de base de datos del contexto (hace autocommit)
     * @param   context     Contexto de la aplicaci�n
     * @param   jndi        Recurso JNDI a obtener
     * @return  java.sql.Connection
     */
    public static Connection getConnectionInstance(Context context, String jndi) {
        return getConnectionInstance(context, jndi, true);
    }
    
    /**
     * Obtiene la conexi�n de base de datos del contexto
     * @param   context     Contexto de la aplicacion
     * @param   jndi        Recurso JNDI a obtener
     * @param   autoCommit  Maneja autocommit
     * @return  java.sql.Connection
     */
    public static Connection getConnectionInstance(Context context, String jndi, boolean autoCommit) {
        try {
            DataSource ds    = (DataSource)context.lookup(jndi);
            Connection conn  = ds.getConnection();
            conn.setAutoCommit(autoCommit);
            return conn;
        } catch (NamingException | SQLException ex) {
        	Utilities.logger( log, Level.SEVERE, "Problemas para obtener la conexion", ex);
        } 
        return null;
    }

}