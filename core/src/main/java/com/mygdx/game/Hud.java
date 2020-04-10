package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/*********************************
 Created by Fabian Oraze on 10.04.20
 *********************************/

public class Hud implements Disposable {

    public Stage stage;
    private Viewport viewport;

    //score && time tracking variables
    private float timeCount;
    private static Integer money;

    //Scene2D Widgets

    public Hud(SpriteBatch sb) {
        //define tracking variables
        money = 1000000;

        //setup the HUD viewport using a new camera seperate from gamecam
        //define stage using that viewport and games spritebatch
        viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
        stage = new Stage(viewport, sb);

    }


    @Override
    public void dispose() {
        stage.dispose();
    }


    public static Integer getMoney() {
        return money;
    }

    public static String getFormattedMoney(){
        String mon = Integer.toString(money);
        StringBuilder str = new StringBuilder();
        for (int i = mon.length()-1; i >= 0; i--) {
            if (i % 3 == 0 && i != mon.length()-1){
                str.append(".");
            }
            str.append(mon.charAt(i));
        }
        str.reverse();
        System.out.println(str.toString());
        return str.toString();

    }





}
