package co.org.smartturn.data.transfer.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.transfer.DTOContact;

/**
 * Objeto de respuesta 
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public class ResultContact implements Result<DTOContact> {

	private static final long serialVersionUID = 1L;

	/**
	 * Contenido de la respuesta entregada.
	 */
	private List<DTOContact> content;
	
	/**
	 * Dimension de la respuesta.
	 */
	private long size;

	@Override
	public List<DTOContact> getContent() {
		return content;
	}

	@Override
	public void setContent(List<DTOContact> content) {
		this.content = content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
