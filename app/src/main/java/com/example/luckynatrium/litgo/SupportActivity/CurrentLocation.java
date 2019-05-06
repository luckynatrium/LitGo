package com.example.luckynatrium.litgo.SupportActivity;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.luckynatrium.litgo.OnLocationChangedListener;
import com.example.luckynatrium.litgo.R;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.LocationSource;

import static android.support.v4.app.ActivityCompat.startActivityForResult;

public class CurrentLocation implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, LocationListener {
    private Activity currentActivity;
    private GoogleApiClient mGoogleApiClient;
    private Location mLastLocation;
    private LocationRequest mLocationRequest;
    private OnLocationChangedListener onLocationChangedListener;

    private final int REQUEST_LOCATION_PERMISSION = 1;

    //передаем интерфейс OnLocationChangedListener в конструкторе для организации
//прослушивания события смены местоположения
    public CurrentLocation(OnLocationChangedListener onLocationChangedListener, Activity curActivity) {
        this.onLocationChangedListener = onLocationChangedListener;
        currentActivity = curActivity;
    }

    /**
     * Создает GoogleApiClient. Использует метод { @code #addApi} для запроса
     * LocationServices API.
     */
    public synchronized void buildGoogleApiClient(Context context) {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
//создаем запрос и устанавливаем интервал для его отправки
        mLocationRequest = LocationRequest.create()
                .setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY)
                .setInterval(10 * 1000)        // 10 seconds, in milliseconds
                .setFastestInterval(1 * 1000); // 1 second, in milliseconds
    }

    public void start() {
        //Подключает клиента к службам Google Play.
        mGoogleApiClient.connect();
    }

    public void stop() {
        //Закрывает подключение к службам Google Play.
        mGoogleApiClient.disconnect();
    }

    //После вызова connect(), этот метод будет вызываться асинхронно после успешного завершения запроса подключения.
    @Override
    public void onConnected(Bundle bundle) {

        checkPermission();

        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
            mLastLocation = LocationServices.FusedLocationApi .getLastLocation(
                    mGoogleApiClient);
            if ( mLastLocation != null ) {
                onLocationChangedListener.onLocationChanged( mLastLocation );
            }
        }
        //Вызывается, когда клиент временно в отключенном состоянии.
        @Override
        public void onConnectionSuspended( int i) {

        }
        //Вызывается, когда произошла ошибка при подключении клиента к службе.
        @Override
        public void onConnectionFailed(ConnectionResult connectionResult) {
            Log.e( "MyApp" , "Location services connection failed with code " + connectionResult.getErrorCode());
        }
        /*
         * Реализуем метод onLocationChanged интерфейса LocationListener. Обратный вызов,
    который возникает, когда изменяется местоположение.
         * Здесь создаем объект mLastLocation, который хранит последнее местоположение и передаем его в методе интерфейса.
         */
        @Override
        public void onLocationChanged(Location location) {
            checkPermission();
            mLastLocation = LocationServices.FusedLocationApi .getLastLocation(
                    mGoogleApiClient);
            if ( mLastLocation != null ) {
                onLocationChangedListener.onLocationChanged( mLastLocation );
            }
        }

       public boolean checkPermission()
        {
            if (ContextCompat.checkSelfPermission(currentActivity, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(currentActivity,
                        Manifest.permission.ACCESS_FINE_LOCATION)) {
                    Toast.makeText(currentActivity, "Это для карты надо", Toast.LENGTH_LONG).show();
                } else {
                    ActivityCompat.requestPermissions(currentActivity,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                            REQUEST_LOCATION_PERMISSION);
                }
                return false;
            }
            else
                return true;
        }

    }


