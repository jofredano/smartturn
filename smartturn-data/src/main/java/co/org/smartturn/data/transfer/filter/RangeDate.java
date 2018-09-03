package co.org.smartturn.data.transfer.filter;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import co.org.smartturn.data.model.filter.Range;
import co.org.smartturn.data.model.filter.TransformData;
import co.org.smartturn.data.transfer.adapter.DateAdapter;
import co.org.smartturn.exception.ConvertException;
import co.org.smartturn.utils.Utilities;

/**
 * Objeto usado para definir rangos de datos.
 * 
 * @author joseanor
 *
 */
@XmlRootElement
public final class RangeDate implements Range<java.util.Date> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Campo al que se le aplica el rango.
	 */
	@XmlTransient
	private String field;
	
	/**
	 * Representa el valor inicial
	 */
	@XmlElement(name = "begin")
	@XmlJavaTypeAdapter( DateAdapter.class )
	private final java.util.Date begin;
	
	/**
	 * Representa el valor final.
	 */
	@XmlElement(name = "end")
	@XmlJavaTypeAdapter( DateAdapter.class )
	private final java.util.Date end;

	//GETTERs AND SETTERs
	@Override
	public java.util.Date getBegin() {
		return begin;
	}

	@Override
	public java.util.Date getEnd() {
		return end;
	}
	
	@Override
	public String getField() {
		return field;
	}
	
	@Override
	public void setField(String field) {
		this.field = field;
	}
	
	@Override
	public String toString() {
		return "RangeData [field=" + field + ", begin=" + begin + ", end=" + end + "]";
	}

	@Override
	public String format(String expr, TransformData<java.util.Date> transform) throws ConvertException {
		if(Utilities.isEmpty(expr) || Utilities.isEmpty(transform)) {
		   return null;
		}
		return expr.replaceAll(field + ".begin", transform.convert(begin))
			       .replaceAll(field + ".end"  , transform.convert(end));
	}
	
	@Override
	public String format(String expr) throws ConvertException {
		return format(expr, String::valueOf);
	}
	
	/**
	 * Constructor de la clase.
	 * @param begin		Valor inicial
	 * @param end		Valor final
	 */
	public RangeDate(String field, java.util.Date begin, java.util.Date end) {
		this.field  = field;
		this.begin 	= begin;
		this.end 	= end;
	}
	
	/**
	 * Constructor de la clase.
	 */
	public RangeDate() {
		this(null, null, null);
	}

}
