package com.farm.game.Map;

public abstract class GMap implements IGMap {

    String _config = null;

    public GMap(String configFile) {
        _config = configFile;
    }

    private GMap() {}

    @Override
    public void create() {

    }

    @Override
    public void load() {

    }

    @Override
    public void draw() {

    }

    @Override
    public void dispose() {

    }
}
