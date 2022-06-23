package com.farm.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public interface IEntity {

    IEntity setSprite(Sprite sprite);
    IEntity setPosition(Vector2 position);
    IEntity setName(String name);
    IEntity setVelocity(Vector2 velocity);
    IEntity setSize(Vector2 size);

    Sprite getSprite();
    Texture getTexture();
    String getName();
    Vector2 getPosition();
    Vector2 getVelocity();
    Vector2 getSize();

    void update(SpriteBatch batch);
    void update();
    void draw();
    void dispose();
}
