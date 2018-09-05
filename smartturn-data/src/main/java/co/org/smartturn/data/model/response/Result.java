package co.org.smartturn.data.model.response;

import java.io.Serializable;
import java.util.List;

/**
 *  Clase que controla respuestas de procesos.
 * 
 * @author joseanor
 *
 */
public interface Result<T extends Serializable> extends Response<List<T>> {

}
