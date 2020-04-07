package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.utils.Array;

public class MyGdxGame extends ApplicationAdapter {
	public PerspectiveCamera cam;
	public Model model;
	public ModelInstance instance;
	public ModelBatch modelBatch;
	public Environment environment;
	public CameraInputController camController;
	public AssetManager assets;
	public boolean loading;
	public Array<ModelInstance> instances = new Array<ModelInstance>();
	
	@Override
	public void create () {
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
		modelBatch = new ModelBatch();

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		cam.position.set(10f, 80f, 10f);
		cam.lookAt(0,0,0);
		cam.near = 1f;
		cam.far = 300f;
		cam.update();
		camController = new CameraInputController(cam);
		Gdx.input.setInputProcessor(camController);
		assets = new AssetManager();
		assets.load("board.g3gdb", Model.class);
		assets.load("player.g3db", Model.class);
		loading = true;
	}

	@Override
	public void render () {
		if (loading && assets.update())
			doneLoading();
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

		modelBatch.begin(cam);
		modelBatch.render(instances, environment);
		modelBatch.end();
		camController.update();
	}
	private void doneLoading() {
		Model board = assets.get("board.g3db", Model.class);
		ModelInstance boardInstance = new ModelInstance(board);
		instances.add(boardInstance);

		Model player = assets.get("player.g3db", Model.class);

		ModelInstance playerInstance = new ModelInstance(player);
		playerInstance.transform.setTranslation(46,2f,46);
		instances.add(playerInstance);

		ModelInstance playerInstance2 = new ModelInstance(player);
		playerInstance2.transform.setTranslation(-46,2f,-46);
		instances.add(playerInstance2);

		ModelInstance playerInstance3 = new ModelInstance(player);
		playerInstance3.transform.setTranslation(-46,2f,46);
		instances.add(playerInstance3);

		ModelInstance playerInstance4 = new ModelInstance(player);
		playerInstance4.transform.setTranslation(46,2f,-46);
		instances.add(playerInstance4);

		loading = false;
	}
	
	@Override
	public void dispose () {
		model.dispose();
		modelBatch.dispose();
	}
}
