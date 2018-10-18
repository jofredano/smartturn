package co.org.smartturn.persistent.dao.impl;

import java.io.Serializable;
import java.sql.Types;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.dao.AbstractDAO;
import co.org.smartturn.persistent.dao.AccessDAO;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion de la persistencia a usuarios.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "accessDAO")
public class AccessRepositoryImpl extends AbstractDAO implements AccessDAO {
	
	/**
	 * Constructor de la clase
	 * @param 	template	Plantilla jdbc
	 */
	public AccessRepositoryImpl(JdbcTemplate template) {
		super(template);
	}

	@Override
	public Map<String, Serializable> checkUser(Credential credential) throws PersistentException {
		String codeResponse 		 = null;
		String mssgResponse 		 = null;
		String tokenResponse 		 = null;
		java.sql.Date dateResponse 	 = null;
		java.util.Map<String, Serializable> data = null;
		try {
			SimpleJdbcCall statement = getJdbcCall()
				.withProcedureName("pcn_acceder_usuario")
				.declareParameters(
                    new SqlParameter("_alias_usu"		, Types.VARCHAR),
                    new SqlParameter("_clave_usu"		, Types.VARCHAR),
                    new SqlOutParameter("o_token" 		, Types.VARCHAR),
                    new SqlOutParameter("o_codigo"  	, Types.VARCHAR),
                    new SqlOutParameter("o_descripcion" , Types.VARCHAR),
                    new SqlOutParameter("o_ffin" 		, Types.DATE)
                );
			Map<String, Object> out  = statement.execute( 
				new MapSqlParameterSource()
                   .addValue("_alias_usu" , credential.getUsername())
                   .addValue("_clave_usu" , credential.getPassword()));
			tokenResponse = (String)out.get("o_token");
			codeResponse  = (String)out.get("o_codigo");
			mssgResponse  = (String)out.get("o_descripcion");
			dateResponse  = (java.sql.Date)out.get("o_ffin");
			if(!Utilities.isEmpty(codeResponse) && "OK".equalsIgnoreCase(codeResponse)) {
				data 	  = new java.util.HashMap<>();
				data.put("token" , tokenResponse);
				data.put("end"   , dateResponse);
			} else {
				throw new PersistentException(codeResponse, mssgResponse);
			}
			return data;
		} finally {
			//Veamos
		}
	}
	
}
