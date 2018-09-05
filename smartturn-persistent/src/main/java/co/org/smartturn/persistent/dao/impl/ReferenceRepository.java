package co.org.smartturn.persistent.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.Reference;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.dao.ReferenceDAO;
import co.org.smartturn.persistent.dao.mysql.DataPersistentMysqlHibernate;
import co.org.smartturn.persistent.vo.VOReference;
import co.org.smartturn.persistent.vo.response.ResultVOReference;

/**
 * Implementacion de la persistencia a usuarios.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "referenceRepository")
public class ReferenceRepository extends DataPersistentMysqlHibernate<VOReference, Long> implements ReferenceDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Result<VOReference> filter(MapEntity filter, Pageable paging) throws PersistentException {
		Session session = null;
		Result<VOReference> items = null;
		StringBuilder sql = new StringBuilder();
		sql.append("	SELECT 	p ");
		sql.append("	FROM 	co.org.smartturn.persistent.vo.VOReference p ");
		sql.append("	WHERE 	1 = 1 ");
		try {
			session  = getSession();
			Query<VOReference> query = session.createQuery(sql.toString());
			if(paging != null) {
			   query.setFirstResult((int) paging.getBegin());
			   query.setMaxResults((int) paging.getCount());
			}
			List<VOReference> data   = query.getResultList();
			items = new ResultVOReference();
			items.setContent( data );
			items.setSize( data.size() );
		} finally {
            if (session != null) {
                closeSession();
            }
        }
		return items;
	}

	@Override
	public Result<VOReference> filter(MapEntity filter) throws PersistentException {
		return filter(filter, null);
	}

	@Override
	public boolean update(Reference reference) throws PersistentException {
		return execute((VOReference) reference, Transaction.UPDATE) != null;
	}

}
