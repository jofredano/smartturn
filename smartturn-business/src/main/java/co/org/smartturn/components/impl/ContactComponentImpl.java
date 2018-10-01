package co.org.smartturn.components.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.org.smartturn.components.ContactComponent;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOContact;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.response.ResultContact;
import co.org.smartturn.domain.vo.VOContact;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.persistent.jpa.ContactRepository;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto de negocio de contactos
 * 
 * @author joseanor
 *
 */
@Component(value = "contactComponent")
public class ContactComponentImpl implements ContactComponent {

	/**
	 * Servicios de usuarios
	 */
	@Autowired
	private ContactRepository dao;

	@Override
	public Result<DTOContact> filter(MapEntity filter, Pageable paging) throws SystemException {
		Result<DTOContact> response = new ResultContact();
		Iterable<VOContact> jpa = dao.findAll();
		response.setContent( Utilities.toArray(jpa, DTOContact.class) );
		return response;
	}

	@Override
	public Result<DTOContact> filter(MapEntity filter) throws SystemException {
		return filter(filter, null);
	}

	@Override
	public boolean update(DTOContact object) throws SystemException {
		return false;
	}

}
