package co.org.smartturn.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.org.smartturn.business.UserBusiness;
import co.org.smartturn.data.model.User;
import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.services.UserServices;

/**
 * Objeto del servicio asociado a los usuarios. 
 * 
 * @author joseanor
 *
 */
@Service(value = "userServicesImpl")
public final class UserServicesImpl implements UserServices {
	
	/**
	 * Objeto de negocio para usuarios
	 */
	@Autowired
	@Qualifier("userBusinessImpl")
	private UserBusiness business;
	
	@Override
	public UserBusiness getBusiness() {
		return business;
	}

	@Override
	public Response<DTOUser> filter(MapEntity filter, Pageable paging) throws SystemException {
		return getBusiness().filter(filter, paging);
	}

	@Override
	public Response<DTOUser> filter(MapEntity filter) throws SystemException {
		return getBusiness().filter(filter);
	}

	@Override
	public boolean update(User<?> user) throws SystemException {
		return getBusiness().update(user);
	}

	@Override
	public Response<Access<java.util.Date>> access(Credential credential) throws SystemException {
		return getBusiness().access(credential);
	}

	@Override
	public Response<Integer> logout(Access<java.util.Date> credential) throws SystemException {
		return getBusiness().logout(credential);
	}

	@Override
	public Response<Integer> validate(Access<java.util.Date> credential) throws SystemException {
		return getBusiness().validate(credential);
	}

}
