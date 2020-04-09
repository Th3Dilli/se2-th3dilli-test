package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/*********************************
 Created by Fabian Oraze on 09.04.20
 *********************************/

public class MainGame extends Game {

    private Game game;
    public SpriteBatch batcher;

    @Override
    public void create() {
        batcher = new SpriteBatch();
        Assets.load();
        setScreen(new TitleScreen(this));


    }

    @Override
    public void render() {
        super.render();
    }
}
