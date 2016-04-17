package de.earley.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.earley.TheWall;

public class Wall {
	
	public static float speed = .05f;

	private Texture wallTex;

	public float x = 1;

	//temp until proper top/middle/bottom is implemented
	boolean flipped = Math.random() < 0.5;

	

	public Wall() {
		// TODO replace with options from textureatlas/spritesheet
		wallTex = new Texture(Gdx.files.internal("wall.png"));
	}

	public void render(SpriteBatch batch) {
		// update
		update();

		// render;
		// keep the wall proportions
		int width = wallTex.getWidth() * TheWall.HEIGHT / wallTex.getHeight();
		batch.draw(wallTex, x * TheWall.WIDTH, 0, width, TheWall.HEIGHT, 0, 0, wallTex.getWidth(), wallTex.getHeight(), false, flipped);
	}

	private void update() {
		speed += Gdx.graphics.getDeltaTime() / 1000;
		x -= Gdx.graphics.getDeltaTime() * speed;
		
	}

}
