package co.org.smartturn.data.transfer.response;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.response.Response;
import co.org.smartturn.data.transfer.DTOUser;
import co.org.smartturn.data.transfer.structure.ObjectMap;

/**
 * Clase que controla respuestas de procesos.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public final class ResponseUser extends ObjectMap implements Response<DTOUser> {

	private static final long serialVersionUID = 1L;

	/**
	 * Contenido de la respuesta entregada.
	 */
	private List<DTOUser> content;
	
	/**
	 * Dimension de la respuesta.
	 */
	private long size;

	@Override
	public List<DTOUser> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<DTOUser> content) {
		this.content = content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}
	
}
