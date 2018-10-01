package co.org.smartturn.domain.vo;

import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel(VOUser.class)
public class VOUser_ {
	public static volatile SingularAttribute<VOUser, Long> code;
	public static volatile SingularAttribute<VOUser, String> username;
	public static volatile SingularAttribute<VOUser, String> password;
	public static volatile SingularAttribute<VOUser, VOContact> contact;
	public static volatile SingularAttribute<VOUser, Long> state;
	public static volatile SingularAttribute<VOUser, java.sql.Date> created;
	public static volatile SingularAttribute<VOUser, java.sql.Date> modified;
}

