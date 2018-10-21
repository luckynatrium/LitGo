package com.example.luckynatrium.litgo.model;

import java.util.ArrayList;

public class QuizQuestion {

    ///Цитата, доказывающая правильность ответа
    private String evidence;
    ///Сам вопрос
    private String question;
    ///Верный ответ
    private String  correctAnswer;
    ///Другие варианты ответа
    private ArrayList<String> incorrectAnswers;


}
