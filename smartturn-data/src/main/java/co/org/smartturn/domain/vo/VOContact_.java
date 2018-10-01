package co.org.smartturn.domain.vo;

import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel(VOContact.class)
public class VOContact_ {
	public static volatile SingularAttribute<VOContact, Long> code;
	public static volatile SingularAttribute<VOContact, java.sql.Date> created;
	public static volatile SingularAttribute<VOContact, java.sql.Date> modified;
	public static volatile SingularAttribute<VOContact, Long> state;
	public static volatile SingularAttribute<VOContact, Long> creater;
	public static volatile SingularAttribute<VOContact, Long> modifier;
	public static volatile SingularAttribute<VOContact, Long> type;	
	public static volatile SingularAttribute<VOContact, String> identification;
	public static volatile SingularAttribute<VOContact, String> firstname;
	public static volatile SingularAttribute<VOContact, String> secondname;
	public static volatile SingularAttribute<VOContact, String> firstLastname;
	public static volatile SingularAttribute<VOContact, String> secondLastname;
	public static volatile SingularAttribute<VOContact, java.sql.Date> birth;
	public static volatile SingularAttribute<VOContact, java.util.List<VOReference>> references;
}