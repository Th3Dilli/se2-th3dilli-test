package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*********************************
 Created by Fabian Oraze on 09.04.20
 *********************************/

public class MainGame extends Game {

    private Game game;
    public SpriteBatch batcher;
    public BitmapFont font;

    @Override
    public void create() {
        batcher = new SpriteBatch();
        font = new BitmapFont();
        font.getData().setScale(4,4);
        Assets.load();
        setScreen(new TitleScreen(this));


    }

    @Override
    public void render() {
        super.render();
    }
}
