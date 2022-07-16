package com.grafica.game.managers;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class ResourceManager {
    public static AssetManager assets = new AssetManager();

    public void loadAllResoruces(){

    }

    public static boolean update(){
        return assets.update();
    }

    public void loadSounds(){

    }

    public static TextureRegion getRegion(String string){
        return null;
    }

    public static Array<TextureAtlas.AtlasRegion> getRegions(String name){
        return null;
    }

    public static Sound getSound(String name){
        return null;
    }
}
