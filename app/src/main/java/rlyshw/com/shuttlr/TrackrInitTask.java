package rlyshw.com.shuttlr;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import org.json.simple.parser.ParseException;

import java.io.IOException;

import trackr.Route;
import trackr.Trackr;

/**
 * Created by rlysh_000 on 5/4/2015.
 */
public class TrackrInitTask extends AsyncTask<Spinner, Void, Boolean> {
    private Spinner spinner;
    @Override
    protected Boolean doInBackground(Spinner... params) {
        spinner = params[0];
        try {
            Trackr.init();
            return true;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
            return false;
        }
    }


    protected void onPostExecute(Boolean result){
        ArrayAdapter adapter = new ArrayAdapter(App.getContext(), android.R.layout.simple_spinner_item);
        for(Route r : Trackr.getRoutes()){
            if(r.isActive()){
                adapter.add(r);
            }
        }
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
    }
}
