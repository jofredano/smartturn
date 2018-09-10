package co.org.smartturn.persistent.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.filter.Range;
import co.org.smartturn.data.model.filter.TransformData;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.filter.ContactFilter;
import co.org.smartturn.definitions.database.section.Transaction;
import co.org.smartturn.exception.ConvertException;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.persistent.dao.ContactDAO;
import co.org.smartturn.persistent.dao.mysql.DataPersistentMysqlHibernate;
import co.org.smartturn.persistent.vo.VOContact;
import co.org.smartturn.persistent.vo.response.ResultVOContact;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion de la persistencia a contactos.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "contactRepository")
public class ContactRepository extends DataPersistentMysqlHibernate<VOContact, Long> implements ContactDAO {


	@SuppressWarnings("unchecked")
	@Override
	public Result<VOContact> filter(MapEntity filter, Pageable paging) throws PersistentException {
		Session session = null;
		Result<VOContact> items = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT p ");
		sql.append(" FROM 	co.org.smartturn.persistent.vo.VOContact p ");
		sql.append(" WHERE 	1 = 1 ");
		try {
			prepareQuery(filter, sql);
			System.err.println("SQL => " + sql.toString());
			session  = getSession();
			Query<VOContact> query = session.createQuery(sql.toString());
			if(paging != null) {
			   query.setFirstResult((int) paging.getBegin());
			   query.setMaxResults((int) paging.getCount());
			}
			List<VOContact> data = query.getResultList();
			items = new ResultVOContact();
			items.setContent( data );
			items.setSize( data.size() );
		} catch (ConvertException e) {
			throw new PersistentException("PER-002", "Hubo problemas de conversion", e);
		} finally {
            if (session != null) {
                closeSession();
                session = null;
            }
        }
		return items;
	}

	@Override
	public Result<VOContact> filter(MapEntity filter) throws PersistentException {
		return filter(filter, null);
	}

	@Override
	public boolean update(VOContact contact) throws PersistentException {
		return execute(contact, Transaction.UPDATE) != null;
	}

	/**
	 * Prepara la consulta a la base de datos
	 * @param 	filter	Informacion del filtro
	 * @param 	sql		Instancia donde se almacena la consulta
	 * @throws PersistentException 
	 * @throws ConvertException 
	 */
	@SuppressWarnings("unchecked")
	protected static void prepareQuery(MapEntity filter, StringBuilder sql) throws PersistentException, ConvertException {
		if(filter == null) {
		   throw new PersistentException("PER-001", "No hay informacion de los filtros");
		}
		TransformData<java.util.Date> transform = new TransformData<java.util.Date>() {
			 @Override
			 public String convert(java.util.Date data) throws ConvertException {
				StringBuilder builder = new StringBuilder();
				builder.append( "STR_TO_DATE('" )
					   .append( Utilities.dateToString("dd/MM/yyyy", data) )
				       .append( "', '%d/%m/%Y')" );
				return builder.toString();
			 }
  	  	};
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_FIRSTNAME) != null) {
		   sql.append(" AND p.firstname LIKE '%")
		   	  .append( filter.get(ContactFilter.ColumnFilter.CONTACT_FIRSTNAME) )
		      .append("%'");
		}
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_SECONDNAME) != null) {
		   sql.append(" AND p.secondname LIKE '%")
		   	  .append( filter.get(ContactFilter.ColumnFilter.CONTACT_SECONDNAME) )
		      .append("%'");
		}
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_FIRSTLASTNAME) != null) {
		   sql.append(" AND p.firstLastname LIKE '%")
		   	  .append( filter.get(ContactFilter.ColumnFilter.CONTACT_FIRSTLASTNAME) )
		      .append("%'");
		}
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_SECONDLASTNAME) != null) {
		   sql.append(" AND p.secondLastname LIKE '%")
		   	  .append( filter.get(ContactFilter.ColumnFilter.CONTACT_SECONDLASTNAME) )
		      .append("%'");
		}
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_IDENTIFICATION) != null) {
		   sql.append(" AND p.identification = '")
		   	  .append( Utilities.convertString(filter, ContactFilter.ColumnFilter.CONTACT_IDENTIFICATION) )
		      .append("'");
		}
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_BIRTHDAY) != null) {
		   Range<java.util.Date> date = (Range<java.util.Date>) filter.get(ContactFilter.ColumnFilter.CONTACT_BIRTHDAY);
		   date.setField( "p.birth" );
		   sql.append( " AND p.birth BETWEEN " )
		      .append( date.format("p.birth.begin AND p.birth.end", transform) );
		}
		if(filter.get(ContactFilter.ColumnFilter.CONTACT_CREATED) != null) {
		   Range<java.util.Date> date = (Range<java.util.Date>) filter.get(ContactFilter.ColumnFilter.CONTACT_CREATED);
		   date.setField( "p.created" );
		   sql.append( " AND p.created BETWEEN " )
		      .append( date.format("p.created.begin AND p.created.end", transform) );
		}
	}
}
