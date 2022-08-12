package com.farm.game.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.farm.game.Game.Core;

public class TestMap extends GMap {

    MapData _ground = null;

    public TestMap(String configFile, String name) {
        super(configFile, name);
    }

    @Override
    public void create() {
        _ground = new MapData(_config);
        _ground.create();
        float x = 0;
        float y = 0;

        int tileWidth = _ground.getTileWidth();
        int tileHeight = _ground.getTileHeight();

        for (int[][] layer : layersArray) {

            for (int i = layer.length - 1; i >= 0; i--) {
                for (int j = 0; j < layer[i].length; j++) {
                    if (_ground.isCollidingCells(layer[i][j])) {
                        Core.addEntity(new CollidingCell(x, y).create());
                    }
                    x += tileWidth;
                }
                x = 0;
                y += tileHeight;
            }
            x = 0;
            y = 0;
        }
    }

    @Override
    public void draw() {
        float x = 0;
        float y = 0;

        int tileWidth = _ground.getTileWidth();
        int tileHeight = _ground.getTileHeight();

        for (int[][] layer : layersArray) {
            for (int i = layer.length - 1; i >= 0; i--) {
                for (int j = 0; j < layer[i].length; j++) {
                    TextureRegion texture = _ground.getTileTextureByID(layer[i][j]);

                    if (texture != null)
                        Core.getInstance().currentScene().batch.draw(texture, x, y);
                    x += tileWidth;
                }
                x = 0;
                y += tileHeight;
            }
            x = 0;
            y = 0;
        }
    }

    @Override
    public void dispose() {
    }
}
