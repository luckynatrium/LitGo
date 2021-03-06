package com.example.luckynatrium.litgo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.luckynatrium.litgo.model.DownloadFromFile;
import com.example.luckynatrium.litgo.model.QuizQuestion;
import com.example.luckynatrium.litgo.controller.QuizQuestionController;
import com.example.luckynatrium.litgo.model.RandomListIterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class QuizActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        //Хранение вопросов должно быть сделано по другому, но потом, тестирует QuizQuestionController
        /*final QuizQuestion q = new QuizQuestion(
                "В Гороховой улице, в одном из больших домов, народонаселения которого стало бы на целый уездный город, лежал утром в постели, на своей квартире, Илья Ильич Обломов",
                "Помню, как Ольга пела мне арию, от которой ощущается трепет по всему телу. Не споете ее для меня?",
                new ArrayList<QuizAnswer>(
                        Arrays.asList(
                                new QuizAnswer("Ария из «Пиковой дамы»", true),
                                new QuizAnswer("Casta Diva", false),
                                new QuizAnswer("Falstaff", false)
                        )
                )
        );*/
        DownloadFromFile downloader = new DownloadFromFile(this);
        final ArrayList<QuizQuestion> q = downloader.downloadQuestions("oblomov");
        final Iterator questions = new RandomListIterator(q);
        QuizQuestionController controller = new QuizQuestionController(
                (QuizQuestion) questions.next(), (TextView)findViewById(R.id.quiz_text_question),
                new ArrayList<Button>(Arrays.asList(
                        (Button)findViewById(R.id.quiz_button_answer_1),
                        (Button)findViewById(R.id.quiz_button_answer_2),
                        (Button)findViewById(R.id.quiz_button_answer_3)
                )));
        controller.setAnswerListener(new QuizQuestionController.AnswerListener() {
            @Override
            public void correctAnswer(QuizQuestionController questionController) {
                if(questions.hasNext())
                    questionController.changeQuestion((QuizQuestion)questions.next());
                else
                    Toast.makeText(QuizActivity.this, "Вопросы кончились", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void incorrectAnswer(QuizQuestionController questionController) {
                //Toast.makeText(QuizActivity.this, "Ответ неверный!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
