package com.mygdx.game;

import com.badlogic.gdx.*;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.math.Rectangle;
import org.w3c.dom.Text;

/*********************************
 Created by Fabian Oraze on 09.04.20
 *********************************/

public class TitleScreen extends ScreenAdapter {

    MainGame game;
    OrthographicCamera guiCam;
    Rectangle joinBounds;
    Vector3 touchPoint;

    public TitleScreen(MainGame game) {
        this.game = game;
        guiCam = new OrthographicCamera(320, 480);
        guiCam.position.set(320 / 2, 480 / 2, 0);
        joinBounds = new Rectangle(160 - 150, 200 + 18, 100, 40);
        touchPoint = new Vector3();

    }

    public void update() {

        if (Gdx.input.justTouched()) {
            guiCam.unproject(touchPoint.set(Gdx.input.getX(), Gdx.input.getY(), 0));

            if (joinBounds.contains(touchPoint.x, touchPoint.y)) {
                System.out.println("good");

                game.setScreen(new MyGdxGame(game));
                return;
            }
        }


    }

    public void draw() {
        GL20 gl = Gdx.gl;
        gl.glClearColor(0, 0, 0, 1);
        gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        guiCam.update();
        game.batcher.setProjectionMatrix(guiCam.combined);

        game.batcher.enableBlending();
        game.batcher.begin();
        game.batcher.draw(Assets.join, 160 - 150, 200 + 18, 100, 40);
        game.batcher.end();
    }

    @Override
    public void render(float delta) {
        update();
        draw();

    }


}
