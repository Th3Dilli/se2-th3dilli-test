package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ScreenAdapter {
	public PerspectiveCamera cam;
	public Model model;
	public ModelInstance instance;
	public ModelBatch modelBatch;
	public Environment environment;
	public CameraInputController camController;
	public AssetManager assets;
	public boolean loading;
	public Array<ModelInstance> instances = new Array<ModelInstance>();
	private MainGame game;
	private Hud hud;
    private SpriteBatch batch;
	public MyGdxGame(MainGame game) {
		this.game = game;
		this.hud = new Hud(game.batcher);
		create();

	}


	public void create () {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		modelBatch = new ModelBatch();
		 batch=new SpriteBatch();

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 80f, 10f);
		cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);
		assets = new AssetManager();
		assets.load("board.g3db", Model.class);
		assets.load("player.g3db", Model.class);
		loading = true;
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void render (float delta) {
		if (loading && assets.update())
			doneLoading();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(cam);
		modelBatch.render(instances, environment);
		modelBatch.end();
		drawHud();
		camController.update();

		//Texture t=new Texture(Gdx.files.internal("menu.png"));
		//batch.begin();
		//batch.draw(t,  0,0);
		//batch.end();
	}


	public void drawHud(){
		game.batcher.setProjectionMatrix(hud.stage.getCamera().combined);
		game.batcher.enableBlending();
		game.batcher.begin();
		game.font.draw(game.batcher, "Balance: ", 20, 140);
		game.font.draw(game.batcher, Hud.getFormattedMoney(), 20,60);
		game.batcher.end();
	}


	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	private void doneLoading() {
		Model board = assets.get("board.g3db", Model.class);
		ModelInstance boardInstance = new ModelInstance(board);
		instances.add(boardInstance);
		Model player = assets.get("player.g3db", Model.class);
		ModelInstance playerInstance = new ModelInstance(player);
		playerInstance.transform.setTranslation(50,2f,50);
		instances.add(playerInstance);
		loading = false;

	}

	@Override
	public void dispose () {
		model.dispose();
		modelBatch.dispose();
	}
}
