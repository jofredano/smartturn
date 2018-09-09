package co.org.smartturn.data.transfer.fields;

import co.org.smartturn.data.structure.Field;

/**
 * Enumerador que contiene todos los campos relacionados 
 * con los objetos del sistema.
 * 
 * @author joseanor
 *
 */
public enum ColumnFields implements Field {
	//Campos de contacto
	CONTACT_FIRSTNAME  		( "contacto.primerNombre"    , false , "Primer nombre" ),
	CONTACT_SECONDNAME 		( "contacto.segundoNombre"   , false , "Segundo nombre" ),
	CONTACT_FIRSTLASTNAME 	( "contacto.primerApellido"  , false , "Primer apellido" ),
	CONTACT_SECONDLASTNAME 	( "contacto.segundoApellido" , false , "Segundo apellido" ),
	CONTACT_IDENTIFICATION 	( "contacto.identificacion"  , true  , "Documento de identidad" ),
	CONTACT_CODE 			( "contacto.codigo" 		 , true  , "Codigo del contacto" ),
	CONTACT_REFERENCES 		( "contacto.referencias"  	 , false , "Referencias del contacto" ),
	CONTACT_CREATED 		( "contacto.creado"  		 , false , "Fecha de creacion" ),
	CONTACT_CREATER 		( "contacto.creador"  		 , false , "Usuario creador" ),
	CONTACT_MODIFIED 		( "contacto.modificado"  	 , false , "Fecha de modificacion" ),
	CONTACT_MODIFIER 		( "contacto.modificador"  	 , false , "Usuario de ultima modificacion" ),
	CONTACT_TYPE 			( "contacto.tipo"  		 	 , false , "Tipo de contacto" ),
	CONTACT_BIRTHDAY 		( "contacto.nacimiento"  	 , false , "Fecha de nacimiento" ),
	CONTACT_STATE 			( "contacto.estado"  		 , false , "Estado del contacto"),
	//Campos del cliente
	CLIENT_CODE 			( "cliente.codigo" 			 , true  , "Codigo del cliente"),
	CLIENT_REFERENCE 		( "cliente.referencia"  	 , false , "Referencia del cliente"),
	CLIENT_CREATED 			( "cliente.creado"  		 , false , "Fecha de creacion" ),
	CLIENT_CREATER 			( "cliente.creador"  		 , false , "Usuario creador" ),
	CLIENT_MODIFIED 		( "cliente.modificado"  	 , false , "Fecha de modificacion" ),
	CLIENT_MODIFIER 		( "cliente.modificador"  	 , false , "Usuario de ultima modificacion" ),
	CLIENT_STATE 			( "cliente.estado"  		 , false , "Estado del cliente"),
	//Campos del usuario
	USER_CODE				( "usuario.codigo" 			 , true  , "Codigo del usuario"),
	USER_CONTACT 			( "usuario.contacto" 		 , false , "Contacto asociado al usuario") ,
	USER_NAME 				( "usuario.alias" 			 , false , "Alias del usuario") ,
	USER_PASSWD 			( "usuario.clave" 			 , false , "Clave del usuario") ,
	USER_STATE 				( "usuario.estado" 			 , false , "Estado del usuario") ,	
	USER_CREATED 			( "usuario.creado"  		 , false , "Fecha de creacion del usuario" ),
	USER_CREATER 			( "usuario.creador"  		 , false , "Usuario creador de este usuario" ),
	USER_MODIFIED 			( "usuario.modificado"  	 , false , "Fecha de modificacion al usuario" ),
	USER_MODIFIER 			( "usuario.modificador"  	 , false , "Usuario de ultima modificacion al usuario" ),
	USER_PROFILES 			( "usuario.perfiles"  		 , false , "Perfiles del usuario"),
	//Campos asociados a la referencia
	REFERENCE_CODE			( "referencia.codigo"  		 , true  , "Codigo de la referencia"),
	REFERENCE_TYPE 			( "referencia.tipo"  		 , false , "Tipo de referencia") ,
	REFERENCE_CATEGORY 	    ( "referencia.categoria"     , false , "Categoria de la referencia"),
	REFERENCE_VALUE 		( "referencia.valor"    	 , false , "Valor de la referencia"),
	REFERENCE_PREFERENCE    ( "referencia.preferencia"   , false , "Preferencia de la referencia"),
	REFERENCE_STATE 		( "referencia.estado" 		 , false , "Estado de la referencia") ,	
	REFERENCE_CREATED 		( "referencia.creado"  		 , false , "Fecha de creacion de la referencia" ),
	REFERENCE_CREATER 		( "referencia.creador"  	 , false , "Usuario creador de esta referencia" ),
	REFERENCE_MODIFIED 		( "referencia.modificado"  	 , false , "Fecha de modificacion a la referencia" ),
	REFERENCE_MODIFIER 		( "referencia.modificador"   , false , "Usuario de ultima modificacion a la referencia" ),
	//Campos relacionados con los perfiles de usuario
	PROFILE_CODE			( "perfil.codigo" 			 , true  , "Codigo del perfil"),
	PROFILE_STATE 			( "perfil.estado" 			 , false , "Estado del perfil") ,	
	PROFILE_CREATED 		( "perfil.creado"  		 	 , false , "Fecha de creacion del perfil" ),
	PROFILE_CREATER 		( "perfil.creador"  		 , false , "Usuario creador de este perfil" ),
	PROFILE_MODIFIED 		( "perfil.modificado"  	 	 , false , "Fecha de modificacion al perfil" ),
	PROFILE_MODIFIER 		( "perfil.modificador"  	 , false , "Usuario de ultima modificacion del perfil" ),
	PROFILE_ROLE 			( "perfil.rol" 				 , false , "Rol asociado a este perfil") ,
	//Campos del conductor (motorista)
	MOTORIST_CODE 			( "conductor.codigo" 		 , true  , "Codigo del conductor"),
	MOTORIST_CONTACT 		( "conductor.referencia"  	 , false , "Referencia del conductor"),
	MOTORIST_CREATED 		( "conductor.creado"  		 , false , "Fecha de creacion del conductor" ),
	MOTORIST_CREATER 		( "conductor.creador"  		 , false , "Usuario creador del conductor" ),
	MOTORIST_MODIFIED 		( "conductor.modificado"  	 , false , "Fecha de modificacion del conductor" ),
	MOTORIST_MODIFIER 		( "conductor.modificador"  	 , false , "Usuario de ultima modificacion del conductor" ),
	MOTORIST_STATE 			( "conductor.estado"  		 , false , "Estado del conductor"),
	MOTORIST_CLIENT 		( "conductor.cliente"        , false , "Cliente asociado al conductor" ),
	MOTORIST_TRANSPORT 		( "conductor.transportadora" , false , "Transportadora asociada al conductor"),
	//Campos para el acceso
	ACCESS_CODE 			( "acceso.codigo" 			 , true  , "Codigo unico"),
	ACCESS_USER 			( "acceso.usuario"   		 , false , "Usuario asociado al acceso"),
	ACCESS_BEGIN 			( "acceso.inicio"            , false , "Fecha de inicio del acceso"),
	ACCESS_END 				( "acceso.fin"               , false , "Fecha fin del acceso"),
	ACCESS_DURATION         ( "acceso.duracion"          , false , "Duracion del acceso"),
	ACCESS_TOKEN 			( "acceso.token"             , false , "Codigo de acceso")
	;
	
	/**
	 * Nombre del campo.
	 */
	private final String name;
	
	/**
	 * Descripcion del campo.
	 */
	private final String description;
	
	/**
	 * Indica si el campo si es identificador.
	 */
	private final boolean key;

	
	/**
	 * Constructor de enumerador
	 * @param 	name			Nombre del campo
	 * @param 	key				Indica si es clave
	 * @param 	description		Descripcion del campo
	 */
	private ColumnFields(
		String 	name, 
		boolean key, 
		String 	description) 
	{
		this.name 			= name;
		this.key 			= key;
		this.description	= description;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public boolean isKey() {
		return key;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
