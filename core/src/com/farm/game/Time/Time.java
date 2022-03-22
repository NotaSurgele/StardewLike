package com.farm.game.Time;

import com.badlogic.gdx.Gdx;

public class Time {

    public static float deltaTime = 0f;

    public Time() {}

    public void update() {
        deltaTime = Gdx.graphics.getDeltaTime();
    }
}
