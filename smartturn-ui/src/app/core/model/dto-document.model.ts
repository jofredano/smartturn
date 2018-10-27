/**
 * Clase que contiene la información del documento
 */
export class DTODocument {
	
	/**
	 * Define el tipo de documento
	 */
	private type: string;
	
	/**
	 * Define el numero del documento
	 */
	private digits: string;
	
	get _type(): string  {
		return this.type;
	}
	
	get _digits(): string {
		return this.digits;
	}
	
	set _type(type : string) {
		this.type = type;
	}
	
	set _digits(digits : string) {
		this.digits = digits;
	}
	
	/**
	 * Convierte string a documento
	 * @param 	value
	 * @return	Documento
	 */
	static valueOf(value: string): DTODocument {
		const parts = value.split("-");
		let type = null;
		let digits = null;
		if(parts != null && parts.length == 2) {
		   type = parts[0];	
		   digits = parts[1];
		} else {
		   type = "CC";
		   digits = value;
		}
		const document   = new DTODocument();
		document._type   = type;
		document._digits = digits;
		return document;
	}
	
} 