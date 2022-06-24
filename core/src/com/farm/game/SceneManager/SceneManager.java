package com.farm.game.SceneManager;

import com.farm.game.Entity.Entity;

import java.util.Stack;

public class SceneManager {

    private final Stack<Scene> _scenes = new Stack<>();

    public boolean addScene(Scene scene) {
        if (scene == null)
            return false;
        return _scenes.add(scene);
    }

    public Scene popScene() {
        if (_scenes.empty())
            return null;
        return _scenes.pop();
    }

    public boolean removeScene(Scene scene) {
        return _scenes.remove(scene);
    }

    public boolean addEntity(Entity entity) {
        if (_scenes.empty())
            return false;
        return _scenes.firstElement().addEntity(entity);
    }

    public boolean removeEntity(Entity entity) {
        if (_scenes.empty())
            return false;
        return _scenes.firstElement().removeEntity(entity);
    }

    public void create() {
        if (_scenes.isEmpty())
            return;
        _scenes.firstElement().create();
    }

    public void draw() {
        if (_scenes.isEmpty())
            return;
        _scenes.firstElement().render();
    }

    public void dispose() {
        if (_scenes.isEmpty())
            return;
        _scenes.firstElement().dispose();
    }
}
