package com.farm.game.Map;

public interface IGMap {

    void create();
    boolean load();
    void draw();
    void dispose();

    String getMapName();
}
