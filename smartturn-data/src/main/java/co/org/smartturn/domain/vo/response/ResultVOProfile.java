package co.org.smartturn.domain.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.domain.vo.VOProfile;

/**
 * Respuesta con relacion al objeto de entidad usuario.
 * 
 * @author joseanor
 *
 */
public class ResultVOProfile implements Result<VOProfile> {

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
