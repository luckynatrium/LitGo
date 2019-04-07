package com.example.luckynatrium.litgo;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class Lib_hero extends AppCompatActivity {

    GridView gridView;
    int hero [] ={R.drawable.oblom, R.drawable.raskol};
    String name_hero []={"Обломов", "Раскольников"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lib_hero);


        gridView = (GridView) findViewById(R.id.gridview_lib);
        GridAdapter adapter= new GridAdapter(Lib_hero.this,hero,name_hero);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Lib_hero.this,name_hero[position],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
