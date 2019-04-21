package com.example.luckynatrium.litgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;


public class profile extends AppCompatActivity {

    private ImageView imageView;
    private TextView text;
    //private Bitmap selectedImage=new Bitmap().Settings.getSelectedImage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageView = (ImageView) findViewById(R.id.imageView1);
        imageView.setImageBitmap(Settings.selectedImage);
        text=(TextView) findViewById(R.id.TextView1);
        text.setText(Settings.sNickname);
    }



}


