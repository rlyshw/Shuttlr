package rlyshw.com.shuttlr;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import trackr.Arrival;
import trackr.Stop;
import trackr.Trackr;

/**
 * Created by rlysh_000 on 5/5/2015.
 */
public class getArrivalsAsync extends AsyncTask<Void, Void, Boolean> {
    private ArrayList<Arrival> arrivals;
    private String route = "";
    private String stop = "";
    private MainActivity pAct;

    public getArrivalsAsync(MainActivity act){
        route = ((Spinner) act.findViewById(R.id.spinner)).getSelectedItem().toString();
        stop  = ((Spinner) act.findViewById(R.id.stopsSpinner)).getSelectedItem().toString();
        pAct = act;
    }

    @Override
    protected Boolean doInBackground(Void...params) {
        arrivals = Trackr.getRoute(route).getStop(stop).getArrivals();
        return !(arrivals.equals(null)||arrivals.isEmpty());
    }

    @Override
    protected void onPostExecute(Boolean result){
        if (result){
            TextView arrivalText = ((TextView)pAct.findViewById(R.id.arrivalText));
            arrivalText.setVisibility(View.VISIBLE);
            arrivalText.setText("Arrivals:");
            for(Arrival a : arrivals){
                arrivalText.setText(arrivalText.getText()+"\n"+a.toString());
            }
        }
    }


}
