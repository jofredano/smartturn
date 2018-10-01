package co.org.smartturn.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.org.smartturn.app.services.ContactServices;
import co.org.smartturn.components.ContactComponent;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOContact;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.exception.SystemException;

/**
 * Objeto del servicio asociado a los contactos. 
 * 
 * @author joseanor
 *
 */
@Service(value = "contactServicesImpl")
public class ContactServicesImpl implements ContactServices {

	/**
	 * Objeto de negocio para usuarios
	 */
	@Autowired
	@Qualifier("contactComponent")
	private ContactComponent business;


	@Override
	public ContactComponent getBusiness() {
		return business;
	}

	@Override
	public Result<DTOContact> filter(MapEntity filter, Pageable paging) throws SystemException {
		return getBusiness().filter(filter, paging);
	}

	@Override
	public Result<DTOContact> filter(MapEntity filter) throws SystemException {
		return getBusiness().filter(filter);
	}

	@Override
	public boolean update(DTOContact object) throws SystemException {
		return getBusiness().update(object);
	}

}
