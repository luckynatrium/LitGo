package com.example.luckynatrium.litgo;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Lib_hero extends AppCompatActivity {

    GridView gridView;
    static int hero [] ={R.drawable.oblom,R.drawable.shtolc,R.drawable.olga,R.drawable.pshen,R.drawable.litgo_background,R.drawable.raskol,R.drawable.son,R.drawable.lugin,R.drawable.oldwoman,R.drawable.arkad};
    static String name_hero []={"Илья Обломов","Андрей Штольц","Ольга Ильинская","Агафья Пшеницына","Скрыто","Родион Раскольников","Соня Мармеладова","Петр Лужин","Старуха- процентщица","Аркадий       Свидригайлов"};
    static int lib [] ={R.drawable.oblom,R.drawable.shtolc,R.drawable.olga,R.drawable.pshen,R.drawable.zahar,R.drawable.raskol,R.drawable.son,R.drawable.lugin,R.drawable.oldwoman,R.drawable.arkad};
    static String lib_name_hero []={"Илья Обломов","Андрей Штольц","Ольга Ильинская","Агафья Пшеницына","Захар", "Родион Раскольников","Соня Мармеладова","Петр Лужин","Старуха- процентщица","Аркадий         Свидригайлов"};

    static int pos=0;
    static int count=9;
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
                if (name_hero[position]!="Скрыто") {
                    pos=position;
                    startActivity(new Intent(getApplicationContext(), About_hero.class));
                }
            }
        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

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

    static public int getPosition()
    {
        return pos;
    }

    static public int getAllCountHero(){return lib_name_hero.length;}
    static public int getMyCountHero(){return count;}
}
