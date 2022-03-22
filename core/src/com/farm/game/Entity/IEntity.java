package com.farm.game.Entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector;
import com.badlogic.gdx.math.Vector2;

public interface IEntity {

    void setSprite(Sprite sprite);

    Sprite getSprite();

    void setName(String name);

    String getName();

    void setPosition(Vector2 position);

    void setPostion(float x, float y);

    Vector2 getPosition();

    void Move();

    void setMoveSpeed(float moveSpeed);

    float getMoveSpeed();

    void update(SpriteBatch batch);

    void update();

    void dispose();
}
