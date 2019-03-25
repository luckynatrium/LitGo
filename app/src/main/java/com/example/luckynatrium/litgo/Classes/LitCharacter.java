package com.example.luckynatrium.litgo.Classes;

public class LitCharacter {
    private String _name, _writing_name, _pic_path, _desription;

    public LitCharacter(){}

    public LitCharacter(String name, String writing_name, String pic_path,String desription)
    {
        name = _name;
        writing_name = _writing_name;
        pic_path = _pic_path;
        desription = _desription;
    }

    public String get_name() {
        return _name;
    }

    public String get_desription() {
        return _desription;
    }

    public String get_pic_path() {
        return _pic_path;
    }

    public String get_writing_name() {
        return _writing_name;
    }


}

