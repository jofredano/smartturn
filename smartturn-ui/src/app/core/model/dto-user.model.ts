import { DTOProfile, DTOContact } from './';

/**
 * Clase que contiene la información del usuario
 */
export class DTOUser {

	/**
	 * Fecha de creacion.
	 */
	protected created: Date;

	/**
	 * Fecha de modificacion.
	 */
	protected modified: Date;
	
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
	 * Perfiles de este usuario.
	 */
	private profiles: Array<DTOProfile>;

	/**
	 * Informacion del propietario de la cuenta
	 */
	private contact: DTOContact;

	/**
	 * Clave del usuario
	 */
	private password: string;

	/**
	 * Nombre de usuario (alias)
	 */
	private username: string;


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

	set _state( state: number) {
		this.state = state;
	}

	get _creater(): number {
		return this.creater;
	}

	set _creater( creater: number ) {
		this.creater = creater;
	}

	get _modifier(): number {
		return this.modifier;
	}

	set _modifier(modifier: number) {
		this.modifier = modifier;
	}

	get _username(): string {
		return this.username;
	}

	set _username(username: string) {
		this.username = username;
	}

	get _password(): string {
		return this.password;
	}

	set _password(password: string) {
		this.password = password;
	}

	get _code(): number {
		return this.code;
	}

	set _code(code: number) {
		this.code = code;
	}

	get _contact(): DTOContact {
		return this.contact;
	}

	set _contact(contact: DTOContact) {
		this.contact = contact;
	}

	get _profiles(): Array<DTOProfile> {
		return this.profiles;
	}

	set _profiles(profiles: Array<DTOProfile>) {
		this.profiles = profiles;
	}
	
}