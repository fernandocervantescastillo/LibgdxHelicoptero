package com.grafica.game.character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyAnimation {

    private Animation animation;
    private SpriteBatch spriteBatch;
    private TextureRegion frame;

    private float x, y;
    private float height, width;

    public float getX(){
        return x;
    }

    public float getY(){
        return y;
    }

    public float getHeight(){
        return height;
    }

    public float getWidth(){
        return width;
    }

    public void setX(float x){
        this.x = x;
    }

    public void setY(float y){
        this.y = y;
    }

    public void setHeight(float height){
        this.height = height;
    }

    public void setWidth(float width){
        this.width = width;
    }

    public void setAnimation(String path, float frameDuration, int cols, int rows){
        animation = new Animation(frameDuration, getSprites(path, cols, rows));
    }

    public MyAnimation(){
        spriteBatch = new SpriteBatch();
    }

    public void render(float stateTime){

        frame = (TextureRegion) animation.getKeyFrame( stateTime, true );

        spriteBatch.begin();
        spriteBatch.draw(frame, getX(), getY(), getWidth(), getHeight());
        spriteBatch.end();
    }

    public void dispose(){
        spriteBatch.dispose();
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
