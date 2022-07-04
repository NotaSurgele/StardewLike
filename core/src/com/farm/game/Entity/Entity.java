package com.farm.game.Entity;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.Components.Component;

import java.util.ArrayList;

public abstract class Entity implements IEntity {

    protected Sprite _sprite = new Sprite();
    protected Texture _texture = null;
    protected Vector2 _velocity = new Vector2();
    protected Vector2 _position = new Vector2();
    protected Vector2 _size = null;
    protected String _name = null;
    protected ArrayList<Component> _components = new ArrayList<>();

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
    public IEntity addComponent(Component component) {
        if (component != null)
            _components.add(component);
        return this;
    }

    @Override
    public boolean removeComponent(Component component) {
        return _components.remove(component);
    }

    @Override
    public ArrayList<Component> getComponents() {
        return _components;
    }

    @Override
    public Component getComponent(String componentName) {
        for (Component c : _components) {
            if (c.getName().equalsIgnoreCase(componentName))
                return c;
        }
        return null;
    }

    @Override
    public Component getComponent(Component component) {
        for (Component c : _components) {
            if (c.getName().equalsIgnoreCase(component.getName()))
                return c;
        }
        return null;
    }

    @Override
    public abstract void create();

    @Override
    public abstract void draw();

    @Override
    public abstract void dispose();

    protected abstract void update();
}
