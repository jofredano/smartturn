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
import org.springframework.web.bind.annotation.RestController;

import co.org.smartturn.app.RestResources;
import co.org.smartturn.app.services.ContactServices;
import co.org.smartturn.data.transfer.filter.ContactFilter;
import co.org.smartturn.exception.SystemException;

/**
 * Define los recursos disponibles para los contactos
 * 
 * @author joseanor
 *
 */
@RestController 
@RequestMapping("/smartservices/contacts")
public class ContactResources extends RestResources {
	
	/**
	 * Servicios de contactos
	 */
	@Autowired
	@Qualifier("contactServicesImpl")
	private ContactServices service;

    /**
     * Permite consultar la informacion de los contactos
     * @return	Response
     * @throws  SystemException 
     */
	@RequestMapping( value    = "/filter",  
					 method   = RequestMethod.POST, 
					 consumes = MediaType.APPLICATION_JSON_VALUE, 
					 produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Serializable> filterContact(@RequestBody ContactFilter filter) throws  SystemException {
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
	
}
