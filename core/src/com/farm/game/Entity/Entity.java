package com.farm.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Entity implements IEntity {

    protected Sprite _sprite;
    protected Texture _texture;
    protected Vector2 _velocity;
    protected Vector2 _position;
    protected Vector2 _size;
    protected String _name;

    @Override
    public IEntity setSprite(Sprite sprite) {
        _sprite = sprite;
        return this;
    }

    @Override
    public IEntity setName(String name) {
        _name = name;
        return this;
    }

    @Override
    public IEntity setPosition(Vector2 position) {
        _position = position;
        return this;
    }

    @Override
    public IEntity setVelocity(Vector2 velocity) {
        _velocity = velocity;
        return this;
    }

    @Override
    public IEntity setSize(Vector2 size) {
        _size = size;
        return this;
    }

    @Override
    public Sprite getSprite() {
        return _sprite;
    }

    @Override
    public Texture getTexture() {
        return _texture;
    }

    @Override
    public String getName() {
        return _name;
    }


    @Override
    public Vector2 getPosition() {
        return _position;
    }

    @Override
    public Vector2 getVelocity() {
        return _velocity;
    }

    @Override
    public Vector2 getSize() {
        return _size;
    }

    @Override
    public void update(SpriteBatch batch) {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void dispose() {

    }
}
