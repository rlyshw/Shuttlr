package trackr;

import org.json.simple.JSONObject;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class Vehicle {
    private int vehicleId;
    private double latitude;
    private double longitude;

    public Vehicle(int routeId, JSONObject o) {
        this.vehicleId = Integer.parseInt(o.get("ID").toString());
        this.latitude = Double.parseDouble(o.get("Latitude").toString());
        this.longitude = Double.parseDouble(o.get("Longitude").toString());
    }
}
