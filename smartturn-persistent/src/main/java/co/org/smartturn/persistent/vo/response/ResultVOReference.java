package co.org.smartturn.persistent.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.persistent.vo.VOReference;

/**
 * Respuesta con relacion al objeto de entidad referencias.
 * 
 * @author joseanor
 *
 */
public class ResultVOReference implements Result<VOReference> {
	
	private static final long serialVersionUID = 1L;
	
	private List<VOReference> content;

	private long size;
	
	@Override
	public List<VOReference> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<VOReference> content) {
		this.content = content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
