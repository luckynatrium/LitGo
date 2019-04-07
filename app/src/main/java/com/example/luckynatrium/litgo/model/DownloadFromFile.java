package com.example.luckynatrium.litgo.model;

import android.content.Context;

import com.example.luckynatrium.litgo.Classes.LitCharacter;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class DownloadFromFile {

    //Array of file names, where characters are saved
    final String[] CHARACTER_FILES = {"coblomov.txt"};
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
            return null;
        }

    }
    public int getIndent(String filename){
       return context.getResources()
               .getIdentifier(filename,"raw","com.example.luckynatrium.litgo");

    }


    public ArrayList<LitCharacter> get_All_Characters()
    {
        ArrayList<LitCharacter> res = new ArrayList<>();
        for (String filename:CHARACTER_FILES) {
               ArrayList<LitCharacter> temp = get_Character_from_file(filename);
                res.addAll(temp);
        }
        return res;
    }

    public ArrayList<LitCharacter> get_Character_from_file(String filename)
    {
        try
        {
            InputStream inputStream = context.getResources().openRawResource(getIndent(filename));
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String str="";
            ArrayList<LitCharacter> characters = new ArrayList<>();
            LitCharacterPrototype litCharacter_prot = new LitCharacterPrototype();
            while((str = br.readLine()) != null)
            {
                switch (str.charAt(0)){
                    case 'N':
                        litCharacter_prot.name = str.substring(2);
                        break;
                    case 'W':
                        litCharacter_prot.writing_name = str.substring(2);
                        break;
                    case 'D':
                        litCharacter_prot.desription = str.substring(2);
                        break;
                    case 'P':
                        litCharacter_prot.pic_path = str.substring(2);
                        break;
                    case 'C'://Знак конца героя
                       characters.add(litCharacter_prot.getResult());
                       litCharacter_prot.reset();
                       break;
                }
            }
            return characters;
        }
        catch(java.io.IOException fe)
        {
            fe.printStackTrace();
            return null;
        }


    }

    private static class LitCharacterPrototype
    {
        public  String name, writing_name, pic_path, desription;
        public LitCharacterPrototype(){}
        public void reset()
        {
            name = writing_name = pic_path = desription = null;
        }
        public LitCharacter getResult()
        {
            return new LitCharacter(name,writing_name,pic_path,desription);
        }
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
