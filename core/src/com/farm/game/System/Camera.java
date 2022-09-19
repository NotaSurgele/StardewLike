package com.farm.game.System;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;
import com.farm.game.Entity.Entity;
import com.farm.game.Time.Time;

public class Camera extends OrthographicCamera {

    public void followEntity(Entity entity, float smoothness)
    {
        position.lerp(new Vector3(entity.getPosition().x, entity.getPosition().y, 0), smoothness * Time.deltaTime);
    }

    public void followCoord(float x, float y, float smoothness)
    {
        position.lerp(new Vector3(x, y, 0), smoothness * Time.deltaTime);
    }
}
