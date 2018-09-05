package co.org.smartturn.data.transfer.response;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.transfer.security.DTOAccess;

/**
 * Objeto de respuesta 
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public class ResponseAccess implements Response<DTOAccess> {

	private static final long serialVersionUID = 1L;

	/**
	 * Dimension de la respuesta.
	 */
	private DTOAccess content;
	
	/**
	 * Dimension de la respuesta.
	 */
	private long size;
	
	/**
	 * Constructor de la clase
	 * @param 	content		Contenido de la respuesta
	 * @param 	size		Cantidad de elementos
	 */
	public ResponseAccess(DTOAccess content, long size) {
		this.content = content;
		this.size = size;
	}
	
	/**
	 * Constructor de la clase
	 */
	public ResponseAccess() {
		this(null, 0);
	}

	@XmlElement(name = "content")
	@Override
	public DTOAccess getContent() {
		return content;
	}

	@Override
	public void setContent(DTOAccess content) {
		this.content = content;
	}

	@XmlElement(name = "size")
	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
