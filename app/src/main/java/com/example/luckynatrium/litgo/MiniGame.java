package com.example.luckynatrium.litgo;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;




public class MiniGame extends AppCompatActivity implements View.OnClickListener{
    Button[] Answers;
    boolean GameOver;
    int NumberOfQuestion;
    Question[] Questions = new Question[4];
    TextView txt;


    public static boolean EndOfGame;
    public static boolean ONCLICK;

    public class Answer{
        String Answer;
        boolean IsAnswer;
        Answer(String answer, boolean isAnswer){
            this.Answer=answer;
            this.IsAnswer=isAnswer;
        }
    }
    public class Question{
        String Queston;
        Answer[] Answers;

    }

    public TextView timer;

   public Question  CreateQuestion(String Quest, String[] Ans,int A){
        Question Q =new Question();
        Q.Queston = Quest;
        Q.Answers = new Answer[4];
        for (int i = 0;i<4;i++)
            if(i == A)Q.Answers[i] = new Answer(Ans[i],true);
                else Q.Answers[i] = new Answer(Ans[i],false);

        return Q;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        EndOfGame = false;
        ONCLICK = false;

        //Ввод вопросов
        Questions[0] = CreateQuestion("Кто написал Еффгения Анегина?",new String[] {"Oleg","Ольга","Евгений","Еффгений"},2);
        Questions[1] = CreateQuestion("Как зовут Обломова?",new String[]{"Илья", "Олег","Василий","Артем"},0);
        Questions[2] = CreateQuestion("Куда был сослан Лермонтов за сочинение стихотворения «Смерть поэта»?",new String[] {"Закавказье","на Юг, в Одессу","Сибирь","Чалтырь"},0);
        Questions[3] = CreateQuestion("В каком театре впервые была поставлена комедия Гоголя «Ревизор»?",new String[]{"Александрийский театр в Петербурге", "БДТ им. Товстоногова, Петербург","МХАТ в Москве","МЕХМАТ 120 ауд."},0);

        // установка ссылок на данные
        Answers = new Button[4];
        Answers[0]  = (Button) findViewById(R.id.answer1);
        Answers[1]  = (Button)findViewById(R.id.answer2);
        Answers[2]  = (Button)findViewById(R.id.answer3);
        Answers[3]  = (Button)findViewById(R.id.answer4);
        txt = (TextView) findViewById(R.id.question);
        timer = findViewById(R.id.timer);
        Answers[0].setOnClickListener(this);
        Answers[1].setOnClickListener(this);
        Answers[2].setOnClickListener(this);
        Answers[3].setOnClickListener(this);

        proceedQuiz(0);
        /*for(Question Lit:Questions) {

            GameOver = false;
            txt.setText(Lit.Queston);
            Answers[0].setText(Lit.Answers[0].Answer);
            Answers[1].setText(Lit.Answers[1].Answer);
            Answers[2].setText(Lit.Answers[2].Answer);
            Answers[3].setText(Lit.Answers[3].Answer);
            new CountDownTimer(6000,1000){
                @Override
                public void onTick(long l){
                    timer.setText(l/1000+"");
                }
                @Override
                public void onFinish(){
                timer.setText("you lose");

                }
            }.start();

        }*/
    }

