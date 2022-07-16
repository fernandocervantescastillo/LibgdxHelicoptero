package com.grafica.game.character;

import com.badlogic.gdx.Gdx;

public class Muro  extends Personaje{

    @Override
    public void act(float delta) {
        setX(getX() + velocity.x * delta);
        setY(getY() + velocity.y * delta);

        if(getX() + getWidth()<0 || getX() > Gdx.graphics.getWidth())
            remove();
        if(getY() + getHeight()<0 || getY()> Gdx.graphics.getHeight())
            remove();
    }

}
