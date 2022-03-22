package com.farm.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.SpriteHandler.Animator;

public class Player implements IEntity {

    Sprite sprite;

    Animator idle;
    float stateTime;

    public Player() {
        idle = Animator.initializeAnimation(idle, "knight_idle_spritesheet.png", 6, 1, .07f);
        sprite = new Sprite();
        sprite.setRegion(idle.getAnimationFrames()[0]);
        sprite.setBounds(0, 0, 50, 50);
    }

    @Override
    public void setSprite(Sprite sprite) {

    }

    @Override
    public Sprite getSprite() {
        return null;
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setPosition(Vector2 position) {

    }

    @Override
    public Vector2 getPosition() {
        return null;
    }

    @Override
    public void Move() {

    }

    @Override
    public void setMoveSpeed(float moveSpeed) {

    }

    @Override
    public float getMoveSpeed() {
        return 0;
    }

    @Override
    public void update(SpriteBatch batch) {
        stateTime += Gdx.graphics.getDeltaTime();

        sprite.setPosition(0, 0);
        idle.playAnimationToSprite(sprite, stateTime, true);
        sprite.draw(batch);
    }

    @Override
    public void update() {

    }

    @Override
    public void dispose() {
        idle.dispose();
    }
}
