package myandoid.gps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements LocationListener {

    TextView textView, textView2,textView3;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView= (TextView) findViewById(R.id.textView);
        textView2= (TextView) findViewById(R.id.textView2);
        textView3= (TextView) findViewById(R.id.textView3);

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);


    }

    @Override
    public void onLocationChanged(Location location) {

        Double lat=location.getLatitude();
        Double log=location.getLongitude();

        textView.setText(""+lat);
        textView2.setText(""+log);

        Geocoder geocoder=new Geocoder(getApplicationContext(), Locale.ENGLISH);//used for changing lat and longi into address

        try {
           List<Address> myadd =  geocoder.getFromLocation(lat, log, 10);
            Address myfinaladdress= myadd.get(0);
            StringBuilder sb=new StringBuilder();
             for(int i=0;i<myfinaladdress.getMaxAddressLineIndex();i++){
                 sb.append(myfinaladdress.getAddressLine(i));
             }
            textView3.setText(""+sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {//work for concept 300m range etc

    }

    @Override
    public void onProviderEnabled(String provider) {
        Toast.makeText(this,"ON",Toast.LENGTH_LONG).show();

    }


    @Override
    public void onProviderDisabled(String provider) {
        Toast.makeText(MainActivity.this,"OFF",Toast.LENGTH_LONG).show();
    }
}
