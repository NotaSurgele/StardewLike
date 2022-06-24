package com.farm.game.Game;

import com.farm.game.Entity.Entity;
import com.farm.game.SceneManager.Scene;
import com.farm.game.SceneManager.SceneManager;
import org.graalvm.compiler.api.replacements.Snippet;

public class Core {

    private static Core instance = null;
    private static final SceneManager sceneManager = new SceneManager();

    private Core() {

    }

    public static Core getInstance() {
        if (instance == null)
            instance = new Core();
        return instance;
    }

    public static boolean addScene(Scene s) {
        return sceneManager.addScene(s);
    }

    public static Scene popScene() {
        return sceneManager.popScene();
    }

    public static boolean removeScene(Scene s) {
        return sceneManager.removeScene(s);
    }

    public static boolean addEntity(Entity entity) {
        return sceneManager.addEntity(entity);
    }

    public static boolean removeEntity(Entity entity) {
        return sceneManager.removeEntity(entity);
    }

    public void create(@Snippet.NonNullParameter Scene s) {
        sceneManager.addScene(s);
        sceneManager.create();
    }

    public void create() {
        sceneManager.create();
    }

    public void draw() {
        sceneManager.draw();
    }

    public void dispose() {
        sceneManager.dispose();
    }
}
