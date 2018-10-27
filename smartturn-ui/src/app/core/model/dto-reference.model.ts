/**
 * Clase que contiene la información de la referencia
 */
export class DTOReference {

	/**
	 * Fecha de creacion.
	 */
	private created: Date;

	/**
	 * Fecha de modificacion.
	 */
	private modified: Date;
	
	/**
	 * Estado del contacto.
	 */
	private state: number;

	/**
	 * Usuario que creo el contacto.
	 */
	private creater: number;

	/**
	 * Usuario que realizo la ultima modificacion.
	 */
	private modifier: number;

	/**
	 * Codigo unico del contacto.
	 */
	private code: number;

	/**
	 * Tipo de referencia.
	 */
	private type: number;

	/**
	 * Valor de la referencia
	 */
	private value: string;

	/**
	 * Si este contacto tiene preferencia.
	 */
	private preference: boolean;

	/**
	 * Categoria de la referencia.
	 */
	private category: number;
	
	/**
	 * Referencia del contacto
	 */
	private contact: number;
	
	get _created(): Date {
		return this.created;
	}

	set _created(created: Date) {
		this.created = created;
	}

	get _modified(): Date {
		return this.modified;
	}

	set _modified(modified: Date) {
		this.modified = modified;
	}

	get _state(): number {
		return this.state;
	}

	set _state(state: number) {
		this.state = state;
	}

	get _creater(): number {
		return this.creater;
	}

	set _creater(creater: number) {
		this.creater = creater;
	}

	get _modifier(): number {
		return this.modifier;
	}

	set _modifier(modifier: number) {
		this.modifier = modifier;
	}

	get _code(): number {
		return this.code;
	}

	set _code(code: number) {
		this.code = code;
	}

	get _type(): number {
		return this.type;
	}

	set _type(type: number) {
		this.type = type;
	}

	get _category(): number {
		return this.category;
	}

	set _category(category: number) {
		this.category = category;
	}

	get _preference(): boolean {
		return this.preference;
	}

	set _preference(preference: boolean) {
		this.preference = preference;
	}

	get _value(): string {
		return this.value;
	}

	set _value(value: string) {
		this.value = value;
	}

	get _contact(): number {
		return this.contact;
	}

	set _contact(contact: number) {
		this.contact = contact;
	}
}