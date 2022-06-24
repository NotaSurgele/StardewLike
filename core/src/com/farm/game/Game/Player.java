package com.farm.game.Game;

import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.Entity.Entity;
import com.farm.game.SpriteHandler.Animator;
import com.farm.game.Time.Time;
import com.farm.game.Input.Input;

public class Player extends Entity {

    Animator idle;
    SpriteBatch batch;
    float stateTime = 0;

    @Override
    public void create() {
        idle = Animator.initializeAnimation(idle, "knight_idle_spritesheet.png", 6, 1, .07f);
        this.setSprite(new Sprite()).setTexture(idle.getAnimationFrames()[0]).
                    setPosition(new Vector2(0, 0)).setSize(new Vector2(50, 50));
        batch = new SpriteBatch();
    }

    private void handleInput() {
    }

    @Override
    protected void update() {
        stateTime += Gdx.graphics.getDeltaTime();

        if (Input.isKeyPressed(Input.Key.F))
            System.out.println("key F pressed");
    }

    @Override
    public void draw() {
        update();
        batch.begin();
        idle.playAnimationToSprite(_sprite, stateTime, true);
        _sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
