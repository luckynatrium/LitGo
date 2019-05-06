package com.example.luckynatrium.litgo;


import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.luckynatrium.litgo.SupportActivity.CurrentLocation;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback,OnLocationChangedListener {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupListener();

        drawerLayout =(DrawerLayout)findViewById(R.id.activity_main);
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open,R.string.close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    private void OpenQuizActivity() {
        startActivity(new Intent(this, QuizActivity.class));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (drawerToggle.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    public void openProfile(MenuItem item){
        startActivity(new Intent(this, profile.class));
    }

    public void openMap(MenuItem item){
        startActivity(new Intent(this, MainActivity.class));
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

        try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.mapstyle));

            if (!success) {
                Log.e("MapsActivity", "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e("MapsActivity", "Can't find style. Error: ", e);
        }

        // Add a marker in map
        LatLng rostov = new LatLng(47.2166667, 39.7166667);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(rostov)
                .zoom(15)
                .build();
        CameraUpdate cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition);
        googleMap.animateCamera(cameraUpdate);

        if (null != googleMap) {
            googleMap.addMarker(new MarkerOptions()
                    .position(rostov)
                    .title("AHAHAHHAHAHHA")
                    .draggable(false)
            );
        }
    }
    private void setupListener() {
        CurrentLocation mCurrentLocation = new CurrentLocation(this,this);
        mCurrentLocation.buildGoogleApiClient( this );
        mCurrentLocation.start();

    }
   /* public double calculateDistance() {
        double dX = mPoi .getPoiLatitude() - mMyLatitude;TODO добавить вычисление расстояния для героев
        double dY = mPoi .getPoiLongitude() - mMyLongitude;

        double distance = (Math. sqrt(Math.pow (dX, 2 ) + Math.pow(dY, 2 )) * 100000 );

        return distance;

    }*/

    @Override
    public void onLocationChanged(Location currentLocation) {

    }
}
