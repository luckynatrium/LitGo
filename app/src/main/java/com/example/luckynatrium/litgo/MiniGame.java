package com.example.luckynatrium.litgo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

class Answer{
    String Answer;
    boolean IsAnswer;
}
class Question{
    String Queston;
    Answer[] Answers;

}


public class MiniGame extends AppCompatActivity {
    public Question  CreateQuestion(String Quest, String[] Answrs,int A){
        Question Q =new Question();
        Q.Queston = Quest;
        Q.Answers = new Answer[4];
        Q.Answers[0].Answer = Answrs[0];
        Q.Answers[1].Answer = Answrs[1];
        Q.Answers[2].Answer = Answrs[2];
        Q.Answers[3].Answer = Answrs[3];
        Q.Answers[A].IsAnswer =true;
        return Q;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mini_game);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Question[] Questions = new Question[2];


        Questions[0] = CreateQuestion("Кто написал Еффгения Анегина?",new String[] {"Oleg","We","Gl","PP"},3);
        TextView txt = (TextView) findViewById(R.id.question);
        txt.setText(Questions[0].Queston);
    }

}
