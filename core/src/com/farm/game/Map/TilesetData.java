package com.farm.game.Map;

public class TilesetData {

    public int tileWidth = 0;
    public int tileHeight = 0;
    public int tileCount = 0;
    public int imageHeight = 0;
    public int imageWidth = 0;
    public int column = 0;

    public TilesetData(int tw, int th, int tc, int iHeight, int iWidth, int c) {
        tileWidth = tw;
        tileHeight = th;
        tileCount = tc;
        imageHeight = iHeight;
        imageWidth = iWidth;
        column = c;
    }
}
