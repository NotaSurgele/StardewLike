package com.farm.game.Entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.SpriteHandler.Animator;
import com.farm.game.Time.Time;

public class Player implements IEntity {

    Vector2 position;
    Sprite sprite;

    final float moveSpeed = 300f;

    Animator idle;
    float stateTime;

    public Player() {
        idle = Animator.initializeAnimation(idle, "knight_idle_spritesheet.png", 6, 1, .07f);
        sprite = new Sprite();
        sprite.setRegion(idle.getAnimationFrames()[0]);
        sprite.setBounds(0, 0, 50, 50);
        position = new Vector2(0, 0);
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
        this.position.x = position.x;
        this.position.y = position.y;
        sprite.setPosition(position.x, position.y);
    }

    @Override
    public void setPostion(float x, float y) {
        this.position.x = x;
        this.position.y = y;
        sprite.setPosition(this.position.x, this.position.y);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public void Move() {
        float deltaY = 0f;
        float deltaX = 0f;

        deltaY = (Gdx.input.isKeyPressed(Input.Keys.W)) ? moveSpeed : deltaY;
        deltaY = (Gdx.input.isKeyPressed(Input.Keys.S)) ? -moveSpeed : deltaY;
        deltaX = (Gdx.input.isKeyPressed(Input.Keys.A)) ? -moveSpeed : deltaX;
        deltaX = (Gdx.input.isKeyPressed(Input.Keys.D)) ? moveSpeed : deltaX;

        position.x += deltaX * Time.deltaTime;
        position.y += deltaY * Time.deltaTime;
        sprite.setPosition(position.x, position.y);
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
        stateTime += Time.deltaTime;

        sprite.setPosition(0, 0);
        Move();
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
