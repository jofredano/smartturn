package co.org.smartturn.data.transfer.adapter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * Esta clase se usara para convertir String en fecha cuando se necesite
 * 
 * @author joseanor
 *
 */
public class DateAdapter extends XmlAdapter<String, Date> {
	
	/**
	 * Instancia ara control de hilos
	 */
    private static final ThreadLocal<DateFormat> THREADS = ThreadLocal.<DateFormat>withInitial
    		(() -> new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss") );
	
    @Override
    public Date unmarshal(String v) throws Exception {
        return THREADS.get().parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return THREADS.get().format(v);
    }

}


