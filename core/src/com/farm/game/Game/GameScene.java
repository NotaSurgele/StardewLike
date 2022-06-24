package com.farm.game.Game;

import com.farm.game.Entity.Entity;
import com.farm.game.SceneManager.Scene;

public class GameScene extends Scene {

    @Override
    public void create() {
        Core.addEntity(new Player());

        for (Entity e : _entities)
            e.create();
    }

    @Override
    public void render() {
        for (Entity e : _entities) {
            e.draw();
        }
    }

    @Override
    public void dispose() {
        for (Entity e : _entities)
            e.dispose();
    }
}
