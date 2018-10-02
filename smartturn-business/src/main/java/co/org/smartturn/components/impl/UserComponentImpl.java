package co.org.smartturn.components.impl;

import java.io.Serializable;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import co.org.smartturn.components.UserComponent;
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
import co.org.smartturn.domain.vo.VOAccess;
import co.org.smartturn.domain.vo.VOUser;
import co.org.smartturn.exception.SystemException;
import co.org.smartturn.persistent.jpa.AccessRepository;
import co.org.smartturn.persistent.jpa.UserRepository;
import co.org.smartturn.persistent.jpa.nojpa.AccessDAO;
import co.org.smartturn.persistent.specification.UtilitiesSpecification;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto de negocio de usuarios
 * 
 * @author joseanor
 *
 */
@Component(value = "userBusinessImpl")
public class UserComponentImpl implements UserComponent {
	
	/**
	 * Servicios de usuarios
	 */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Servicios de usuarios
	 */
	@Autowired
	private AccessRepository accessRepository;
	
	/**
	 * Servicios de usuarios
	 */
	@Autowired
	private AccessDAO accessDao;


	@Override
	public Result<DTOUser> filter(MapEntity filter, Pageable paging) throws SystemException {
		Result<DTOUser> response = new ResultUser();
		java.util.List<VOUser> jpa = userRepository.findAll( UtilitiesSpecification.isQueryMap(filter) );
		response.setContent( Utilities.toArray(jpa, DTOUser.class) );
		response.setSize( jpa.size() );
		return response;
	}

	@Override
	public Result<DTOUser> filter(MapEntity filter) throws SystemException {
		return filter(filter, null);
	}

	@Override
	public boolean update(User<?> user) throws SystemException {
		return false;
	}

	@Override
	public Response<DTOAccess> access(Credential credential) throws SystemException {
		Response<DTOAccess> response = null;
		Map<String, Serializable> infoAccess = null;
		VOAccess access = null;
		infoAccess = accessDao.checkUser( credential );
		if(infoAccess != null && !infoAccess.isEmpty()) {
		   System.err.println("Acceso => " + accessRepository.checkAccessByToken( (String)infoAccess.get("token") ) );
		   access = accessRepository.getOneByToken( (String)infoAccess.get("token") );
		   if(access != null) {
			  response = new ResponseAccess( (DTOAccess)access.map(DTOAccess.class, null), 1 );   
		   }
		}
		return response;
	}

	@Override
	public Response<Integer> logout(Access<java.util.Date, DTOUser> credential) throws SystemException {
		//getRepository().logout(credential)
		return null;
	}

	@Override
	public boolean validate(Access<java.util.Date, DTOUser> credential) throws SystemException {
		return false;
	}

}
