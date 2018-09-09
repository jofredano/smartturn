package co.org.smartturn.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.org.smartturn.business.ContactBusiness;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOContact;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.response.ResultContact;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.persistent.dao.ContactDAO;
import co.org.smartturn.persistent.vo.VOContact;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto de negocio de contactos
 * 
 * @author joseanor
 *
 */
@Component(value = "contactBusinessImpl")
public class ContactBusinessImpl implements ContactBusiness {

	/**
	 * Servicios de usuarios
	 */
	@Autowired
	@Qualifier("contactRepository")
	private ContactDAO dao;


	@SuppressWarnings("unchecked")
	@Override
	public ContactDAO getRepository() {
		return dao;
	}

	@Override
	public Result<DTOContact> filter(MapEntity filter, Pageable paging) throws SystemException {
		Result<DTOContact> response = new ResultContact();
		Result<VOContact> jpa = getRepository().filter(filter, paging);
		response.setContent( Utilities.toArray(jpa.getContent(), DTOContact.class) );
		response.setSize( jpa.getSize() );
		return response;
	}

	@Override
	public Result<DTOContact> filter(MapEntity filter) throws SystemException {
		return filter(filter, null);
	}

	@Override
	public boolean update(DTOContact object) throws SystemException {
		return getRepository().update( (VOContact) object.map(VOContact.class, object) );
	}

}
