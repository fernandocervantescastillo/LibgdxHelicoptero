package com.grafica.game.character;

import com.badlogic.gdx.Gdx;

public class Enemy extends Personaje {
    public int enemyType;
    public boolean invincible;

    public Enemy(){

    }

    public void update(float dt){

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);

        if(getX() + getWidth()<0)
            remove();

        if(getY()<0){
            velocity.y = Math.abs(velocity.y);
        }

        if(getY() + getHeight() > Gdx.graphics.getHeight())
            velocity.y = Math.abs(velocity.y) * -1;




    }
}
