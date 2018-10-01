package co.org.smartturn.domain.vo;

import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel(VOAccess.class)
public class VOAccess_ {
	public static volatile SingularAttribute<VOAccess, Long> code;
	public static volatile SingularAttribute<VOAccess, String> token;
	public static volatile SingularAttribute<VOAccess, java.sql.Date> begin;
	public static volatile SingularAttribute<VOAccess, java.sql.Date> end;
	public static volatile SingularAttribute<VOAccess, VOUser> user;
	public static volatile SingularAttribute<VOAccess, Long> duration;
}
