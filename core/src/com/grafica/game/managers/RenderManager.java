package com.grafica.game.managers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class RenderManager {
    BitmapFont font;
    Stage stage;

    public void setStage(Stage stage){
        this.stage = stage;
    }

    public void drawFrame(){
        drawHub();
        stage.draw();
    }

    private void drawHub(){

    }
}
