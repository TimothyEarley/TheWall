package de.earley.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import de.earley.TheWall;

public class Wall {
	
	public static float speed = .05f;

	private Texture wallTex;

	public float x = 1, xHole = (float) Math.random(), yHole = (float) Math.random();
	
	

	public Wall() {
		// TODO replace with options from textureatlas/spritesheet
		wallTex = new Texture(Gdx.files.internal("trump2.jpg"));
	}

	public void render(SpriteBatch batch) {
		// update
		update();
		
		// render;		
		batch.draw(wallTex, x * TheWall.WIDTH, 0, 30, TheWall.HEIGHT, 0, 0, wallTex.getWidth(), wallTex.getHeight(), false, false);
	}

	private void update() {
		speed += Gdx.graphics.getDeltaTime() / 1000;
		x -= Gdx.graphics.getDeltaTime() * speed;
		
	}

}
