package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.Input.TextInputListener;

/*********************************
 Created by Fabian Oraze on 09.04.20
 *********************************/

public class TextInputHandler implements ApplicationListener {

    private SpriteBatch batch;
    private BitmapFont font;

    private String textInitial;
    private String dialogue;
    private String message;

    private boolean check;

    @Override
    public void create() {
        textInitial = "What is your name? ";
        dialogue = "Welcome";

        batch = new SpriteBatch();
        font = new BitmapFont();


        Gdx.input.getTextInput(new TextInputListener() {
            @Override
            public void input(String text) {
                message = "Hi " + text + " welcome to the server.";
                check = true;
            }

            @Override
            public void canceled() {
                message = "Good bye";
                check = false;
            }
        }, dialogue, textInitial, "Hint");
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if(check)
        {
            batch.begin();
            font.getData().setScale(3f);
            font.draw(batch, message, 100, 200);
            batch.end();
        }

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
