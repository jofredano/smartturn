package co.org.smartturn.data.transfer.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.response.Response;

/**
 * Clase que controla respuestas de procesos.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public final class ResponseProcess implements Response<Integer> {

	private static final long serialVersionUID = 1L;

	/**
	 * Contenido de la respuesta entregada.
	 */
	@XmlElementWrapper (name = "content")
    @XmlElement (name = "item")
	protected ArrayList<Integer> content;
	
	/**
	 * Dimension de la respuesta.
	 */
	@XmlElement(name = "size")
	protected long size;

	
	@Override
	public List<Integer> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<Integer> content) {
		this.content = (ArrayList<Integer>) content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
