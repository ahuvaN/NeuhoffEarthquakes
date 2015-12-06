package neuhoff.geojson;


import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class EarthquakeAdapter extends PagerAdapter {

    private Features[] features;

    public EarthquakeAdapter(Features[] features) {
        this.features = features;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view = inflater.inflate(R.layout.earthquake_pager_item, null);

        TextView place = (TextView) view.findViewById(R.id.place);
        TextView mag = (TextView) view.findViewById(R.id.mag);
        TextView time = (TextView) view.findViewById(R.id.time);

        Properties property = features[position].getProperty();


        place.setText("CITY: ");
        place.append(property.getPlace());
        mag.setText("MAGNITUDE: ");
        mag.append(String.valueOf(property.getMag()));
        time.setText("TIME: ");
        time.append(property.getTime());

        container.addView(view);
        return view;
    }


    @Override
    public int getCount() {
        return features.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
