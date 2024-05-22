package com.mygdx.game.controller.item.activity.throwitem;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.common.constant.CharacterStatus;
import com.mygdx.game.controller.item.activity.Washing;
import com.mygdx.game.model.Player;
import com.mygdx.game.model.item.DynamicItem;
import com.mygdx.game.model.item.StaticItem;

import java.util.ArrayList;

public class ThrowItem {
    Washing washing;

    public ThrowItem(){
        washing = new Washing();
    }

    public void updatePosition(ArrayList<DynamicItem> dynamicItems, ArrayList<StaticItem> staticItems, Player player){
        if (player.getItemHolding()==null || player.getStatusHold() == 4) return;
        for (DynamicItem item : dynamicItems) {
            if (item.getName().equals(player.getItemHolding().getName())) {
                if (Gdx.input.isKeyJustPressed(Input.Keys.X) && player.getStatusHold()==2){
                    throwItem(item, dynamicItems, staticItems, player);
                }
                else{
                    item.setPosition(player.getX() + (player.getWidth() - item.getWidth()) / 2
                            , player.getY() + 1.5f * player.getHeight());
                }
                return;
            }
        }
    }
    public void throwItem(DynamicItem dynamicItem, ArrayList<DynamicItem> dynamicItems
            , ArrayList<StaticItem> staticItems, Player player) {
        if (player.getContainer() != null) {
            if(player.getContainer().getName().equals("dish-washing")){
                if(dynamicItem.getName().equals("dish")){
                    player.setIsCountingXPress(true);
                    if(player.getStatus() != CharacterStatus.CLEANING_DISH)
                        player.setFrameIndex(-1);
                    washing.washingDish(dynamicItem, dynamicItems, player, true);
                }
                else{
                    player.setValidThrow(false);
                    player.setPositionThrew(new Vector2(player.getX(), player.getY()));
                }
            }
            else if(player.getContainer().getNumber() > 0){
                ThrowInStatic throwInStatic = new ThrowInStatic();
                throwInStatic.throwStaticItem(dynamicItem, staticItems, dynamicItems, player);
            }
            else{
                player.setValidThrow(false);
                player.setPositionThrew(new Vector2(player.getX(), player.getY()));
            }
        } else {
            ThrowFloor throwFloor = new ThrowFloor();
            throwFloor.throwFloor(dynamicItem, player, staticItems);
        }
    }
}
