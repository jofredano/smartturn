import { DTODocument, DTOReference } from './';

/**
 * Clase que contiene la información del contacto
 */
export class DTOContact {
	
	/**
	 * Fecha de creacion.
	 */
	private created: Date;

	/**
	 * Fecha de modificacion.
	 */
	private modified: Date;

	/**
	 * Fecha de nacimiento.
	 */
	private birth: Date;

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
	 * Tipo de contacto.
	 */
	private type: number;

	/**
	 * Identificacion del contacto.
	 */
	private identification: DTODocument;

	/**
	 * Primer nombre.
	 */
	private firstname: string;

	/**
	 * Segundo nombre.
	 */
	private secondname: string;

	/**
	 * Primer apellido.
	 */
	private firstLastname: string;

	/**
	 * Segundo apellido.
	 */
	private secondLastname: string;

	/**
	 * Referencias del contacto.
	 */
	private references: Array<DTOReference>;

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

	get _identification(): any {
		return this.identification;
	}

	set _identification(identification: any) {
		if(typeof(identification) == 'string') {  
		   identification   = DTODocument.valueOf(identification);	
		} 
		this.identification = identification;
	}

	get _firstname(): string {
		return this.firstname;
	}

	set _firstname(firstname: string) {
		this.firstname = firstname;
	}

	get _secondname(): string {
		return this.secondname;
	}

	set _secondname(secondname: string) {
		this.secondname = secondname;
	}

	get _firstLastname(): string {
		return this.firstLastname;
	}

	set _firstLastname(firstLastname: string) {
		this.firstLastname = firstLastname;
	}

	get _secondLastname(): string {
		return this.secondLastname;
	}

	set _secondLastname(secondLastname: string) {
		this.secondLastname = secondLastname;
	}

	get _birth(): Date {
		return this.birth;
	}

	set _birth(birth: Date) {
		this.birth = birth;
	}

	get _references(): Array<DTOReference> {
		return this.references;
	}

	set _references(references: Array<DTOReference>) {
		this.references = references;
	}

}