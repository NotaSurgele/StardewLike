package com.farm.game.Map;

public interface IGMap {

    void create();
    void createLayer();
    void draw();
    void dispose();

    String getMapName();
}
