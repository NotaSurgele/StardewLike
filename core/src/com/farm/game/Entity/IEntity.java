package com.farm.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.Components.Component;

import java.util.ArrayList;

public interface IEntity {

    IEntity setSprite(Sprite sprite);
    IEntity setPosition(Vector2 position);
    IEntity setName(String name);
    IEntity setVelocity(Vector2 velocity);
    IEntity setVelocity(float x, float y);
    IEntity setSize(Vector2 size);
    IEntity setTexture(Texture texture);
    IEntity setTexture(TextureRegion textureRegion);
    IEntity addComponent(Component component);

    ArrayList<Component> getComponents();
    Component getComponent(Component component);
    Component getComponent(String componentName);
    Sprite getSprite();
    Texture getTexture();
    String getName();
    Vector2 getPosition();
    Vector2 getVelocity();
    Vector2 getSize();

    boolean removeComponent(Component component);

    Entity create();
    void draw();
    void dispose();
}
