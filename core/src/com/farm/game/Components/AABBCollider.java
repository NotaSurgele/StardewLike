package com.farm.game.Components;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.farm.game.Entity.Entity;
import com.farm.game.Game.Core;

public class AABBCollider extends Component {

    private final Rectangle _hitbox = new Rectangle();
    private final ShapeRenderer shape = new ShapeRenderer();

    public AABBCollider(Entity entity, String name) {
        super(entity, name);
    }

    @Override
    public void create(String componentName) {
        _name = componentName;
    }

    @Override
    public void update() {
        _hitbox.setPosition(_entity.getPosition().x + (_entity.getVelocity().x * 4.5f), _entity.getPosition().y + (_entity.getVelocity().y * 4.5f));
        _hitbox.setSize(_entity.getSize().x, _entity.getSize().y);

        if (Core.DEBUG == 1) {
            shape.begin(ShapeRenderer.ShapeType.Line);
            shape.setColor(Color.RED);
            shape.rect(_hitbox.x, _hitbox.y, _hitbox.width, _hitbox.height);
            shape.end();
        }
        for (Entity e : Core.getInstance().currentScene().getSceneEntities()) {
            if (e != _entity) {
                Rectangle r = new Rectangle(e.getPosition().x, e.getPosition().y, e.getSize().x, e.getSize().y);

                if (_hitbox.overlaps(r))
                    _entity.setVelocity(0, 0);
            }
        }
    }
}
