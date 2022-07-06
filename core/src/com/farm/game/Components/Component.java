package com.farm.game.Components;

import com.farm.game.Entity.Entity;

public abstract class Component implements IComponent {

    protected String _name = null;
    Entity _entity = null;

    private Component() {};

    public Component(Entity entity, String name) {
        _entity = entity;
        _name = name;
    }

    @Override final
    public String getName() {
        return _name;
    }

    @Override
    public abstract void create(String componentName);

    @Override
    public abstract void update();
    
}
