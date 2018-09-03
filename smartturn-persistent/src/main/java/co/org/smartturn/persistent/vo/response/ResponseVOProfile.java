package co.org.smartturn.persistent.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.persistent.vo.VOProfile;

/**
 * Respuesta con relacion al objeto de entidad usuario.
 * 
 * @author joseanor
 *
 */
public class ResponseVOProfile implements Response<VOProfile> {

	private static final long serialVersionUID = 1L;
	
	private List<VOProfile> content;

	private long size;
	
	@Override
	public List<VOProfile> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<VOProfile> content) {
		this.content = content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
