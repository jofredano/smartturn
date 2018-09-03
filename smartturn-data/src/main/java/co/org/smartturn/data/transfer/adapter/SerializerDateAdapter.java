package co.org.smartturn.data.transfer.adapter;

import java.io.Serializable;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import co.org.smartturn.utils.Utilities;

/***
 * Clase que toma un atributo serializable y lo trata a Date.
 * 
 * @author joseanor
 *
 */
public class SerializerDateAdapter extends XmlAdapter<String, Serializable> {

	@Override
	public Serializable unmarshal(String v) throws Exception {
		return Utilities.stringToDate("yyyy-MM-dd", v);
	}

	@Override
	public String marshal(Serializable v) throws Exception {
		return Utilities.dateToString("yyyy-MM-dd", (Date) v);
	}

}