    public void proceedQuiz (final int numberOfQuestion)
    {

        Question Lit = new Question();
      //  Log.d("DEBUG_QUESTION","num of ... is: " + numberOfQuestion);
        if (numberOfQuestion<Questions.length & !GameOver) {

        Lit = Questions[numberOfQuestion];
    } else {
        Log.d("DEBUG_QUESTION","OUTOFBOUND");
            timer.setText("you lose");
        return;
    }
       Answers[0].setBackgroundColor(Color.parseColor("#ff0a3d62"));
        Answers[1].setBackgroundColor(Color.parseColor("#ff0a3d62"));
        Answers[2].setBackgroundColor(Color.parseColor("#ff0a3d62"));
        Answers[3].setBackgroundColor(Color.parseColor("#ff0a3d62"));

        Answers[0].setTextColor(Color.WHITE);
        Answers[1].setTextColor(Color.WHITE);
        Answers[2].setTextColor(Color.WHITE);
        Answers[3].setTextColor(Color.WHITE);

        GameOver = false;
        txt.setText(Lit.Queston);
        Answers[0].setText(Lit.Answers[0].Answer);
        Answers[1].setText(Lit.Answers[1].Answer);
        Answers[2].setText(Lit.Answers[2].Answer);
        Answers[3].setText(Lit.Answers[3].Answer);
        new CountDownTimer(60000,1000){
            @Override
            public void onTick(long l){
                if(ONCLICK) {
                    ONCLICK = false;
                    onFinish();}
                timer.setText(l/1000+"");
                Log.d("DEBUG_QUESTION","IS ANSWER: "+GameOver);
            }
            @Override
            public void onFinish(){



                   proceedQuiz(NumberOfQuestion);

                   // timer.setText("you lose");



            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.answer1:
                // do your code

                Log.d("DEBUG_QUESTION","IS ANSWER: "+Questions[NumberOfQuestion].Answers[0].IsAnswer);
                ONCLICK= true;
                v.setBackgroundColor(Color.WHITE);
                ((TextView)v).setTextColor(Color.BLACK);

                if(Questions[NumberOfQuestion].Answers[0].IsAnswer) {
                    v.setBackgroundColor(Color.rgb(39, 174, 96));
                    ((TextView)v).setTextColor(Color.rgb(20, 51, 6));
                    NumberOfQuestion++;
                }
                else {
                    GameOver = true;
                    v.setBackgroundColor(Color.rgb(231, 76, 60));
                    ((TextView)v).setTextColor(Color.rgb(50, 10, 24));
                }

                break;

            case R.id.answer2:
                // do your code
                Log.d("DEBUG_QUESTION","IS ANSWER: "+Questions[NumberOfQuestion].Answers[1].IsAnswer);

                ONCLICK= true;
                v.setBackgroundColor(Color.WHITE);
                ((TextView)v).setTextColor(Color.BLACK);

                if(Questions[NumberOfQuestion].Answers[1].IsAnswer) {
                    v.setBackgroundColor(Color.rgb(39, 174, 96));
                    ((TextView)v).setTextColor(Color.rgb(20, 51, 6));
                    NumberOfQuestion++;
                }
                else {
                    GameOver = true;
                    v.setBackgroundColor(Color.rgb(231, 76, 60));
                    ((TextView)v).setTextColor(Color.rgb(50, 10, 24));
                }

                break;

            case R.id.answer3:
                // do your code
                Log.d("DEBUG_QUESTION","IS ANSWER: "+Questions[NumberOfQuestion].Answers[2].IsAnswer);
                ONCLICK= true;
                v.setBackgroundColor(Color.WHITE);
                ((TextView)v).setTextColor(Color.BLACK);

                if(Questions[NumberOfQuestion].Answers[2].IsAnswer) {
                    v.setBackgroundColor(Color.rgb(39, 174, 96));
                    ((TextView)v).setTextColor(Color.rgb(20, 51, 6));
                    NumberOfQuestion++;
                }
                else {
                    GameOver = true;
                    v.setBackgroundColor(Color.rgb(231, 76, 60));
                    ((TextView)v).setTextColor(Color.rgb(50, 10, 24));
                }

                break;

            case R.id.answer4:
                Log.d("DEBUG_QUESTION","IS ANSWER: "+Questions[NumberOfQuestion].Answers[3].IsAnswer);
                ONCLICK= true;
                v.setBackgroundColor(Color.WHITE);
                ((TextView)v).setTextColor(Color.BLACK);

                if(Questions[NumberOfQuestion].Answers[3].IsAnswer) {
                    v.setBackgroundColor(Color.rgb(39, 174, 96));
                    ((TextView)v).setTextColor(Color.rgb(20, 51, 6));
                    NumberOfQuestion++;
                }
                else {
                    GameOver = true;
                    v.setBackgroundColor(Color.rgb(231, 76, 60));
                    ((TextView)v).setTextColor(Color.rgb(50, 10, 24));
                }

                break;

            default:
                break;
        }


    }


}
