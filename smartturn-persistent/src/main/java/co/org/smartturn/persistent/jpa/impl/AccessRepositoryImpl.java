package co.org.smartturn.persistent.jpa.impl;

import java.io.Serializable;
import java.util.Map;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.fields.ColumnFields;
import co.org.smartturn.definitions.database.sql.InstructionType;
import co.org.smartturn.domain.vo.VOAccess;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.jpa.nojpa.AccessDataRepository;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion de la persistencia a usuarios.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "accessRepository")
public class AccessRepositoryImpl implements AccessDataRepository {

	@Override
	public Map<String, Serializable> checkUser(Credential credential) throws PersistentException {
		Session session 			= null;
		String codeResponse 		= null;
		String mssgResponse 		= null;
		String tokenResponse 		= null;
		java.sql.Date dateResponse 	= null;
		java.util.Map<String, Serializable> data = null;
		try {
			String sql 	= "pcn_acceder_usuario";
			StoredProcedureQuery query = ((StoredProcedureQuery)createQuery(session, InstructionType.STOREPROCEDURE, sql))
					.registerStoredProcedureParameter("_alias_usu"    	, String.class 		  , ParameterMode.IN)
					.registerStoredProcedureParameter("_clave_usu"    	, String.class 		  , ParameterMode.IN)
					.registerStoredProcedureParameter("o_token"         , String.class 		  , ParameterMode.OUT)
					.registerStoredProcedureParameter("o_codigo"        , String.class 		  , ParameterMode.OUT)
					.registerStoredProcedureParameter("o_descripcion"   , String.class 		  , ParameterMode.OUT)
					.registerStoredProcedureParameter("o_ffin"          , java.sql.Date.class , ParameterMode.OUT)
					.setParameter("_alias_usu" , credential.getUsername())
					.setParameter("_clave_usu" , credential.getPassword());
			query.execute();
			tokenResponse = (String)query.getOutputParameterValue("o_token");
			codeResponse  = (String)query.getOutputParameterValue("o_codigo");
			mssgResponse  = (String)query.getOutputParameterValue("o_descripcion");
			dateResponse  = (java.sql.Date)query.getOutputParameterValue("o_ffin");
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
	
	private StoredProcedureQuery createQuery(Session session, InstructionType storeprocedure, String sql) {
		return null;
	}

	public boolean validate(VOAccess access) throws PersistentException {
		if(access == null) {
		   throw new PersistentException("PER-001", "No hay informacion de acceso");
		}
		StringBuilder sql = new StringBuilder();
		sql.append("  SELECT IF(COUNT(p.token) > 0, 'TRUE' , 'FALSE') AS checked ");
		sql.append("  FROM 	 co.org.smartturn.persistent.vo.security.VOAccess p ");
		sql.append("  WHERE  p.token = '").append( access.get(ColumnFields.ACCESS_TOKEN) ).append("' ");
		sql.append("  AND 	 DATE_ADD(p.begin, INTERVAL p.duration MINUTE) <= CURRENT_TIMESTAMP ");
		//return "TRUE".equalsIgnoreCase(getSingleResult(sql.toString()));
		return false;
	}

	/**
	 * Metodo que prepara la consulta a la base de datos
	 * @param 	filter		Informacion para realizar filtro
	 * @param 	sql			Objeto SQL base
	 * @throws PersistentException
	 */
	protected static void prepareQuery(MapEntity filter, StringBuilder sql) throws PersistentException {
		if(filter == null) {
		   throw new PersistentException("PER-001", "No hay informacion de los filtros");
		}
		if(filter.get(ColumnFields.ACCESS_TOKEN) != null) {
		   sql.append(" AND p.token = '")
		   	  .append( filter.get(ColumnFields.ACCESS_TOKEN) )
		      .append("'");
		}
	}
	
}
