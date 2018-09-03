package co.org.smartturn.persistent.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.Profile;
import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.response.ResponseStatus;
import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.dao.ProfileDAO;
import co.org.smartturn.persistent.dao.mysql.DataPersistentMysqlHibernate;
import co.org.smartturn.persistent.vo.VOProfile;
import co.org.smartturn.persistent.vo.response.ResponseVOProfile;

/**
 * Implementacion de la persistencia a perfiles.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "profileRepository")
public class ProfileRepository extends DataPersistentMysqlHibernate<Profile<Long>, Long> implements ProfileDAO {

	@SuppressWarnings("unchecked")
	@Override
	public Response<VOProfile> filter(MapEntity filter, Pageable paging) throws PersistentException {
		Session session = null;
		Response<VOProfile> items = null;
		StringBuilder sql = new StringBuilder();
		sql.append("	SELECT 	p ");
		sql.append("	FROM 	co.org.smartturn.persistent.vo.VOProfile p ");
		sql.append("	WHERE 	1 = 1 ");
		try {
			session  = getSession();
			Query<VOProfile> query = session.createQuery(sql.toString());
			if(paging != null) {
			   query.setFirstResult((int) paging.getBegin());
			   query.setMaxResults((int) paging.getCount());
			}
			List<VOProfile> data = query.getResultList();
			items = new ResponseVOProfile();
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
	public Response<VOProfile> filter(MapEntity filter) throws PersistentException {
		return filter(filter, null);
	}

	@Override
	public Response<Integer> update(Profile<?> profile) throws PersistentException {
		return execute((VOProfile) profile, Transaction.UPDATE) != null?new ResponseStatus(1):null;
	}

}
