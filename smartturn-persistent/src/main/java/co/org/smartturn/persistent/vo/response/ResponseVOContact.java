package co.org.smartturn.persistent.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.persistent.vo.VOContact;

/**
 * Respuesta con relacion al objeto de entidad contactos.
 * 
 * @author joseanor
 *
 */
public class ResponseVOContact implements Response<VOContact> {
	
	private static final long serialVersionUID = 1L;
	
	private List<VOContact> content;

	private long size;
	
	@Override
	public List<VOContact> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<VOContact> content) {
		this.content = content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
