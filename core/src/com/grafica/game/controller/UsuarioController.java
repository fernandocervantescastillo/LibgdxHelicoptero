package com.grafica.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.grafica.game.character.Bala;
import com.grafica.game.character.GameModel;
import com.grafica.game.character.Personaje;
import com.grafica.game.character.Player;
import com.grafica.game.eventos.KeyPressEventListener;
import jdk.nashorn.internal.runtime.Debug;

import javax.swing.*;
import java.util.logging.ConsoleHandler;

import static com.grafica.game.util.Constants.*;

public class UsuarioController extends Thread {
    private GameModel game;
    private Player player;
    private float time;

    public UsuarioController(GameModel game){
        this.game = game;
        player = game.getPlayer();
        time = 0;
    }


    public void moverIzquierda(float delta){
        Player player = game.getPlayer();
        if(game.getPlayer().getX()- player.velocity.x * delta < 0)
            player.setX(0);
        else
            player.setX(player.getX() - player.velocity.x * delta);
    }

    public void moverDerecha(float delta){
        Player player = game.getPlayer();
        if(game.getPlayer().getX() + game.getPlayer().getWidth() + player.velocity.x * delta> SCREEN_WIDTH)
            game.getPlayer().setX(SCREEN_WIDTH - game.getPlayer().getWidth());
        else
            player.setX(player.getX() + player.velocity.x * delta);
    }

    public void moverArriba(float delta){
        Player player = game.getPlayer();
        if(game.getPlayer().getY() + game.getPlayer().getHeight() + player.velocity.y * delta> SCREEN_HEIGHT)
            game.getPlayer().setY(SCREEN_HEIGHT - game.getPlayer().getHeight());
        else
            player.setY(player.getY() + player.velocity.y * delta);
    }

    public void moverAbajo(float delta){
        Player player = game.getPlayer();
        if(game.getPlayer().getY()- player.velocity.y * delta < 0)
            player.setY(0);
        else
            player.setY(player.getY() - player.velocity.y * delta);
    }

    public void agregarBala1(float delta){
        Bala bullet;
        bullet = new Bala();
        bullet.setAnimation("rojo.png", 1f, 1, 1);
        bullet.setX(game.getPlayer().getX() + game.getPlayer().getWidth() * 0.8f);
        bullet.setY(game.getPlayer().getY() + game.getPlayer().getHeight() * 0.1f);
        bullet.setWidth(20);
        bullet.setHeight(5);
        bullet.velocity = new Vector2(VELOCIDAD_BALA_1,0);
        game.addBala(bullet);
    }

    public void agregarBala2(float delta){
        Bala bullet;
        bullet = new Bala();
        bullet.setAnimation("b2.png", 1f, 1, 1);
        bullet.setX(game.getPlayer().getX() + game.getPlayer().getWidth() * 0.8f);
        bullet.setY(game.getPlayer().getY() + game.getPlayer().getHeight() * 0.1f);
        bullet.setWidth(34);
        bullet.setHeight(20);
        bullet.velocity = new Vector2(VELOCIDAD_BALA_2,0);
        game.addBala(bullet);
    }

    public void run() {
        try{
            while (true){
                eventoTeclado(0f);
            }
        }catch (Exception e){

        }
    }

    public void eventoTeclado(float delta){
        time = time + delta;
        if(Gdx.input.isKeyPressed(Input.Keys.A)){
            moverIzquierda(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){
            moverAbajo(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            moverArriba(delta);
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)){
            moverDerecha(delta);
        }

        if(Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            if(time>INTERVALO_ENTRE_BALAS) {
                agregarBala1(delta);
                time = 0;
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT)){
            if(time>INTERVALO_ENTRE_BALAS){
            agregarBala2(delta);
            time = 0;
            }
        }

    }

}
