package com.grafica.game.character;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import sun.security.util.Debug;

import static com.grafica.game.util.Constants.SCREEN_HEIGHT;

public class Button {
    private Texture fondo;
    private Texture fondoPress;
    private Texture margen;
    private Texture aux;
    private String text;
    private float aMargen;
    private boolean above;
    private boolean click;
    private GlyphLayout glyph;
    float x, y, width, height;

    public Button(String margen, String fondo, String fondoPress, String text, float x, float y, float width, float height){
        this.fondo = new Texture(Gdx.files.internal(fondo));
        this.fondoPress = new Texture(Gdx.files.internal(fondoPress));
        this.margen = new Texture(Gdx.files.internal(margen));
        aMargen = 4;
        this.text = text;
        above = false;
        click = false;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void mouseAbove(){
        above = true;
    }

    public void mouseFar(){
        above = false;
    }

    public void mouseClick(){
        click = true;
    }

    public void mouseRelease(){
        click = false;
    }

    public boolean isAbove(int posX, int posY){
        posY = SCREEN_HEIGHT - posY;
        if((posX < x) || (posX > x + width) || (posY < y) || (posY > y + height)){
            return false;
        }
        return true;
    }



    public void draw(SpriteBatch batch, BitmapFont font){
        batch.draw(margen, x, y, width, height);

        if(above)
            aux = fondoPress;
        else
            aux = fondo;
        batch.draw(aux, x + aMargen, y + aMargen, width - 2 * aMargen, height - 2 * aMargen);
        glyph = new GlyphLayout(font, text);
        font.draw(batch, text, x + (width - glyph.width) / 2.0f, y + (height - glyph.height) / 2.0f + 10);
    }

    public void dipose(){
        fondo.dispose();
        fondoPress.dispose();
        margen.dispose();
        aux.dispose();
    }

}
