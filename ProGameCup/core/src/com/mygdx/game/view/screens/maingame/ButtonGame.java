package com.mygdx.game.view.screens.maingame;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.SpaceGame;
import com.mygdx.game.common.constant.GameConstant;
import com.mygdx.game.common.constant.ItemConstant;
import com.mygdx.game.model.item.DynamicItem;
import com.mygdx.game.view.draw.text.DrawText;
import com.mygdx.game.view.draw.ui.DrawButton;
import com.mygdx.game.view.screens.endgame.MainEndStory;
import com.mygdx.game.view.screens.maingame.multiplayer.MultiPlayer;
import com.mygdx.game.view.screens.maingame.singleplayer.SinglePlayer;
import com.mygdx.game.view.screens.mainmenu.MainMenuScreen;
import com.mygdx.game.view.screens.mainstory.MainStory;

import java.util.ArrayList;

public class ButtonGame {
    DrawButton drawButton;
    Texture resume, pause, home, homePress, replay, replayPress, musicOn, musicOff
            , buttonSpace, menuBar, menuBarPress;

    public ButtonGame(SpaceGame game){
        drawButton = new DrawButton(game);
        init();
    }
    public void init(){
        resume = new Texture("button/game/resume.png");
        pause = new Texture("button/game/pause.png");
        home = new Texture("button/game/home.png");
        homePress = new Texture("button/game/homePress.png");
        replay = new Texture("button/game/replay.png");
        replayPress = new Texture("button/game/replayPress.png");
        musicOn = new Texture("button/menu/musicOn.png");
        musicOff = new Texture("button/menu/musicOff.png");
        buttonSpace = new Texture("otherImage/ButtonSpace.png");    }

    public void drawPauseGame(SpaceGame game, SpriteBatch batch, float stateTime, DrawText drawText
            , MainEndStory mainEndStory){
        if (!drawButton.isPause)
            drawButton.drawPauseButton(resume, pause, (int) GameConstant.WINDOW_WIDTH - 70, 900);
        drawText.drawClock(game, batch, stateTime, 180, mainEndStory);
    }


    public void drawMenuBarSingle(MainMenuScreen mainMenuScreen, SinglePlayer singlePlayer){
        drawButton.drawMusicButton(musicOn, musicOff, 610, 470);

        drawButton.drawButtonGameSingle(home, homePress, 470, 470, ItemConstant.ICON_WIDTH,
                ItemConstant.ICON_HEIGHT, 2, mainMenuScreen, singlePlayer);

        drawButton.drawButtonGameSingle(replay, replayPress, 540, 470,
                ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT, 3, mainMenuScreen, singlePlayer);
        drawButton.drawPauseButton(resume, pause, 400, 470);
    }

    public void drawMenuBarMulti(MainMenuScreen mainMenuScreen, MultiPlayer multiPlayer){
        drawButton.drawMusicButton(musicOn, musicOff, 610, 470);

        drawButton.drawButtonGameMulti(home, homePress, 470, 470, ItemConstant.ICON_WIDTH,
                ItemConstant.ICON_HEIGHT, 2, mainMenuScreen, multiPlayer);

        drawButton.drawButtonGameMulti(replay, replayPress, 540, 470,
                ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT, 3, mainMenuScreen, multiPlayer);

        drawButton.drawPauseButton(resume, pause, 400, 470);

//=======
//    public void draw(SpaceGame game, SpriteBatch batch, float stateTime, DrawText drawText
//            , ArrayList<DynamicItem> dynamicItems, MainMenuScreen mainMenuScreen, MainStory mainStory, MainEndStory mainEndStory, int initTime){
//        newButton.drawPauseButton(resume, pause, (int) GameConstant.WINDOW_WIDTH - 70, 900
//                , ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT);
//        drawText.drawClock(dynamicItems, game, batch, stateTime, initTime, 460, 930, 2f, mainEndStory);
//        drawText.drawStaticText(batch, "X - Interact Items", 10, 30, 0.5f);
//
//    }
//    public void drawMenuBar(MainMenuScreen mainMenuScreen, MainStory mainStory, DrawText drawText){
//        newButton.drawMusicButton(musicOn, musicOff, 610, 470, ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT);
//        newButton.drawButton(home, homePress, 470, 470, ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT, 4, mainMenuScreen, mainStory, drawText);
//        newButton.drawButton(replay, replayPress, 540, 470, ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT, 1, mainMenuScreen, mainStory, drawText);
//        newButton.drawPauseButton(resume, pause, 400, 470, ItemConstant.ICON_WIDTH, ItemConstant.ICON_HEIGHT);
//>>>>>>> develop
    }
}
