package com.example.luckynatrium.litgo;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.graphics.Bitmap;

import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

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
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        int count=Lib_hero.getAllCountHero();
        int mycount=Lib_hero.getMyCountHero();
        TextView txtmy=(TextView)findViewById(R.id.txt_profile_my);
        TextView txtall=(TextView)findViewById(R.id.txt_profile_all);
        txtall.setText("Количество пойманных героев : " + mycount);
        txtmy.setText("Количество героев : " + count);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }



}


