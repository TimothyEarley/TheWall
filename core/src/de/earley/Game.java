package de.earley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.utils.Array;

import de.earley.game.Player;
import de.earley.game.Wall;

public class Game extends GameState {

	Array<Wall> walls;
	OrthographicCamera cam;
	SpriteBatch batch;
	Player player;

	@Override
	public void create() {
		player = new Player();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, TheWall.WIDTH, TheWall.HEIGHT);
		walls = new Array<Wall>();
		batch = new SpriteBatch();
		walls.add(new Wall());
		Wall wall = new Wall();
		wall.x = 0.5f;
		walls.add(wall);
	}

	@Override
	public void render() {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();

		batch.setProjectionMatrix(cam.combined);
		batch.begin();
		for (int i = 0; i < walls.size; i++) {
			walls.get(i).render(batch);
		}

		player.render(batch);

		batch.end();

		boolean removed = false;
		for (int i = walls.size - 1; i >= 0; i--) {
			if (walls.get(i).x < 0) {
				removed = true;
				walls.removeIndex(i);
			}
		}
		if (removed)
			walls.add(new Wall());

	}

}
