package com.example.luckynatrium.litgo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {

    private int icons [];
    private String hero[];
    private Context context;
    private LayoutInflater inflater;

    public GridAdapter(Context context,int [] icons, String[] hero){
        this.context=context;
        this.icons=icons;
        this.hero=hero;
    }
    @Override
    public int getCount() {
        return hero.length;
    }

    @Override
    public Object getItem(int position) {
        return hero[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView =convertView;
        if (convertView ==null){
            inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView=inflater.inflate(R.layout.custom_layout,null);

        }
        ImageView icon = (ImageView)gridView.findViewById(R.id.icons);
        TextView hero=(TextView)gridView.findViewById(R.id.hero);

        icon.setImageResource(icons[position]);
        hero.setText(this.hero[position]);


        return gridView;
    }
}
