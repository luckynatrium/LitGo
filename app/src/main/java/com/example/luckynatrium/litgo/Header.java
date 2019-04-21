package com.example.luckynatrium.litgo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Header extends AppCompatActivity {

    private ImageView imageView1;
    private TextView text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.header);
        imageView1 = (ImageView) findViewById(R.id.imageView1);
        imageView1.setImageBitmap(Settings.selectedImage);
        text=(TextView) findViewById(R.id.TextView1);
        text.setText(Settings.sNickname);
    }

}

