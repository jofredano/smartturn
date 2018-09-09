package co.org.smartturn.business.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import co.org.smartturn.business.UserBusiness;
import co.org.smartturn.data.model.User;
import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.model.security.Credential;
import co.org.smartturn.data.structure.MapEntity;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.Pageable;
import co.org.smartturn.data.transfer.response.ResponseAccess;
import co.org.smartturn.data.transfer.response.ResultUser;
import co.org.smartturn.data.transfer.security.DTOAccess;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.persistent.dao.UserDAO;
import co.org.smartturn.persistent.dao.security.AccessDAO;
import co.org.smartturn.persistent.vo.VOUser;
import co.org.smartturn.persistent.vo.security.VOAccess;
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

	/**
	 * Servicios de usuarios
	 */
	@Autowired
	@Qualifier("accessRepository")
	private AccessDAO control;
	

	@SuppressWarnings("unchecked")
	@Override
	public UserDAO getRepository() {
		return dao;
	}

	@Override
	public Result<DTOUser> filter(MapEntity filter, Pageable paging) throws SystemException {
		Result<DTOUser> response = new ResultUser();
		Result<VOUser> jpa = getRepository().filter(filter, paging);
		response.setContent( Utilities.toArray(jpa.getContent(), DTOUser.class) );
		response.setSize( jpa.getSize() );
		return response;
	}

	@Override
	public Result<DTOUser> filter(MapEntity filter) throws SystemException {
		return filter(filter, null);
	}

	@Override
	public boolean update(User<?> user) throws SystemException {
		return getRepository().update( (VOUser) user.map(VOUser.class, user) );
	}

	@Override
	public Response<DTOAccess> access(Credential credential) throws SystemException {
			VOAccess access = null;
			Response<DTOAccess> response = null;
			Result<VOAccess> result = null;
			java.util.Map<String, Serializable> data = null;
		try {
			data = control.checkUser(credential);
			if(data != null && data.size() > 0) {
			   access = new VOAccess();
			   access.setToken( (String)data.get("token") );
			   access.setEnd( (java.sql.Date)data.get("end") );
			   result = control.filter( access );
			   if(result != null && result.getSize() > 0) {
				  access = result.getContent().get(0);
				  access.setEnd( (java.sql.Date)data.get("end") );
				  access.getUser().setPassword( null );
				  response = new ResponseAccess( (DTOAccess)access.map(DTOAccess.class, null), 1 );   
			   }
			}
			return response;
		} finally {
			if(data != null) {
			   data  = null;
			}
			if(access != null) {
			   access = null;	
			}
			if(result != null) {
			   result = null;	
			}
			if(response != null) {
			   response = null;
			}
		}
	}

	@Override
	public Response<Integer> logout(Access<java.util.Date, DTOUser> credential) throws SystemException {
		//getRepository().logout(credential)
		return null;
	}

	@Override
	public boolean validate(Access<java.util.Date, DTOUser> credential) throws SystemException {
		return control.validate( (VOAccess) credential.map(VOAccess.class, credential) );
	}

}
