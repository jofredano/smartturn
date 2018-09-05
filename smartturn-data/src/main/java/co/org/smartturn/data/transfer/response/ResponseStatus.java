package co.org.smartturn.data.transfer.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import co.org.smartturn.data.model.response.Result;

/**
 * Respuesta de estados transaccionales.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public class ResponseStatus implements Result<Integer> {

	private static final long serialVersionUID = 1L;

	/**
	 * Contenido de la respuesta entregada.
	 */
	protected ArrayList<Integer> content;
	
	/**
	 * Dimension de la respuesta.
	 */
	protected long size;
	
	/**
	 * Constructor de la clase
	 * @param content
	 */
	public ResponseStatus(Integer content) {
		this.size = 1;
		this.content = new ArrayList<>();
		this.content.add( content );
	}
	
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
