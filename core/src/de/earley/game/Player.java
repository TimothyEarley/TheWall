package de.earley.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player {

	private float x = 10, y = 10;
	private float dy = 0;
	private boolean jumping, doubleJump;

	private int LEFT = Keys.A, RIGHT = Keys.D, JUMP = Keys.SPACE;

	private Texture tex = new Texture(Gdx.files.internal("player.png"));;

	public void render(SpriteBatch sb) {

		float delta = Gdx.graphics.getDeltaTime();

		delta *= 1000;

		if (jumping) {

			y += dy;
			dy -= delta / 20;
			if (y <= 0) {
				jumping = false;
				doubleJump = false;
				y = 0;
				dy = 0;
			}

		}

		if (Gdx.input.isKeyJustPressed(JUMP) && !doubleJump) {
			if (jumping) doubleJump = true;
			else jumping = true;
			dy = 17; //TODO += ?
		}

		if (Gdx.input.isKeyPressed(LEFT))
			x -= delta;
		if (Gdx.input.isKeyPressed(RIGHT))
			x += delta;

		System.out.println(x+ ", " + y);
		sb.draw(tex, x, y, 40, 40);
		
	}

}
