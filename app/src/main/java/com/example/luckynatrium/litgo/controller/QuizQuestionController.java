package com.example.luckynatrium.litgo.controller;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.luckynatrium.litgo.model.QuizAnswer;
import com.example.luckynatrium.litgo.model.QuizQuestion;

import java.util.ArrayList;
import java.util.Iterator;

public class QuizQuestionController {
    private QuizQuestion question;
    private TextView questionView;
    private ArrayList<Button> buttons;
    private AnswerListener answerListener;

    public QuizQuestionController(QuizQuestion question, TextView questionView, ArrayList<Button> buttons) {
        this.question = question;
        setQuestionView(questionView);
        setButtons(buttons);
    }

    public void changeQuestion(QuizQuestion newQuestion) {
        question = newQuestion;
        updateQuestionView();
        updateButtons();
    }

    public void setAnswerListener(AnswerListener answerListener) {
        this.answerListener = answerListener;
        //updateButtons();
    }

    private void setQuestionView(TextView textView) {
        this.questionView = textView;
        updateQuestionView();
    }
    private void updateQuestionView(){
        if(question!= null)
            questionView.setText(question.question);
        else
            questionView.setText("Упс, вопрос не обнаружен.");
    }
    private void setButtons(ArrayList<Button> buttons) {
        this.buttons = buttons;
        updateButtons();
    }

    private void updateButtons() {
        Iterator iAnswers = question.iterator();
        for(final Button button:buttons){
            button.setBackgroundColor(Color.WHITE);
            final QuizAnswer answer = (QuizAnswer)iAnswers.next();
            if(answer != null) {
                button.setText(answer.Answer);
                final QuizQuestionController me = this;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(answer.IsCorrect) {
                            view.setBackgroundColor(Color.GREEN);
                            if(answerListener!=null)
                                answerListener.correctAnswer(me);
                        }
                        else {
                            view.setBackgroundColor(Color.RED);
                            if (answerListener != null)
                                answerListener.incorrectAnswer(me);
                        }
                    }
                });
            } else
                button.setText("Кнопок больше, чем ответов");

        }
    }

    public static interface AnswerListener {
        public void correctAnswer(QuizQuestionController questionController);
        public void incorrectAnswer(QuizQuestionController questionController);
    }
}
