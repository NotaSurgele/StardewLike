package com.farm.game.Components;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.farm.game.Entity.Entity;
import com.farm.game.Game.Core;
import com.farm.game.SceneManager.SceneManager;

public class AABBCollider extends Component {

    private final Rectangle _hitbox = new Rectangle();
    private ShapeRenderer shape;
    public AABBCollider(Entity entity, String name) {
        super(entity, name);
    }

    @Override
    public void create(String componentName) {
        _name = componentName;
    }

    @Override
    public void update() {
        _hitbox.setPosition(_entity.getPosition().x, _entity.getPosition().y);
        _hitbox.setSize(_entity.getSize().x, _entity.getSize().y);

        for (Entity e : Core.getInstance().currentScene().getSceneEntities()) {
            if (e != _entity) {
                Rectangle r = new Rectangle(e.getPosition().x, e.getPosition().y, e.getSize().x, e.getSize().y);

                if (_hitbox.contains(r)) {
                    System.out.println("hello world");
                }
            }
        }
    }
}
