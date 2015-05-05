package trackr;

import org.json.simple.JSONObject;

/**
 * Created by rlysh_000 on 5/5/2015.
 */
public class Arrival {
    private int minutes;
    public Arrival(JSONObject o){
        this.minutes = Integer.parseInt(o.get("Minutes").toString());
    }
    public int getMinutes(){
        return minutes;
    }
    public String toString(){
        return this.minutes+" minutes";
    }
}
