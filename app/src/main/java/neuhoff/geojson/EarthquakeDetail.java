package neuhoff.geojson;


import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class EarthquakeDetail extends AppCompatActivity {

    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       setContentView(R.layout.activity_detail);

        int position = getIntent().getIntExtra("POSITION", 0);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        Features[] features = (Features[]) getIntent().getSerializableExtra("FEATURES");

        EarthquakeAdapter adapter = new EarthquakeAdapter(features);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(position);
    }
}
