package com.farm.game.Components;

public abstract class Component implements IComponent {

    protected String _name = null;

    private Component() {};

    public Component(String componentName) {
        _name = componentName;
    }

    @Override final
    public String getName() {
        return _name;
    }

    @Override
    public abstract void create(String componentName);

    @Override
    public abstract void update();

    @Override
    public abstract void draw();
}
