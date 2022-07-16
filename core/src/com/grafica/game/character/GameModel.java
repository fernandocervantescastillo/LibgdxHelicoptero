package com.grafica.game.character;

import com.badlogic.gdx.scenes.scene2d.Stage;

public class GameModel {
    private Player player;
    private Stage balas;
    private Stage helicoptero;

    public GameModel(){
        balas = new Stage();
        helicoptero = new Stage();
    }

    public Player getPlayer(){
        return player;
    }

    public Stage getBalas(){
        return balas;
    }

    public void addBala(Personaje bala){
        balas.addActor(bala);
    }

    public void addPlayer(Player player){
        this.player = player;
        helicoptero.addActor(player);
    }

    public Stage getHelicoptero(){
        return helicoptero;
    }

    public boolean intersectan(Personaje p1, Personaje p2){
        if((p1.getX()<=p2.getX() && p1.getX()+p1.getWidth()>=p2.getX()) || (p1.getX()<=p2.getX()+p2.getWidth() && p1.getX()+p1.getWidth()>=p2.getX()+p2.getWidth())){
            if((p1.getY()<=p2.getY() && p1.getY()+p1.getHeight()>=p2.getY()) || (p1.getY()<=p2.getY()+p2.getHeight() && p1.getY()+p1.getHeight()>=p2.getY()+p2.getHeight())){
                return true;
            }
        }
        return false;
    }
}
