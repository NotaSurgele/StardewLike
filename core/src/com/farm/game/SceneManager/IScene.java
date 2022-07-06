package com.farm.game.SceneManager;

import com.farm.game.Entity.Entity;

import java.util.ArrayList;

public interface IScene {

    boolean addEntity(Entity entity);
    boolean removeEntity(Entity entity);
    ArrayList<Entity> getSceneEntities();

    void load();
    void create();
    void clear();
    void render();
    void dispose();
}
