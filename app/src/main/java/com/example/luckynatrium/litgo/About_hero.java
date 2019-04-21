package com.example.luckynatrium.litgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class About_hero extends AppCompatActivity {

    int hero [] ={R.drawable.oblom,R.drawable.shtolc,R.drawable.raskol,R.drawable.son,R.drawable.lugin,R.drawable.oldwoman,R.drawable.arkad};
    String name_hero []={"Илья Обломов","Андрей Штольц","Родион Раскольников","Соня Мармеладова","Петр Лужин","Старуха- процентщица","Аркадий Свидригайлов"};
    String status []={"Беспечный дворянин","Трудяга", "Студент","Девушка, получившая «жёлтый билет»","Надворный советник","Старуха","Помещик"};
    String atributika []={"Халат, тапочки, диван","Мускулы", "Топор","Крест и Евангелие","Мелкая душа","Деньги, вострые и злые глазки","Трость"};
    String doing []={"Лежит на диване","Делать капитал", "Размышляет над своими жизненными решениями","Помогает ближним","Любуется собой","Процентщица","Преследует Дуню"};
    String osobnav []={"Звать Захара в любой непонятной ситуации","Cпасать Обломова из любых непонятных ситуаций", "Умеет писать статьи, выдвигает теорию","Хорошо шьёт","Везде находит выгоду для себя","«Круглый год сидит ведьма, киснет»","Профессиональный шулер"};

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
    }
}

//Статус:
//
//Деятельность: делать капитал
//
//Атрибутика: мускулы
//
//Особые навыки: спасать Обломова из любых непонятных ситуаций