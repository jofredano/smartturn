package co.org.smartturn.data.transfer.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.response.Result;
import co.org.smartturn.data.model.security.Access;
import co.org.smartturn.data.transfer.DTOUser;

/**
 *  Clase que controla respuestas de procesos.
 *  
 * @author joseanor
 *
 */
@XmlRootElement
public final class ResultAccess implements Result<Access<java.util.Date, DTOUser>> {

	private static final long serialVersionUID = 1L;

	/**
	 * Contenido de la respuesta entregada.
	 */
	@XmlElementWrapper (name = "content")
    @XmlElement (name = "item")
	protected ArrayList<Access<java.util.Date, DTOUser>> content;
	
	/**
	 * Dimension de la respuesta.
	 */
	@XmlElement(name = "size")
	protected long size;

	
	@Override
	public List<Access<java.util.Date, DTOUser>> getContent() {
		return content;
	}

	@Override
	public long getSize() {
		return size;
	}

	@Override
	public void setContent(List<Access<java.util.Date, DTOUser>> content) {
		this.content = (ArrayList<Access<java.util.Date, DTOUser>>) content;
	}

	@Override
	public void setSize(long size) {
		this.size = size;
	}

}
