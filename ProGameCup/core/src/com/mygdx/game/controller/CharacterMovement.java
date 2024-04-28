package com.mygdx.game.controller;

import com.mygdx.game.model.Character;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class CharacterMovement implements Movable, KeyListener {
    Direction direction;
    boolean up, down, left, right;

    @Override
    public void move(Character character) {
        if (left) {
            direction = Direction.LEFT;
        }
        if (right) {
            direction = Direction.RIGHT;
        }
        if (up) {
            direction = Direction.UP;
        }
        if (down) {
            direction = Direction.DOWN;
        }
        //up left
        if (up && left) {
            direction = Direction.UPLEFT;
        }
        //up right
        if (up && right) {
            direction = Direction.UPRIGHT;
        }
        //down left
        if (down && left) {
            direction = Direction.DOWNLEFT;
        }
        //down right
        if (down && right) {
            direction = Direction.DOWNRIGHT;
        }

        float x = character.getX();
        float y = character.getY();
        switch (direction) {
            case UP:
                x += character.getSTRAIGHT_SPEED();
                break;
            case DOWN:
                x -= character.getSTRAIGHT_SPEED();
                break;
            case LEFT:
                y -= character.getSTRAIGHT_SPEED();
                break;
            case RIGHT:
                y += character.getSTRAIGHT_SPEED();
                break;
            case UPLEFT:
                x += character.getDIAGONAL_SPEED();
                y -= character.getDIAGONAL_SPEED();
                break;
            case UPRIGHT:
                x += character.getDIAGONAL_SPEED();
                y += character.getDIAGONAL_SPEED();
                break;
            case DOWNLEFT:
                x -= character.getDIAGONAL_SPEED();
                y -= character.getDIAGONAL_SPEED();
                break;
            case DOWNRIGHT:
                x -= character.getDIAGONAL_SPEED();
                y += character.getDIAGONAL_SPEED();
                break;
        }
        character.setPosition(x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == Keys.UP){
            up = true;
        }
        if(e.getKeyCode() == Keys.DOWN){
            down = true;
        }
        if(e.getKeyCode() == Keys.LEFT){
            left = true;
        }
        if(e.getKeyCode() == Keys.RIGHT){
            right = true;
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == Keys.UP){
            up = true;
        }
        if(e.getKeyCode() == Keys.DOWN){
            down = true;
        }
        if(e.getKeyCode() == Keys.LEFT){
            left = true;
        }
        if(e.getKeyCode() == Keys.RIGHT){
            right = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == Keys.UP){
            up = false;
        }
        if(e.getKeyCode() == Keys.DOWN){
            down = false;
        }
        if(e.getKeyCode() == Keys.LEFT){
            left = false;
        }
        if(e.getKeyCode() == Keys.RIGHT){
            right = false;
        }
    }
}
