package com.farm.game.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TestMap extends GMap {

    MapData _ground = null;
    SpriteBatch batch = null;

    public TestMap(String configFile, String name) {
        super(configFile, name);
    }

    @Override
    public void create() {
        _ground = new MapData("maps/FirstMap.json");
        _ground.create();
        batch = new SpriteBatch();
    }

    @Override
    public void draw() {
        batch.begin();
        float x = 0;
        float y = 0;

        int tileWidth = _ground.getTileWidth();
        int tileHeight = _ground.getTileHeight();

        for (int[][] layer : layersArray) {
            for (int i = layer.length - 1; i >= 0; i--) {
                for (int j = 0; j < layer[i].length; j++) {
                    TextureRegion texture = _ground.getTileTextureByID(layer[i][j]);

                    batch.draw(texture, x, y);
                    x += tileWidth;
                }
                x = 0;
                y += tileHeight;
            }
            x = 0;
            y = 0;
        }
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
