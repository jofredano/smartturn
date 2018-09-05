package co.org.smartturn.persistent.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.persistent.vo.security.VOAccess;

/**
 * Respuesta con relacion al objeto de entidad de accesos.
 * 
 * @author joseanor
 *
 */
public class ResultVOAccess implements Result<VOAccess> {
	
	private static final long serialVersionUID = 1L;
	
	private List<VOAccess> content;

	private long size;
	
	@Override
	public List<VOAccess> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<VOAccess> content) {
		this.content = content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
