package co.org.smartturn.definitions.database.sql;

/**
 * Se definio este objeto enumerador para indicar cuando
 * el tipo de instruccion es JPA o NATIVA. 
 * 
 * @author joseanor
 *
 */
public enum InstructionType {
	JPA("JPA", "Instrucciones tipo JPA"),
	NATIVE("NATIVE", "Instrucciones tipo nativas"),
	STOREPROCEDURE("STORE_PROCEDURE","Instrucciones para invocar procedimientos"),
	SQLQUERY("SQLQuery", "Instrucciones para invocar SQL Query (Criteria)");

	/**
	 * Codigo del enumerador
	 */
	private final String code;
	
	/**
	 * Descripcion del enumerador.
	 */
	private final String description;
	
	/**
	 * Constructor del enumerador
	 * @param code			Codigo del enumerador
	 * @param description	Descripcion del enumerador
	 */
	private InstructionType(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
}
