package com.farm.game.Map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TestMap extends GMap {

    TileSet _ground = null;
    SpriteBatch batch = null;

    public TestMap(String configFile, String name) {
        super(configFile, name);
    }

    @Override
    public void create() {
        _ground = new TileSet("maps/FirstMap.json");
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
            for (int i = 0; i < layer.length; i++) {
                for (int j = 0; j < layer[i].length; j++) {
                    TextureRegion texture = _ground.getTextureRegionFromId(layer[i][j]);

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
        /*_ground.draw();*/
    }

    @Override
    public void dispose() {
        batch.dispose();
    }
}
