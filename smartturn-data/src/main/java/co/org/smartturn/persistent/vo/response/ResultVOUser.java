package co.org.smartturn.persistent.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.persistent.vo.VOUser;

/**
 * Respuesta con relacion al objeto de entidad usuario.
 * 
 * @author joseanor
 *
 */
public class ResultVOUser implements Result<VOUser> {

	private static final long serialVersionUID = 1L;
	
	private List<VOUser> content;

	private long size;
	
	@Override
	public List<VOUser> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<VOUser> content) {
		this.content = content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
