package neuhoff.geojson;

import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class EarthquakeAsyncTask extends AsyncTask<String, Void, Boolean>{

    private RecyclerView recyclerView;
    private Earthquake earthquake;

    public EarthquakeAsyncTask(RecyclerView recyclerV) {
        recyclerView = recyclerV;
    }



    @Override
    protected Boolean doInBackground(String... params) {
        return connectToNetwork();
    }

    @Override
    //what to do when it completes the thread
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        //Features[] features = earthquake.getFeatureArray();
        EarthquakeRecyclerViewAdapter adapter = new EarthquakeRecyclerViewAdapter(earthquake);
        recyclerView.setAdapter(adapter);
    }

    public boolean connectToNetwork(){

        earthquake = null;
        try {
            URL url = new URL("http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/significant_month.geojson");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = connection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(in));

            Gson gson = new Gson();

            earthquake = gson.fromJson(br, Earthquake.class);
            return true;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
