package co.org.smartturn.persistent.dao.security.impl;

import java.util.List;

import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.definitions.database.sql.InstructionType;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.dao.mysql.DataPersistentMysqlHibernate;
import co.org.smartturn.persistent.dao.security.AccessDAO;
import co.org.smartturn.persistent.vo.response.ResultVOAccess;
import co.org.smartturn.persistent.vo.security.VOAccess;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion de la persistencia a usuarios.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "accessRepository")
public class AccessRepository extends DataPersistentMysqlHibernate<VOAccess, Long> implements AccessDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Result<VOAccess> filter(MapEntity filter, Pageable paging) throws PersistentException {
		Session session = null;
		Result<VOAccess> items = null;
		StringBuilder sql = new StringBuilder();
		sql.append("  SELECT p ");
		sql.append("  FROM 	 co.org.smartturn.persistent.vo.security.VOAccess p ");
		sql.append("  WHERE  1 = 1 ");
		try {
			session  = getSession();
			Query<VOAccess> query = session.createQuery(sql.toString());
			if(paging != null) {
			   query.setFirstResult((int) paging.getBegin());
			   query.setMaxResults((int) paging.getCount());
			}
			List<VOAccess> data = query.getResultList();
			items = new ResultVOAccess();
			items.setContent( data );
			items.setSize( data.size() );
			return items;
		} finally {
            if (session != null) {
                closeSession();
            }
            if(items != null) {
               items = null;
            }
        }
	}
	
	@Override
	public Result<VOAccess> filter(MapEntity filter) throws PersistentException {
		return filter(filter, null);
	}

	@Override
	public String checkUser(Credential credential) throws PersistentException {
		Session session 		= null;
		String codeResponse 	= null;
		String mssgResponse 	= null;
		String tokenResponse 	= null;
		try {
			String sql 	= "pcn_acceder_usuario";
			session 	= getSession();
			session.beginTransaction();
			StoredProcedureQuery query = ((StoredProcedureQuery)createQuery(session, InstructionType.STOREPROCEDURE, sql))
					.registerStoredProcedureParameter("_alias_usu"    	, String.class , ParameterMode.IN)
					.registerStoredProcedureParameter("_clave_usu"    	, String.class , ParameterMode.IN)
					.registerStoredProcedureParameter("o_token"         , String.class , ParameterMode.OUT)
					.registerStoredProcedureParameter("o_codigo"        , String.class , ParameterMode.OUT)
					.registerStoredProcedureParameter("o_descripcion"   , String.class , ParameterMode.OUT)
					.setParameter("_alias_usu" , credential.getUsername())
					.setParameter("_clave_usu" , credential.getPassword());
			query.execute();
			tokenResponse = (String)query.getOutputParameterValue("o_token");
			codeResponse  = (String)query.getOutputParameterValue("o_codigo");
			mssgResponse  = (String)query.getOutputParameterValue("o_descripcion");
			if(!Utilities.isEmpty(codeResponse) && "OK".equalsIgnoreCase(codeResponse)) {
				session.getTransaction().commit();	
			} else {
				session.getTransaction().rollback();
				throw new PersistentException(codeResponse, mssgResponse);
			}
			return tokenResponse;
		} finally {
			if (session != null) {
				closeSession();
				session = null;
			}
		}
	}

	@Override
	public boolean update(VOAccess user) throws PersistentException {
		return execute(user, Transaction.UPDATE) != null;
	}

	@Override
	public VOAccess create(VOAccess user) throws PersistentException {
		return execute(user, Transaction.SAVE);
	}

}
