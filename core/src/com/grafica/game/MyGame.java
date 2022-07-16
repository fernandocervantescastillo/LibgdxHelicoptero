package com.grafica.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.grafica.game.screens.SplashScreen;
import static com.grafica.game.util.Constants.SCREEN_HEIGHT;
import static com.grafica.game.util.Constants.SCREEN_WIDTH;

public class MyGame extends Game {

	public SpriteBatch batch;
	public ShapeRenderer shapeRenderer;
	public BitmapFont font;
	public OrthographicCamera camara;
	public Viewport vista;

	@Override
	public void create() {
		batch = new SpriteBatch();
		shapeRenderer = new ShapeRenderer();
		font = new BitmapFont();

		camara = new OrthographicCamera();
		camara.position.set(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 0);
		camara.update();
		vista = new StretchViewport(SCREEN_WIDTH, SCREEN_HEIGHT, camara);
		setScreen(new SplashScreen(this));

		Gdx.graphics.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
	}

	@Override
	public void dispose() {
		super.dispose();
		batch.dispose();
		shapeRenderer.dispose();
		font.dispose();

	}
}
