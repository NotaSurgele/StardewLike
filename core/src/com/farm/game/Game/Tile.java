package com.farm.game.Game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.Components.AABBCollider;
import com.farm.game.Entity.Entity;
import com.farm.game.Time.Time;

public class Tile extends Entity {

    SpriteBatch batch;

    @Override
    public void create() {
        this.setSprite(new Sprite()).setTexture(new Texture("door_anim_opening_f0.png")).
                setPosition(new Vector2(100, 300)).setSize(new Vector2(32, 32));
        batch = new SpriteBatch();
        this.addComponent(new AABBCollider(this, "Collider"));
    }

    @Override
    public void draw() {
        _sprite.setPosition(_position.x, _position.y);
        batch.begin();
        _sprite.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {

    }

    @Override
    protected void update() {

    }
}
