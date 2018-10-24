package com.example.luckynatrium.litgo.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;



public class QuizQuestion implements Iterable {

    ///Цитата, доказывающая правильность ответа
    public final String evidence;
    ///Сам вопрос
    public final String question;
    ///Варианты ответа
    private ArrayList<QuizAnswer> answers;


    public QuizQuestion(String evidence, String question, ArrayList<QuizAnswer> answers) {
        this.evidence = evidence;
        this.question = question;
        this.answers = answers;
    }





    @Override
    public Iterator iterator() {
        return new RandomListIterator<QuizAnswer>(answers);
    }
}
