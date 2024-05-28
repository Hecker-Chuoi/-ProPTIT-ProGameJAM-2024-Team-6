package com.mygdx.game.view.screens.endgame;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SpaceGame;
import com.mygdx.game.common.constant.MapConstant;
import com.mygdx.game.controller.item.setup.SetRemainItem;
import com.mygdx.game.controller.item.setup.SetStaticItem;
import com.mygdx.game.model.item.DynamicItem;
import com.mygdx.game.model.item.StaticItem;
import com.mygdx.game.view.draw.map.DrawMap;
import com.mygdx.game.view.screens.endgame.DrawItems.Draw;
import com.mygdx.game.view.screens.endgame.DrawMom.Mom;

import java.util.ArrayList;

public class MapEndGame implements Screen {
    ArrayList<StaticItem> staticItems;
    ArrayList<DynamicItem> dynamicItems;
    SetRemainItem setRemainItem;
    SetStaticItem setStaticItem;
    SpaceGame game;
    SpriteBatch batch;
    Mom mother;
    Draw draw;
    Texture player, mom, chat;
    float stateTime;

    DrawMap drawMap;
    public MapEndGame(SpaceGame game, ArrayList<DynamicItem> dynamicItems){
        this.game = game;
        batch = game.getBatch();
        this.dynamicItems = dynamicItems;
        setStaticItem = new SetStaticItem();
        staticItems = new ArrayList<>();
        drawMap = new DrawMap();
        draw = new Draw();
    }
    @Override
    public void show() {
        player = new Texture("animations/main-char/idle-endgame.png");
        mom = new Texture("animations/mom/mom-walking.png");
        chat = new Texture("alert/note.png");

        mother = new Mom(mom, dynamicItems);
        setStaticItem.setStatic(staticItems);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.113f, 0.102f, 0.16f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        batch.begin();
        drawMap.drawMap(batch);
        draw.draw(dynamicItems, staticItems, batch);
        batch.draw(player, MapConstant.POS_MAP_Y + 150, MapConstant.POS_MAP_Y + 220,
                32, 58);
        mother.draw(chat,game, batch, delta);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}