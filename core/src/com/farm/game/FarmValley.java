package com.farm.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.farm.game.Entity.Player;
import com.farm.game.Time.Time;

public class FarmValley extends ApplicationAdapter {
	SpriteBatch batch;
	Player player;
	Time time;

	@Override
	public void create () {
		batch = new SpriteBatch();
		player = new Player();
		time = new Time();
	}

	@Override
	public void render () {

		ScreenUtils.clear(0, 0, 0, 1);
		batch.begin();
		player.update(batch);
		batch.end();
		time.update();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
