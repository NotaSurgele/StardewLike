package com.farm.game.Components;

import com.badlogic.gdx.math.Rectangle;
import com.farm.game.Entity.Entity;

public class AABBCollider extends Component {

    private final Rectangle _hitbox = new Rectangle();

    public AABBCollider(Entity entity, String name) {
        super(entity, name);
    }

    @Override
    public void create(String componentName) {
        _name = componentName;
        _hitbox.setPosition(_entity.getPosition().x, _entity.getPosition().y);
        _hitbox.setSize(_entity.getSize().x, _entity.getSize().y);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw() {

    }
}
