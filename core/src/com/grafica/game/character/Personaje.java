package com.grafica.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Personaje extends Actor {
    public Vector2 velocity;
    public float stateTime;
    public TextureRegion frame;
    public Animation animation;
    public int lives;
    protected boolean dead;
    public int type;

    public void setAnimation(String path, float frameDuration, int cols, int rows){
        animation = new Animation(frameDuration, getSprites(path, cols, rows));
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        frame = (TextureRegion) animation.getKeyFrame( stateTime, true );
        batch.draw(frame, getX(), getY(), getWidth(), getHeight());
    }

    @Override
    public void act(float delta) {
        stateTime = stateTime + delta;
    }

    private TextureRegion[] getSprites(String file, int cols, int rows )
    {
        Texture texture = new Texture( Gdx.files.internal(file) );
        TextureRegion[][] tmp = TextureRegion.split( texture, texture.getWidth() / cols, texture.getHeight() / rows);
        TextureRegion[] Frames = new TextureRegion[cols * rows];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Frames[index++] = tmp[i][j];
            }
        }
        return Frames;
    }
}
