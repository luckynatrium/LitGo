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

    public QuizQuestion downloadQuestion(String filename){

        try{
            InputStream inputStream = context.getResources().openRawResource(getIndent(filename));
            BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
            String str="";
            String question="";
            String evidence="";
            ArrayList<QuizAnswer> answers=new ArrayList<>();
            while((str=br.readLine())!=""){ //Вопросы разделяем пустой строкой

                String resource =str.substring(2);

                if(str.startsWith("Q"))
                    question= resource;

                if(str.startsWith("C"))
                    answers.add(new QuizAnswer(resource,true));

                if(str.startsWith("W"))
                    answers.add(new QuizAnswer(resource,false));
                if(str.startsWith("E"))
                    evidence=resource;

            }
            return new QuizQuestion(evidence,question,answers);

        }
        catch (java.io.IOException fe){
            fe.printStackTrace();
            return new QuizQuestion("error","Invalid question download",new ArrayList<QuizAnswer>());//TODO change new arraylist to something right
        }

    }
    public int getIndent(String filename){
       return context.getResources().getIdentifier(filename,"raw","com.example.luckynatrium.litgo");
    }

}
