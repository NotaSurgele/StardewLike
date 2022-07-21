package com.farm.game.Game;

import com.farm.game.Entity.Entity;
import com.farm.game.Map.TestMap;
import com.farm.game.SceneManager.Scene;

public class GameScene extends Scene {

    TestMap map = null;

    @Override
    public void create() {
        map = new TestMap("maps/FirstMap.json", "beggining");

        map.create();
        Core.addEntity(new Player(20, 20));
        load();
    }

    @Override
    public void load() {
        map.load();
        for (Entity e : _entities)
            e.create();
    }

    @Override
    public void render() {
        map.draw();
        for (Entity e : _entities)
            e.draw();
    }

    @Override
    public void dispose() {
        for (Entity e : _entities)
            e.dispose();
    }
}
