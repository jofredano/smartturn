package co.org.smartturn.persistent.jpa.nojpa.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.filter.Range;
import co.org.smartturn.data.model.filter.TransformData;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.filter.ContactFilter;
import co.org.smartturn.exception.ConvertException;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion de la persistencia a contactos.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "contactRepository")
public class ContactRepositoryImpl {

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
