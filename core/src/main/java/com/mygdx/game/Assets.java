package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/*********************************
 Created by Fabian Oraze on 09.04.20
 *********************************/

public class Assets {

    public static Texture join;
    public static Texture joinPressed;

    public static void load(){
        join = new Texture(Gdx.files.internal("join_button.png"));
        joinPressed = new Texture(Gdx.files.internal("join_button_pressed.png"));
    }


}
