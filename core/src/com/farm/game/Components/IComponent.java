package com.farm.game.Components;

public interface IComponent {

    String getName();

    void create(String componentName);
    void update();
    void draw();
}
