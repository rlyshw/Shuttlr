package rlyshw.com.shuttlr;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import trackr.Trackr;

/**
 * Created by rlysh_000 on 5/5/2015.
 */
public class stopsSelectedListener extends MainActivity implements AdapterView.OnItemSelectedListener {
    private MainActivity parentActivity;

    public stopsSelectedListener(MainActivity mainActivity){
        parentActivity = mainActivity;
        //((TextView)mainActivity.findViewById(R.id.arrivalText)).setText("Monkey Sauce!");
        Log.e("I","stops Constructed");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        new getArrivalsAsync(parentActivity).execute();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
