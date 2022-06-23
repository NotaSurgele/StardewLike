package com.farm.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity implements IEntity {

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
        _sprite.setPosition(_position.x, _position.y);
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
        _sprite.setSize(_size.x, _size.y);
        return this;
    }

    @Override
    public IEntity setTexture(Texture texture) {
        _texture = texture;
        _sprite.setTexture(_texture);
        _sprite.setRegion(_texture);
        return this;
    }

    @Override
    public IEntity setTexture(TextureRegion textureRegion) {
        _texture = textureRegion.getTexture();
        _sprite.setTexture(_texture);
        _sprite.setRegion(_texture);
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
    public abstract void create();

    protected abstract void update();

    @Override
    public abstract void draw();

    @Override
    public abstract void dispose();
}
