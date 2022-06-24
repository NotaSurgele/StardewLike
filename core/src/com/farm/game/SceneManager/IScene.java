package com.farm.game.SceneManager;

import com.farm.game.Entity.Entity;

public interface IScene {

    boolean addEntity(Entity entity);
    boolean removeEntity(Entity entity);

    void create();
    void render();
    void dispose();
}
