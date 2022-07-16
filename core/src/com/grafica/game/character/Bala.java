package com.grafica.game.character;

import com.badlogic.gdx.Gdx;

public class Bala extends Personaje{

    @Override
    public void act(float delta) {
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);

        if(getX()<0 || getX() + getWidth() > Gdx.graphics.getWidth())
            remove();
        if(getY()<0 || getY() + getHeight() > Gdx.graphics.getHeight())
            remove();
    }
}
