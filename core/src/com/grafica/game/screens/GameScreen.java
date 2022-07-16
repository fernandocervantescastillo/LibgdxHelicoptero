package com.grafica.game.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.grafica.game.MyGame;
import com.grafica.game.character.GameModel;
import com.grafica.game.character.Player;
import com.grafica.game.controller.DespachadorController;
import com.grafica.game.controller.UsuarioController;

import static com.grafica.game.util.Constants.*;

public class GameScreen implements Screen {

    private GameModel gameModel;
    private MyGame myGame;
    private UsuarioController usuarioController;
    private DespachadorController despachadorController;

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

    public GameScreen(MyGame myGame){

        this.myGame = myGame;

        gameModel = new GameModel();
        Player helicoptero = new Player();
        helicoptero.setAnimation("helicoptero3.png", 0.03f, 1, 4);
        helicoptero.setX(25);
        helicoptero.setY(25);
        helicoptero.setWidth(200);
        helicoptero.setHeight(100);
        helicoptero.velocity = new Vector2(VELOCIDAD_PLAYER_X,VELOCIDAD_PLAYER_Y);
        gameModel.addPlayer(helicoptero);
        usuarioController = new UsuarioController(gameModel);
        despachadorController = new DespachadorController(gameModel);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.2520f,0.8150f,1f,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        despachadorController.despachar(delta);
        usuarioController.eventoTeclado(delta);


        gameModel.getBalas().draw();
        gameModel.getHelicoptero().draw();
    }

    @Override
    public void hide() {
        usuarioController.stop();
        despachadorController.stop();
    }

    @Override
    public void dispose() {
    }
}
