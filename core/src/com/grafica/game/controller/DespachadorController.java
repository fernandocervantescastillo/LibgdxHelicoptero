package com.grafica.game.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Array;
import com.grafica.game.character.*;
import com.grafica.game.eventos.KeyPressEventListener;
import sun.security.util.Debug;

import static com.grafica.game.util.Constants.*;

public class DespachadorController extends Thread{
    private GameModel gameModel;
    private float time, time1;
    int tt = 1;
    public DespachadorController(GameModel gameModel){
        this.gameModel = gameModel;
    }

    public void despachar(float delta){
        time = time + delta;
        time1 = time1 + delta;

        Personaje u, v;

        Array<Actor> array;
        array = gameModel.getBalas().getActors();
        gameModel.getHelicoptero().act(delta);

        if(time1 > 2){
            time1 = 0;
            agregarEnemigo();
        }

        if(time > 4){
            time = 0;
            tt = tt * -1;
            if(tt>0){
                agregarMuro2();
            }
            else{
                agregarMuro1();
            }
        }

        for(Actor p:array){
            u = (Personaje) p;
            u.act(delta);
        }

    }

    public void agregarMuro1(){
        //Muro arriba
        int h;
        int y;
        int x;
        x = Gdx.graphics.getWidth();
        h = (int) (Gdx.graphics.getHeight() * 0.2f +   Math.random() * Gdx.graphics.getHeight() * 0.5f);
        y = Gdx.graphics.getHeight() - h;
        agregarMuro(y, x, h);
    }

    public void agregarEnemigo(){
        int i;
        Enemy helicoptero = new Enemy();
        helicoptero.setAnimation("enemigo.png", 0.03f, 1, 4);
        helicoptero.setX(Gdx.graphics.getWidth());
        helicoptero.setY( (int) (Math.random() * (Gdx.graphics.getHeight() - 100)));
        helicoptero.setWidth(200);
        helicoptero.setHeight(100);
        if(Math.random()>0.5)
            i = -1;
        else
            i = 1;
        helicoptero.velocity = new Vector2(-VELOCIDAD_PLAYER_X,VELOCIDAD_PLAYER_Y * i);
        gameModel.addBala(helicoptero);
    }

    public void agregarMuro2(){
        //Muro abajo
        int h;
        int y;
        int x;
        x = Gdx.graphics.getWidth();
        h = (int) (Gdx.graphics.getHeight() * 0.2f +   Math.random() * Gdx.graphics.getHeight() * 0.5f);
        y = 0;
        agregarMuro(y, x, h);
    }

    public void agregarMuro(int y, int x, int height){
        Muro muro;
        muro = new Muro();

        muro.type = TYPE_MURO;
        muro.setAnimation("hormigon.png", 1f, 1, 1);
        muro.setX(x);
        muro.setY(y);
        muro.setWidth(100);
        muro.setHeight(height);
        muro.velocity = new Vector2(VELOCIDAD_MURO,0);
        gameModel.addBala(muro);
    }




    public void run() {
            try{
                while (true){
                    despachar(0.2f);
                }
            }catch (Exception e){

            }
    }

}
