package co.org.smartturn.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.org.smartturn.business.UserBusiness;
import co.org.smartturn.data.model.User;
import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.response.ResponseUser;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.persistent.dao.UserDAO;
import co.org.smartturn.persistent.vo.VOUser;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto de negocio de usuarios
 * 
 * @author joseanor
 *
 */
@Component(value = "userBusinessImpl")
public class UserBusinessImpl implements UserBusiness {
	
	/**
	 * Servicios de usuarios
	 */
	@Autowired
	@Qualifier("userRepository")
	private UserDAO dao;


	@Override
	public UserDAO getRepository() {
		return dao;
	}

	@Override
	public Response<DTOUser> filter(MapEntity filter, Pageable paging) throws SystemException {
		Response<DTOUser> response = new ResponseUser();
		Response<VOUser> jpa = getRepository().filter(filter, paging);
		response.setContent( Utilities.toArray(jpa.getContent(), DTOUser.class) );
		response.setSize( jpa.getSize() );
		return response;
	}

	@Override
	public Response<DTOUser> filter(MapEntity filter) throws SystemException {
		return filter(filter, null);
	}

	@Override
	public boolean update(User<?> user) throws SystemException {
		return getRepository().update( (VOUser) user.map(VOUser.class, user) );
	}

	@Override
	public Response<Access<java.util.Date>> access(Credential credential) throws SystemException {
		//getRepository().access(credential)
		return null;
	}

	@Override
	public Response<Integer> logout(Access<java.util.Date> credential) throws SystemException {
		//getRepository().logout(credential)
		return null;
	}

	@Override
	public Response<Integer> validate(Access<java.util.Date> credential) throws SystemException {
		//getRepository().validate(credential)
		return null;
	}

}
