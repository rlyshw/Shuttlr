package rlyshw.com.shuttlr;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import trackr.Arrival;
import trackr.Trackr;


public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.setContext(this);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ((Spinner) findViewById(R.id.stopsSpinner)).setOnItemSelectedListener(new stopsSelectedListener(this));
        new TrackrInitTask().execute(spinner);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String route = parent.getItemAtPosition(position).toString();
        Toast.makeText(this, route, Toast.LENGTH_LONG).show();
        findViewById(R.id.pickStop).setVisibility(View.VISIBLE);
        ArrayAdapter stops = new ArrayAdapter(this,android.R.layout.simple_spinner_item);
        stops.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        stops.addAll(Trackr.getRoute(route).getStops()); //Going to have to select stops by routeId. Implement a getRoute() method.
        findViewById(R.id.stopsSpinner).setVisibility(View.VISIBLE);
        ((Spinner) findViewById(R.id.stopsSpinner)).setAdapter(stops);
    }

    public void setArrivals(ArrayList<Arrival> arrivals){
        TextView arrivalText = (TextView)findViewById(R.id.arrivalText);

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
