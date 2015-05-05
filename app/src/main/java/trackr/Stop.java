package trackr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class Stop {
    private int routeId;
    private int stopId;
    private double latitude;
    private double longitude;
    private String stopName;

    public Stop(int routeId, JSONObject o) {
        super();
        this.routeId = routeId;
        this.stopId = Integer.parseInt(o.get("ID").toString());
        this.latitude = Double.parseDouble(o.get("Latitude").toString());
        this.longitude = Double.parseDouble(o.get("Longitude").toString());
        this.stopName = o.get("Name").toString();

    }

    public double getLatitude() {
        return latitude;
    }
    public int getStopId(){
        return stopId;
    }
    public double getLongitude() {
        return longitude;
    }
    public String getStopName(){ return stopName; }
    public ArrayList<Arrival> getArrivals(){
        ArrayList<Arrival> arrivals = new ArrayList<>();
        JSONArray predictions = (JSONArray) Utils.URLtoJSONObject(
                "http://www.udshuttle.com/Route/"+this.routeId+"/Stop/"+this.getStopId()+"/Arrivals?customerID=10").get("Predictions");
        for(Object o : predictions){
            arrivals.add(new Arrival((JSONObject) o));
        };
        return arrivals;
    }

    @Override
    public String toString(){
        return this.getStopName();
    }
}
