package trackr;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class Route {
    private int routeId;
    private String color;
    private String name;
    private String textColor;

    private ArrayList<Stop> stops = new ArrayList<>();

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    public int getRouteId() {
        return routeId;
    }
    public String getColor() {
        return color;
    }
    public String getName() {
        return name;
    }
    public String getTextColor() {
        return textColor;
    }
    public ArrayList<Stop> getStops() {
        return stops;
    }
    public Route(){}
    public Route(JSONObject o) throws IOException, ParseException {
        this.routeId = Integer.parseInt(o.get("ID").toString());
        this.color = o.get("Color").toString();
        this.name = o.get("Name").toString();
        this.textColor = o.get("TextColor").toString();
        for(Object p : Utils.URLtoJSONArray("http://www.udshuttle.com/Route/" + this.routeId + "/Direction/0/Stops")){
            stops.add(new Stop(routeId, (JSONObject) p));
        }
        for(Object q : Utils.URLtoJSONArray("http://www.udshuttle.com/Route/"+this.routeId+"/Vehicles")){
            vehicles.add(new Vehicle(routeId, (JSONObject) q));
        }
    }
    public boolean isActive(){
        return vehicles.size()!=0;
    }
    @Override
    public String toString(){
        return this.getName();
    }

    public Stop getStop(String stop) {
        for(Stop s : stops){
            if(s.getStopName()==stop){
                return s;
            }
        }
        return null;
    }
}
