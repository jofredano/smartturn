package co.org.smartturn.app.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.org.smartturn.app.RestResources;
import co.org.smartturn.services.ContactServices;

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

}
