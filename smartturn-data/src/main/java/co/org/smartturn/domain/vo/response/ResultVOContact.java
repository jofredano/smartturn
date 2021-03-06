package co.org.smartturn.domain.vo.response;

import java.util.List;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.domain.vo.VOContact;

/**
 * Respuesta con relacion al objeto de entidad contactos.
 * 
 * @author joseanor
 *
 */
public class ResultVOContact implements Result<VOContact> {
	
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
