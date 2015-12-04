package neuhoff.geojson;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class EarthquakeViewHolder extends RecyclerView.ViewHolder {

    private TextView name;

    //item view = president_list_item.xml
    public EarthquakeViewHolder(View itemView){
        super(itemView);
        name = (TextView) itemView.findViewById(R.id.name);
    }

    public void bind(Feature feature){
        StringBuilder sb = new StringBuilder();
        String place = feature.getProperty().getPlace();
        String[] split = place.split("");
        int length = split.length;
        sb.append(split[length - 1]);
        sb.append(split[length]);
        name.setText(sb.toString());
    }

}
