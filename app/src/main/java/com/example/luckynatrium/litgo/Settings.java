package com.example.luckynatrium.litgo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Settings extends AppCompatActivity {


    private final int Pick_image = 1;
    public static String sNickname = "User name";
    public static final String APP_PREFERENCES = "mysettings";
    public static final String APP_PREFERENCES_NICKNAME = "nickname";
    public static final String APP_PREFERENCES_URI = "uri";
    public static SharedPreferences mSettings;
    final Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, Pick_image);
            }
        });


        Button bt = (Button) findViewById(R.id.prompt_button);
        bt.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {

                LayoutInflater li = LayoutInflater.from(context);
                View promptsView = li.inflate(R.layout.prompt, null);
                AlertDialog.Builder mDialogBuilder = new AlertDialog.Builder(context);
                mDialogBuilder.setView(promptsView);
                final EditText userInput = (EditText) promptsView.findViewById(R.id.input_text);
                mDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        sNickname = userInput.getText().toString();
                                        Toast.makeText(context, "Имя пользователя успешно изменено!", Toast.LENGTH_SHORT).show();

                                    }
                                })
                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();

                                    }
                                });

                AlertDialog alertDialog = mDialogBuilder.create();
                alertDialog.show();

            }
        });
        mSettings = getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);
        /*ActivityCompat.requestPermissions(Settings.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                1);*/


    }

   /* @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(Settings.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }*/


    //Uri uri = Uri.parse("android.resource://com.example.luckynatrium.litgo/res/drawable/ic_icons8_user.xml");
    public static Bitmap selectedImage;
    Uri imageUri;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch (requestCode) {
            case Pick_image:
                if (resultCode == RESULT_OK) {
                    try {
                        imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        selectedImage = BitmapFactory.decodeStream(imageStream);
                        Toast.makeText(context, "Аватарка изменена!", Toast.LENGTH_SHORT).show();

                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = mSettings.edit();
        editor.putString(APP_PREFERENCES_NICKNAME, sNickname);
        //editor.putString(APP_PREFERENCES_URI, imageUri.toString());
        editor.apply();

    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mSettings.contains(APP_PREFERENCES_NICKNAME)) {
            sNickname = mSettings.getString(APP_PREFERENCES_NICKNAME, "");
        }
        /*try {
            if (mSettings.contains(APP_PREFERENCES_URI)) {
                String strUri = mSettings.getString(APP_PREFERENCES_URI, "");
                Uri image = Uri.parse(strUri);
                selectedImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), image);
            }
        } catch (
                IOException e) {

        }*/
    }
}










