package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;

public class UserScreen implements Screen {

    private Game game;
    private Stage stage;
    private Table table;
    static String name;

    public UserScreen(final Game g){
        game=g;
        stage= new Stage ();
        table = new Table();
        table.setWidth(stage.getWidth());
        table.align(Align.center|Align.top);
        table.setPosition(0,Gdx.graphics.getHeight());

        Gdx.input.setInputProcessor(stage);
        Skin skin=new Skin(Gdx.files.internal("uiskin.json"));
        TextButton btn1=new TextButton("START",skin,"default");
        TextButton btn2=new TextButton("BACK",skin,"default");


        btn1.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new MyGdxGame((MainGame) game));
            }

        });
        btn2.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y){
                game.setScreen(new LoginScreen((MainGame) game));
            }

        });
        //Label label = new Label("USERNAME:", skin);
        TextField usernameTextField = new TextField("", skin);

        table.setColor(1,0,0,1);
        table.padTop(250);
        //table.add(label).width(Gdx.graphics.getWidth()/2).height(50);

        //table.add(usernameTextField).width(200);

        table.add(btn1).padBottom(50).width(Gdx.graphics.getWidth()/2).height(100);
        table.row();
        table.add(btn2).padBottom(50).width(Gdx.graphics.getWidth()/2).height(100);
        stage.addActor(table);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 05.f, 0.555f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        stage.act(delta);
        stage.draw();
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
