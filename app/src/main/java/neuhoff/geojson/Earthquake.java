package neuhoff.geojson;

import java.io.Serializable;

public class Earthquake implements Serializable{
    
    private Features[] features;

    public Features[] getFeatureArray(){
        return features;
    }

}
