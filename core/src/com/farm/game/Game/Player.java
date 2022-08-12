package com.farm.game.Game;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.farm.game.Components.AABBCollider;
import com.farm.game.Entity.Entity;
import com.farm.game.SpriteHandler.Animator;
import com.farm.game.Input.Input;
import com.farm.game.StateManager.IState;
import com.farm.game.StateManager.StateManager;
import com.farm.game.Time.Time;

public class Player extends Entity {

    Animator idle;
    StateManager stateManager;
    float stateTime = 0;
    float speed = 200f;

    public Player(float x, float y) {
        _position.x = x;
        _position.y = y;
    }

    @Override
    public Entity create() {
        idle = Animator.initializeAnimation(idle, "knight_idle_spritesheet.png", 6, 1, .07f);
        this.setSprite(new Sprite()).setTexture(idle.getAnimationFrames()[0]).setSize(new Vector2(50, 50));
        stateManager = new StateManager();
        createStates();
        this.addComponent(new AABBCollider(this));
        return null;
    }

    private void setComponent() {
    }

    private void createStates() {
        stateManager.pushState(
            () -> {
                if (_velocity.x == 0 && _velocity.y == 0)
                    idle.playAnimationToSprite(_sprite, stateTime, true);
            },
            "Idle"
        );
    }

    private void handleInput() {
        if (Input.isKeyPressed(Input.Key.W))
            _velocity.y = 1;
        else if (Input.isKeyPressed(Input.Key.S))
            _velocity.y = -1;
        else
            _velocity.y = 0;
        if (Input.isKeyPressed(Input.Key.D))
            _velocity.x = 1;
        else if (Input.isKeyPressed(Input.Key.A))
            _velocity.x = -1;
        else
            _velocity.x = 0;
        stateManager.play("Idle");
    }

    @Override
    protected void update() {
        stateTime += Time.deltaTime;
        _position.x += _velocity.x * speed * Time.deltaTime;
        _position.y += _velocity.y * speed * Time.deltaTime;

        Core.getInstance().currentScene().camera.position.lerp(new Vector3(_position.x, _position.y, 0), 3f * Time.deltaTime);
        handleInput();
        setPosition(_position);
    }

    @Override
    public void draw() {
        update();
        _sprite.draw(Core.getInstance().currentScene().batch);
    }

    @Override
    public void dispose() {
    }
}
