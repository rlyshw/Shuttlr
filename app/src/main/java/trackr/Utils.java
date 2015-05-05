package trackr;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class Utils {
    private Utils() {
    }


    private static JSONParser parser = new JSONParser();

    public static Reader read(String urlstr) throws IOException {
        URL url = new URL(urlstr);
        return new InputStreamReader(url.openStream());
    }

    public static JSONArray URLtoJSONArray(String urlstr) throws IOException, ParseException {
        JSONArray jArray = null;
        jArray = (JSONArray) parser.parse(read(urlstr));
        return jArray;
    }
    public static JSONObject URLtoJSONObject(String urlstr){
        JSONObject jObject = null;
        try {
            jObject = (JSONObject) parser.parse(read(urlstr));
        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
        return jObject;
    }
}
