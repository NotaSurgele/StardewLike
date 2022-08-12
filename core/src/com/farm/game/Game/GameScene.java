package com.farm.game.Game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.farm.game.Entity.Entity;
import com.farm.game.Map.TestMap;
import com.farm.game.SceneManager.Scene;

public class GameScene extends Scene {

    TestMap map = null;

    @Override
    public void create() {
        map = new TestMap("maps/FirstMap.json", "beginning");
        camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        batch = new SpriteBatch();
        map.createLayer();
        map.create();
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
        camera.update();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        map.draw();
        for (Entity e : _entities)
            e.draw();
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        for (Entity e : _entities)
            e.dispose();
    }
}
