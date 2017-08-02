package myandoid.map;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in location
        LatLng mylocation = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(mylocation).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylocation));

        //add marker to location1
        LatLng mylocation1=new LatLng(28.2345,77.2345);
        mMap.addMarker(new MarkerOptions().position(mylocation1).title("Mine"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mylocation1));


        Location location=new Location("mylocation");
        location.setLatitude(-34);
        location.setLongitude(151);

        Location location1=new Location("mylocation1");
        location.setLatitude(28.2345);
        location.setLongitude(77.2345);

        float distance=location.distanceTo(location1);
        Toast.makeText(MapsActivity.this, ""+distance, Toast.LENGTH_SHORT).show();

        mMap.addPolyline(new PolylineOptions().add(mylocation).add(mylocation1).color(Color.RED).width(20)).isGeodesic();
    }
}