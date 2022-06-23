package com.farm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farm.game.Game.Player;
import com.farm.game.Input.Input;

public class FarmValley extends ApplicationAdapter {

	Player player = new Player();

	@Override
	public void create () {
		player.create();
		Gdx.input.setInputProcessor(new Input());
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);
		player.draw();
		if (Input.getKeyPressed() != Input.Key.NONE)
			System.out.println("");
	}
	
	@Override
	public void dispose () {

	}
}
