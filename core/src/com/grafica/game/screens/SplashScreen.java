package com.grafica.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.grafica.game.MyGame;
import com.grafica.game.character.Button;

import static com.grafica.game.util.Constants.*;

public class SplashScreen implements Screen {

    private Texture imgFondo;
    private MyGame myGame;
    private float dTime = 0;

    public SplashScreen(MyGame myGame){
        this.myGame = myGame;
        imgFondo = new Texture(Gdx.files.internal("splash.png"));
    }

    @Override
    public void resize(int width, int height) {
        myGame.vista.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1f,1f,1f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        myGame.batch.setProjectionMatrix(myGame.camara.combined);

        myGame.batch.begin();
        myGame.batch.draw(imgFondo, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
        myGame.batch.end();

        if(dTime>TIME_SPLASH){
            myGame.setScreen(new MainMenuScreen(myGame));
        }

        dTime = dTime + delta;
    }

    @Override
    public void hide() {
        imgFondo.dispose();
    }

    @Override
    public void dispose() {
    }
}
