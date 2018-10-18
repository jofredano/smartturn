package co.org.smartturn.persistent.dao.impl;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import co.org.smartturn.data.model.filter.Range;
import co.org.smartturn.data.model.filter.TransformData;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.filter.UserFilter;
import co.org.smartturn.domain.vo.VOUser;
import co.org.smartturn.exception.ConvertException;
import co.org.smartturn.exception.PersistentException;
import co.org.smartturn.utils.Utilities;

/**
 * Implementacion de la persistencia a usuarios.
 * 
 * @author joseanor
 *
 */
@Transactional
@Repository(value = "userRepository")
public class UserRepositoryImpl {

	public VOUser checkLogin(Credential credential) throws PersistentException {
		if(credential == null) {
		   throw new PersistentException(
			  "PER-001", 
			  "No hay informacion del usuario");
		}
		StringBuilder sql = new StringBuilder();
		sql.append("  SELECT p ");
		sql.append("  FROM 	 co.org.smartturn.persistent.vo.VOUser p ");
		sql.append("  WHERE  p.username = '")
		   .append( credential.getUsername() )
		   .append( "'" );
		sql.append("  AND 	 p.password = PASSWORD('")
		   .append( credential.getPassword() )
		   .append( "')" );
		//return getSingleResult(sql.toString());
		return null;
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
		if(filter.get(UserFilter.ColumnFilter.USER_NAME) != null) {
		   sql.append(" AND p.username LIKE '%")
		   	  .append( filter.get(UserFilter.ColumnFilter.USER_NAME) )
		      .append("%'");
		}
		if(filter.get(UserFilter.ColumnFilter.USER_FIRSTNAME) != null) {
		   sql.append(" AND p.contact.firstname LIKE '%")
		   	  .append( filter.get(UserFilter.ColumnFilter.USER_FIRSTNAME) )
		      .append("%'");
		}
		if(filter.get(UserFilter.ColumnFilter.USER_SECONDNAME) != null) {
		   sql.append(" AND p.contact.secondname LIKE '%")
		   	  .append( filter.get(UserFilter.ColumnFilter.USER_SECONDNAME) )
		      .append("%'");
		}
		if(filter.get(UserFilter.ColumnFilter.USER_FIRSTLASTNAME) != null) {
		   sql.append(" AND p.contact.firstLastname LIKE '%")
		   	  .append( filter.get(UserFilter.ColumnFilter.USER_FIRSTLASTNAME) )
		      .append("%'");
		}
		if(filter.get(UserFilter.ColumnFilter.USER_SECONDLASTNAME) != null) {
		   sql.append(" AND p.contact.secondLastname LIKE '%")
		   	  .append( filter.get(UserFilter.ColumnFilter.USER_SECONDLASTNAME) )
		      .append("%'");
		}
		if(filter.get(UserFilter.ColumnFilter.USER_IDENTIFICATION) != null) {
		   sql.append(" AND p.contact.identification = '")
		   	  .append( Utilities.convertString(filter, UserFilter.ColumnFilter.USER_IDENTIFICATION) )
		      .append("'");
		}
		if(filter.get(UserFilter.ColumnFilter.USER_BIRTHDAY) != null) {
		   Range<java.util.Date> date = (Range<java.util.Date>) filter.get(UserFilter.ColumnFilter.USER_BIRTHDAY);
		   date.setField( "p.contact.birth" );
		   sql.append( " AND p.contact.birth BETWEEN " )
		      .append( date.format("p.contact.birth.begin AND p.contact.birth.end", transform) );
		}
		if(filter.get(UserFilter.ColumnFilter.USER_CREATED) != null) {
		   Range<java.util.Date> date = (Range<java.util.Date>) filter.get(UserFilter.ColumnFilter.USER_CREATED);
		   date.setField( "p.contact.created" );
		   sql.append( " AND p.contact.created BETWEEN " )
		      .append( date.format("p.contact.created.begin AND p.contact.created.end", transform) );
		}
	}

}

