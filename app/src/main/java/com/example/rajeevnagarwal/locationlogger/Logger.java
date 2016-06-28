package com.example.rajeevnagarwal.locationlogger;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Logger extends AppCompatActivity implements LocationListener{

    TextView txt1,txt2,txt3,txt4,txt5;
    LocationManager locationManager;
    String provider;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

       /*if(provider!=null&&!provider.equals(""))*/
        {
            try {
                locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,0,this);
                Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                if (location != null) {
                    onLocationChanged(location);
                } else {
                    txt1.setText("0 kms from Pidilite Industries Limited");
                    txt2.setText("0 kms from Andheri Metro Station");
                    txt3.setText("0 kms from Shoppers Stop Andheri West");
                    txt4.setText("0 kms from AWHO, Sandeep Vihar");
                    txt5.setText("0 kms from Inox Forum Value Mall");


                }
            }
            catch(SecurityException e)
            {
                e.printStackTrace();
            }
        }
        /*else
            Toast.makeText(getBaseContext(),"No provider found",Toast.LENGTH_SHORT).show();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logger, menu);
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
    public void onLocationChanged(Location location)
    {
        txt1 = (TextView)findViewById(R.id.txt1);
        txt2 = (TextView)findViewById(R.id.txt2);
        txt3 = (TextView)findViewById(R.id.txt3);
        txt4 = (TextView)findViewById(R.id.txt4);
        txt5 = (TextView)findViewById(R.id.txt5);
        txt1.setText("");
        txt2.setText("");
        txt3.setText("");
        txt4.setText("");
        txt5.setText("");
        Location l1 = new Location("l1");
        Location l2 = new Location("l2");
        Location l3 = new Location("l3");
        Location l4 = new Location("l4");
        Location l5 = new Location("l5");
        l1.setLatitude(19.1154085);
        l1.setLongitude(72.7996527);
        l2.setLatitude(19.1206141);
        l2.setLongitude(72.7784506);
        l3.setLatitude(19.1152048);
        l3.setLongitude(72.7724454);
        l4.setLatitude(13.0224002);
        l4.setLongitude(77.7576474);
        l5.setLatitude(12.9594946);
        l5.setLongitude(77.6778495);
        if(!location.equals(l1)&&!location.equals(l2)&&!location.equals(l3)&&!location.equals(l4)&&!location.equals(l5))
        {
        txt1.setText("" + (location.distanceTo(l1) / 1000) + " kms from Pidilite Industries Limited");
        txt2.setText(""+(location.distanceTo(l2)/1000)+" kms from Andheri Metro Station");
        txt3.setText(""+(location.distanceTo(l3)/1000)+" kms from Shoppers Stop Andheri West");
        txt4.setText(""+(location.distanceTo(l4)/1000)+" kms from AWHO, Sandeep Vihar");
        txt5.setText(""+(location.distanceTo(l5)/1000)+" kms from Inox Forum Value Mall");
        }
        else if(location.equals(l1))
        {
            txt1.setText("You are at Pidlite Industries Limited");
        }
        else if(location.equals(l2))
        {
            txt1.setText("You are at Andheri Metro Station");
        }
        else if(location.equals(l3))
        {
            txt1.setText("You are at Shoppers Stop Andheri West");
        }
        else if(location.equals(l4))
        {
            txt1.setText("You are at AWHO, Sandeep Vihar");
        }
        else if(location.equals(l5))
        {
            txt1.setText("You are at Inox Forum Value Mall");
        }


            }
    @Override
    public void onProviderDisabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onProviderEnabled(String provider) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        // TODO Auto-generated method stub
    }

}
