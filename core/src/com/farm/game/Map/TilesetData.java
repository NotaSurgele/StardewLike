package com.farm.game.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class TilesetData {

    public int tileWidth = 0;
    public int tileHeight = 0;
    public int tileCount = 0;
    public int imageHeight = 0;
    public int imageWidth = 0;
    public int column = 0;
    public int gid = 0;
    public TextureRegion tileSet = null;

    public TilesetData(int tw, int th, int tc, int iHeight, int iWidth, int c, int startid, TextureRegion set) {
        tileWidth = tw;
        tileHeight = th;
        tileCount = tc;
        imageHeight = iHeight;
        imageWidth = iWidth;
        column = c;
        gid = startid;
        tileSet = set;
    }

    public boolean contain(int oldTileCount, int id) {
        int value = tileCount;
        System.out.println(oldTileCount + " " + value + " " + id);
        return id >= oldTileCount && id <= tileCount;
    }
}
