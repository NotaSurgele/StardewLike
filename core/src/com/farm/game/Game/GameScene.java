package com.farm.game.Game;

import com.badlogic.gdx.maps.tiled.TiledMap;
import com.farm.game.Entity.Entity;
import com.farm.game.Map.TileSet;
import com.farm.game.SceneManager.Scene;

public class GameScene extends Scene {

    TileSet _tileSet = null;

    @Override
    public void create() {
        _tileSet = new TileSet("maps/FirstMap.json");
        _tileSet.create();
        Core.addEntity(new Player(20, 20));
        load();
    }

    @Override
    public void load() {
        for (Entity e : _entities)
            e.create();
    }

    @Override
    public void render() {
        for (Entity e : _entities)
            e.draw();
        _tileSet.draw();
    }

    @Override
    public void dispose() {
        for (Entity e : _entities)
            e.dispose();
    }
}
