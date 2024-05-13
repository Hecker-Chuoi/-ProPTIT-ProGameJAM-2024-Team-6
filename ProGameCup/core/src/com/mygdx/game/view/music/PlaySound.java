package com.mygdx.game.view.music;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlaySound {
    private static PlaySound instance;
    AssetManager assetManager;
    Music music;
    boolean isMusicOn;
    SpriteBatch batch;
    public PlaySound(SpriteBatch batch){
        this.batch = batch;
        assetManager = new AssetManager();
        loadMusic();
    }
    public static PlaySound getInstance(SpriteBatch batch) {
        if (instance == null) {
            instance = new PlaySound(batch);
        }
        return instance;
    }

    public void loadMusic() {
        assetManager.load("music/SmoothSailing.mp3", Music.class);
        assetManager.finishLoading();
        music = assetManager.get("music/SmoothSailing.mp3", Music.class);
        music.setLooping(true);
        music.setVolume(0.2f);
        music.play();
        isMusicOn = true;
    }

    public void stopMusic(){
        music.stop();
    }
    public void playMusic(){
        music.play();
    }


    public void dispose(){
        music.dispose();
        assetManager.dispose();
    }
}
