package com.farm.game.SceneManager;

import com.farm.game.Entity.Entity;

import java.util.ArrayList;

public abstract class Scene implements IScene {

    protected static final ArrayList<Entity> _entities = new ArrayList<>();

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
    public abstract void create();

    @Override
    public abstract void render();

    @Override
    public abstract void dispose();
}
