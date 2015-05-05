package trackr;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class Trackr {
    public static ArrayList<Route> getRoutes() {
        return routes;
    }

    private static ArrayList<Route> routes = new ArrayList<>();
    private static JSONParser parser = new JSONParser();
    private static String routeURL = "http://www.udshuttle.com/Region/0/Routes";

    public static void init() throws IOException, ParseException {
        for(Object o : Utils.URLtoJSONArray(routeURL)){
            routes.add(new Route((JSONObject) o));
        }
    }

    public static Route getRoute(String str){
        // Searches for a route by name
        for(Route r : routes){
            if (r.getName()==str){
                return r;
            }
        }
        return null;
    }
}
