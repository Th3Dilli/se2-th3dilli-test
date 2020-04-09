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
    Texture join;

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
    /*
    {
    private SpriteBatch batch;
    private BitmapFont font;

    private String textInitial;
    private String dialogue;
    private String message;
    private Game game;
    private Stage stage;

    private boolean check;

    public TitleScreen(Game game) {
        this.game = game;


    }


    @Override
    public void show() {
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
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (check) {
            batch.begin();
            font.getData().setScale(3f);
            font.draw(batch, message, 100, 200);
            batch.end();
        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
*/