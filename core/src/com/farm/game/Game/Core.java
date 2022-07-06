package com.farm.game.Game;

import com.farm.game.Components.Component;
import com.farm.game.Entity.Entity;
import com.farm.game.Input.Input;
import com.farm.game.SceneManager.Scene;
import com.farm.game.SceneManager.SceneManager;
import com.farm.game.Time.Time;

public class Core {

    private static Core instance = null;
    private final Time time = new Time();
    private static final SceneManager sceneManager = new SceneManager();

    public static int DEBUG = 0;

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

    public Scene currentScene() {
        return sceneManager.currentScene();
    }

    public void create(Scene s) {
        sceneManager.addScene(s);
        sceneManager.create();
    }

    public void create() {
        sceneManager.create();
    }


    public void draw() {
        time.update();
        sceneManager.draw();
        if (Input.isKeyPressed(Input.Key.F1))
            DEBUG += (DEBUG == 1) ? -1 : 1;
        for (Entity e : currentScene().getSceneEntities())
            for (Component c : e.getComponents())
                c.update();
    }

    public void dispose() {
        sceneManager.dispose();
    }
}
