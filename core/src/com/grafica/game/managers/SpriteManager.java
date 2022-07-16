package com.grafica.game.managers;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.grafica.game.character.Personaje;

public class SpriteManager {
    Stage stage;

    public SpriteManager(Stage stage){
        this.stage = stage;
    }

    public void addCharacter(Personaje character){
        stage.addActor(character);
    }

    public void handleInput(){

    }

    public void updateEnemies(float dt){

    }

    public void updateItems(float dt){

    }

    public void updatePlayer(float dt){

    }

    public void update(float dt){
        updateEnemies(dt);
        updateItems(dt);
        updatePlayer(dt);
    }
}
