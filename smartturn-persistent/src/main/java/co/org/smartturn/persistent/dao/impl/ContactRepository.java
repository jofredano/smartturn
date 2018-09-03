package co.org.smartturn.persistent.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.response.ResponseStatus;
import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.dao.ContactDAO;
import co.org.smartturn.persistent.dao.mysql.DataPersistentMysqlHibernate;
import co.org.smartturn.persistent.vo.VOContact;
import co.org.smartturn.persistent.vo.response.ResponseVOContact;

/**
 * Implementacion de la persistencia a usuarios.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "contactRepository")
public class ContactRepository extends DataPersistentMysqlHibernate<VOContact, Long> implements ContactDAO {
	
	@SuppressWarnings("unchecked")
	@Override
	public Response<VOContact> filter(MapEntity filter, Pageable paging) throws PersistentException {
		Session session = null;
		Response<VOContact> items = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT p ");
		sql.append(" FROM 	co.org.smartturn.persistent.vo.VOContact p ");
		sql.append(" WHERE 	1 = 1 ");
		try {
			session  = getSession();
			Query<VOContact> query = session.createQuery(sql.toString());
			if(paging != null) {
			   query.setFirstResult((int) paging.getBegin());
			   query.setMaxResults((int) paging.getCount());
			}
			List<VOContact> data = query.getResultList();
			items = new ResponseVOContact();
			items.setContent( data );
			items.setSize( data.size() );
		} finally {
            if (session != null) {
                closeSession();
                session = null;
            }
        }
		return items;
	}

	@Override
	public Response<VOContact> filter(MapEntity filter) throws PersistentException {
		return filter(filter, null);
	}

	@Override
	public Response<Integer> update(VOContact contact) throws PersistentException {
		return execute(contact, Transaction.UPDATE) != null?new ResponseStatus(1):null;
	}
}
