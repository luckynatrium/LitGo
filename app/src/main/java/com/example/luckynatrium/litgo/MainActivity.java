package com.example.luckynatrium.litgo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView_hw = (TextView)findViewById(R.id.main_hw);
        textView_hw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OpenQuizActivity();
            }
        });
    }

    private void OpenQuizActivity() {
        startActivity(new Intent(this, QuizActivity.class));
    }
}
