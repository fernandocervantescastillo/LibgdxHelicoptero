package com.grafica.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.grafica.game.MyGame;
import com.grafica.game.character.Button;

import static com.grafica.game.util.Constants.SCREEN_HEIGHT;
import static com.grafica.game.util.Constants.SCREEN_WIDTH;

public class ConfigurationScreen implements Screen {

    private MyGame myGame;
    private Button play;
    private Button config;
    private Button exit;

    private boolean press;

    public ConfigurationScreen(MyGame myGame){
        this.myGame = myGame;
        play = new Button("azul.png", "rojo1.png", "rojo.png", "Jugar", 0.40f * SCREEN_WIDTH, 0.65f * SCREEN_HEIGHT, 0.20f * SCREEN_WIDTH, 0.1f * SCREEN_HEIGHT);
        config = new Button("azul.png", "rojo1.png", "rojo.png", "Configuración", 0.40f * SCREEN_WIDTH, 0.45f * SCREEN_HEIGHT, 0.20f * SCREEN_WIDTH, 0.1f * SCREEN_HEIGHT);
        exit = new Button("azul.png", "rojo1.png", "rojo.png", "Salir", 0.40f * SCREEN_WIDTH, 0.25f * SCREEN_HEIGHT, 0.20f * SCREEN_WIDTH, 0.1f * SCREEN_HEIGHT);
        press = false;
    }

    @Override
    public void show() {
        Gdx.graphics.setWindowedMode(SCREEN_WIDTH, SCREEN_HEIGHT);
    }



    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.25f, 0,0,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        int posX = Gdx.input.getX();
        int posY = Gdx.input.getY();

        if(play.isAbove(posX, posY))
            play.mouseAbove();
        else
            play.mouseFar();

        if(config.isAbove(posX, posY))
            config.mouseAbove();
        else
            config.mouseFar();

        if(exit.isAbove(posX, posY))
            exit.mouseAbove();
        else
            exit.mouseFar();


        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            if(press == false){
                press = true;
                if(play.isAbove(posX, posY)){
                    myGame.setScreen(new GameScreen(myGame));
                }
                if(config.isAbove(posX, posY)){
                }
                if(exit.isAbove(posX, posY)){
                    Gdx.app.exit();
                }
            }
        }



        myGame.batch.begin();
        dibujarMenu();
        myGame.batch.end();

    }

    private void dibujarMenu(){
        play.draw(myGame.batch, myGame.font);
        config.draw(myGame.batch, myGame.font);
        exit.draw(myGame.batch, myGame.font);
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
    public void hide() {
        play.dipose();
        config.dipose();
        exit.dipose();
    }

    @Override
    public void dispose() {

    }

}
