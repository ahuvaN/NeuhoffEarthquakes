package neuhoff.geojson;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class EarthquakeRecyclerViewAdapter extends RecyclerView.Adapter<EarthquakeViewHolder> {

    private Earthquake earthquake;

    public EarthquakeRecyclerViewAdapter(Earthquake quake) {
        this.earthquake = quake;
    }

    @Override
    public EarthquakeViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View itemView = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.earthquake_list_item, parent, false);
        return new EarthquakeViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EarthquakeViewHolder holder, final int position) {
       // Properties property = new Properties();//earthquake.getFeatureArray()[position].getProperty();
        holder.bind(earthquake.getFeatureArray()[position].getProperty());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = holder.itemView.getContext();
                Intent intent = new Intent(context, EarthquakeDetail.class);
                intent.putExtra("FEATURES", earthquake.getFeatureArray());
                intent.putExtra("POSITION", position);
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return earthquake.getFeatureArray().length;
    }
}
