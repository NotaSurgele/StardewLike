package com.farm.game.Map;

import com.farm.game.Components.AABBCollider;
import com.farm.game.Entity.Entity;

public class CollidingCell extends Entity {

    public CollidingCell(float x, float y) {
        _position.x = x;
        _position.y = y;
        _size.x = 16;
        _size.y = 16;
    }

    @Override
    public Entity create() {
        this.addComponent(new AABBCollider(this, "Collider"));
        return this;
    }

    @Override
    public void draw() {

    }

    @Override
    public void dispose() {

    }

    @Override
    protected void update() {

    }
}
