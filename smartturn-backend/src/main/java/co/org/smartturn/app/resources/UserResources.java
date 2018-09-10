package co.org.smartturn.app.resources;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.org.smartturn.app.RestResources;
import co.org.smartturn.data.model.User;
import co.org.smartturn.data.transfer.DTOProfile;
import co.org.smartturn.data.transfer.filter.UserFilter;
import co.org.smartturn.data.transfer.security.DTOCredential;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.exception.data.Descriptor;
import co.org.smartturn.services.UserServices;

/**
 * Define los recursos disponibles para los usuarios
 * 
 * @author joseanor
 *
 */
@RestController 
@RequestMapping("/users")
public class UserResources extends RestResources {

	/**
	 * Servicios de usuarios
	 */
	@Autowired
	@Qualifier("userServicesImpl")
	private UserServices service;
	
    /**
     * Devuelve la version de la aplicacion
     * @return	Response
     */
	@RequestMapping( value = "/version",  method = RequestMethod.GET )
	@ResponseStatus( HttpStatus.OK )
    public String getVersion() {
    	return "1.0.0";
    }
	
    /**
     * Este recurso crea un usuario 
     * @param 	user		Informacion del usuario
     * @return	Response
     */
	@RequestMapping( value = "/create",  method = RequestMethod.PUT )
	@ResponseStatus( HttpStatus.OK )
    public ResponseEntity<Serializable> createUser(@RequestBody User<DTOProfile> user) {
		ResponseEntity<Serializable> response;
    	try {
			if(service.update(user)) {
				Descriptor descriptor = new Descriptor("OK", "Se creo cliente de manera satisfactoria");
            	response = ResponseEntity.ok().body(descriptor);
			} else {
            	Descriptor descriptor = new Descriptor("NOTF", "No se pudo crear el usuario");
            	response = ResponseEntity.ok().body(descriptor);
			}
			return response;
		} catch (SystemException e) {
            return ResponseEntity
            		.status( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body(e.getDefinition());
		}
    }
    
    /**
     * Permite consultar la informacion de los usuarios
     * @return	Response
     */
	@RequestMapping( value    = "/filter",  
					 method   = RequestMethod.POST, 
					 consumes = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Serializable> filterUser(@RequestBody UserFilter filter) {
    	try {
            return ResponseEntity
            		.ok()
                	.body(service.filter(filter));
		} catch (SystemException e) {
            return ResponseEntity
            		.status( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body(e.getDefinition());
		}
    }
    
    /**
     * Permite iniciar sesion a un usuario
     * @param 	credential	Informacin de credenciales
     * @return	Response
     */
	@RequestMapping( value     = "/login",  
					 method    = RequestMethod.POST, 
					 consumes  = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Serializable> login(@RequestBody DTOCredential credential) {
    	try {
            return ResponseEntity
            		.ok()
                	.body(service.access(credential));
		} catch (SystemException e) {
            return ResponseEntity
            		.status( HttpStatus.INTERNAL_SERVER_ERROR )
                    .body(e.getDefinition());
		}
	}

}
