package com.farm.game.SceneManager;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farm.game.Entity.Entity;

import java.util.ArrayList;

public abstract class Scene implements IScene {

    protected static final ArrayList<Entity> _entities = new ArrayList<>();
    public SpriteBatch batch = null;

    @Override final
    public boolean addEntity(Entity entity) {
        if (entity == null)
            return false;
        for (Entity e : _entities) {
            if (e == entity)
                return false;
        }
        return _entities.add(entity);
    }

    @Override final
    public boolean removeEntity(Entity entity) {
        return _entities.remove(entity);
    }

    @Override
    public ArrayList<Entity> getSceneEntities() {
        return _entities;
    }
    public OrthographicCamera mainCamera = new OrthographicCamera();

    @Override
    public abstract void load();

    @Override
    public abstract void create();

    @Override final
    public void clear() {
        if (_entities.size() > 0)
            _entities.clear();
    }

    @Override
    public abstract void render();

    @Override
    public abstract void dispose();
}
