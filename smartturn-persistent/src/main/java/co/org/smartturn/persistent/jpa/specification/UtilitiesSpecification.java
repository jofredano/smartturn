package co.org.smartturn.persistent.jpa.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;

import org.springframework.data.jpa.domain.Specification;

import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.filter.RangeDate;
import co.org.smartturn.data.transfer.filter.UserFilter;
import co.org.smartturn.data.transfer.structure.ObjectMap;
import co.org.smartturn.domain.vo.VOUser;
import co.org.smartturn.domain.vo.VOUser_;
import co.org.smartturn.utils.Utilities;

/**
 * Clase donde se definen especificaciones para consulta.
 * 
 * @author joseanor
 *
 */
public class UtilitiesSpecification {

	/**
	 * Constructor de la clase.
	 */
	protected UtilitiesSpecification() {
		//Sin implementacion
	}
	
	/**
	 * Define consultas basadas en criteria
	 * @param 	filter		Informacion de la consulta
	 * @return	Specification<VOUser>
	 */
	public static Specification<VOUser> isQueryMap(MapEntity filter) {
	    return new Specification<VOUser>() {
			private static final long serialVersionUID = 1L;
			public Predicate toPredicate( Root<VOUser> root, CriteriaQuery<?> qc, CriteriaBuilder cb) {
				java.util.List<Predicate> predicates = new java.util.ArrayList<>();
				/*
		USER_FIRSTNAME("primerNombre"),
		USER_SECONDNAME("segundoNombre"),
		USER_FIRSTLASTNAME("primerApellido"),
		USER_SECONDLASTNAME("segundoApellido"),
		USER_IDENTIFICATION("identificacion");
		USER_BIRTHDAY
				 * */
				if(filter.get(UserFilter.ColumnFilter.USER_NAME) != null) {
				   predicates.add( UtilitiesSpecification.prepareLike(
					  UserFilter.ColumnFilter.USER_NAME, VOUser_.username, filter, root, cb ) );
				}
				if(filter.get(UserFilter.ColumnFilter.USER_CREATED) != null) {
				   predicates.add( UtilitiesSpecification.prepareBetweenRange(
					  UserFilter.ColumnFilter.USER_CREATED, VOUser_.created, filter, root, cb ) );
				}
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
		    }
	    };
	}
	
	/**
	 * Prepara consulta criteria para rangos de fecha
	 * @param 	field		Campo asociado
	 * @param 	attribute	Instancia del atributo
	 * @param 	filter		Objeto de filtro
	 * @param 	root		Objeto principal
	 * @param 	builder		Constructor de las consultas
	 * @return 	Predicate
	 */
	@SuppressWarnings("unchecked")
	protected static <E extends ObjectMap, Y extends java.sql.Date> Predicate prepareBetweenRange(
		UserFilter.ColumnFilter field, 
		SingularAttribute<E, Y> attribute,
		MapEntity 				filter, 
		Root<VOUser> 			root, 
		CriteriaBuilder 		builder ) 
	{
		RangeDate range = (RangeDate)filter.get(field);
		return builder.between(
			root.get((SingularAttribute<? super ObjectMap, Y>) attribute), 
			builder.literal( Utilities.toSqlDate( range.getBegin() )), 
			builder.literal( Utilities.toSqlDate( range.getEnd() ) ));
	}

	/**
	 * Prepara consulta criteria para coincidencias de cadena
	 * @param 	field		Campo asociado
	 * @param 	attribute	Instancia del atributo
	 * @param 	filter		Objeto de filtro
	 * @param 	root		Objeto principal
	 * @param 	builder		Constructor de las consultas
	 * @return	Predicate
	 */
	@SuppressWarnings("unchecked")
	protected static <E extends ObjectMap, Y> Predicate prepareLike(
		UserFilter.ColumnFilter field, 
		SingularAttribute<E, Y> attribute,
		MapEntity 				filter, 
		Root<VOUser> 			root, 
		CriteriaBuilder 		builder ) 
	{
		return builder.like(
		  (Expression<String>) root.get( (SingularAttribute<? super ObjectMap, Y>) attribute ), 
		  builder.lower( builder.concat(
			builder.concat(
				builder.literal("%"), 
				builder.literal( (String)filter.get( field ) ) ), 
				builder.literal("%") 
		  ) ) );
	}
}
