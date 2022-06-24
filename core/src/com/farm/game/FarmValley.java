package com.farm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farm.game.Game.Core;
import com.farm.game.Game.GameScene;
import com.farm.game.Input.Input;

public class FarmValley extends ApplicationAdapter {

	Core core = Core.getInstance();

	@Override
	public void create () {
		Gdx.input.setInputProcessor(new Input());
		core.create(new GameScene());
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		core.draw();
	}
	
	@Override
	public void dispose () {
		core.dispose();
	}
}
