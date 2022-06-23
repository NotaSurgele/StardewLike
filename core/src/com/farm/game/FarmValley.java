package com.farm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farm.game.Game.Player;

public class FarmValley extends ApplicationAdapter {

	Player player = new Player();

	@Override
	public void create () {
		player.create();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		player.draw();
	}
	
	@Override
	public void dispose () {

	}
}
