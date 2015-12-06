package neuhoff.geojson;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Properties implements Serializable{

    private double mag;
    private String place;
    private long time;

    public double getMag() {

        return mag;
    }

    public String getPlace() {

        return place;
    }

    public String getTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");//dd/MM/yyyy
        GregorianCalendar calendar = new GregorianCalendar(TimeZone.getTimeZone("US/Central"));

        calendar.setTimeInMillis(time);
        return sdf.format(calendar.getTime());

    }
}
