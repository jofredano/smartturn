/***
 * Clase que define un perfil de usuario.
 *
 */
export class DTOProfile {

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
	 * Codigo unico del usuario.
	 */
	private code: number;

	/**
	 * Role asociado al perfil.
	 */
	private role: number;
	
	
	get _created() {
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

	get _code() {
		return this.code;
	}

	set _code(code: number) {
		this.code = code;
	}

	get _role(): number {
		return this.role;
	}

	set _role(role: number) {
		this.role = role;
	}
}