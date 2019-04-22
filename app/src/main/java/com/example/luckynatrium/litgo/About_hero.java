package com.example.luckynatrium.litgo;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class About_hero extends AppCompatActivity {

    int hero [] ={R.drawable.oblom,R.drawable.shtolc,R.drawable.olga,R.drawable.pshen,R.drawable.zahar,R.drawable.raskol,R.drawable.son,R.drawable.lugin,R.drawable.oldwoman,R.drawable.arkad};
    String name_hero []={"Илья Обломов","Андрей Штольц","Ольга Ильинская","Агафья Пшеницына","Захар","Родион Раскольников","Соня Мармеладова","Петр Лужин","Старуха- процентщица","Аркадий Свидригайлов"};
    String status []={"Беспечный дворянин","Трудяга","Хорошенькая аристократка","«Чудо, а не хозяйка!»","«Рыцарь со страхом и упреком»", "Студент","Девушка, получившая «жёлтый билет»","Надворный советник","Старуха","Помещик"};
    String atributika []={"Халат, тапочки, диван","Мускулы","Фортепиано, вышивка","Пирамиды чулок, посуда и еда","Бакенбарды", "Топор","Крест и Евангелие","Мелкая душа","Деньги, вострые и злые глазки","Трость"};
    String doing []={"Лежит на диване","Делать капитал","Мечтает и торопится жить","Ухаживает за Обломовым","Отлынивает от работы", "Размышляет над своими жизненными решениями","Помогает ближним","Любуется собой","Процентщица","Преследует Дуню"};
    String osobnav []={"Звать Захара в любой непонятной ситуации","Cпасать Обломова из любых непонятных ситуаций","Поет лучше любой певицы","Всегда чем-то занята","Ломает все, к чему прикасается", "Умеет писать статьи, выдвигает теорию","Хорошо шьёт","Везде находит выгоду для себя","«Круглый год сидит ведьма, киснет»","Профессиональный шулер"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_hero);

        ImageView img=(ImageView)findViewById(R.id.img_about);
        TextView txt=(TextView)findViewById(R.id.txt_about);
        TextView txt1=(TextView)findViewById(R.id.status_about);
        TextView txt2=(TextView)findViewById(R.id.doing_about);
        TextView txt3=(TextView)findViewById(R.id.atributika_about);
        TextView txt4=(TextView)findViewById(R.id.osobnav_about);

        img.setImageResource(hero[Lib_hero.getPosition()]);
        txt.setText("Карта персонажа : "+name_hero[Lib_hero.getPosition()]);
        txt1.setText(status[Lib_hero.getPosition()]);
        txt2.setText(doing[Lib_hero.getPosition()]);
        txt3.setText(atributika[Lib_hero.getPosition()]);
        txt4.setText(osobnav[Lib_hero.getPosition()]);


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
}
