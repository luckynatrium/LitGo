package com.example.luckynatrium.litgo.Classes;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;

import java.util.ArrayList;

public abstract class PlayerProfile {

    private String nickname;
    private ImageView avatar;
    private ArrayList<LitCharacter> unlock_character;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void addUnlockCharacter (LitCharacter litCharacter)
    {
        unlock_character.add(litCharacter);
    }

}
