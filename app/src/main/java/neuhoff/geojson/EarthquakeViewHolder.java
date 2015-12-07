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

    public void bind(Properties property){
        StringBuilder sb = new StringBuilder();
        String place = property.getPlace();
        String[] split = place.split(" ");
        int length = split.length;
        int i = 0;
        if (split[2].equalsIgnoreCase("of")){
            i = 3;
        }
        while (i < length){
            sb.append(split[i]);
            sb.append(" ");
            i++;
        }
        place = sb.toString();
        name.setText(place);
    }

}
