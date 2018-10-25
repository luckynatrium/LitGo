package com.example.luckynatrium.litgo.model;

import android.content.Context;
import android.content.res.Resources;

import com.example.luckynatrium.litgo.R;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DownloadFromFile {

    private final String FILE_NAME="file";

    public Context context;

    public DownloadFromFile(Context context) {
        this.context=context;
    }

    public ArrayList<QuizQuestion> downloadQuestions(String filename){

        try{
            InputStream inputStream = context.getResources().openRawResource(getIndent(filename));
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String str="";
            ArrayList<QuizQuestion> questions = new ArrayList<>();
            QuizQuestionPrototype prototype = new QuizQuestionPrototype();
            while((str=br.readLine())!=null){ //Вопросы разделяем пустой строкой
                switch(str.charAt(0)) {
                    case 'Q':
                        prototype.question = str.substring(2);
                        break;
                    case 'C':
                        prototype.answers.add(new QuizAnswer(str.substring(2), true));
                        break;
                    case 'W':
                        prototype.answers.add(new QuizAnswer(str.substring(2), false));
                        break;
                    case 'E':
                        prototype.evidence = str.substring(2);
                        break;
                    case '{':
                        prototype.reset();
                        break;
                    case '}':
                        questions.add(prototype.getResult());
                        break;
                }
            }
            return questions;
        }//Замалчивать исключение нехорошо
        catch (java.io.IOException fe){
            fe.printStackTrace();
            return null;//new QuizQuestion("error","Invalid question download",new ArrayList<QuizAnswer>());//TODO change new arraylist to something right
        }

    }
    public int getIndent(String filename){
       return context.getResources().getIdentifier(filename,"raw","com.example.luckynatrium.litgo");
    }
    private static class QuizQuestionPrototype{
        public String question;
        public String evidence;
        public ArrayList<QuizAnswer> answers;

        public QuizQuestionPrototype() {
            answers = new ArrayList<>();
        }
        public void reset(){
            question = evidence = null;
            answers = new ArrayList<>();
        }
        public QuizQuestion getResult(){
            return new QuizQuestion(evidence,question,answers);
        }
    }
}
