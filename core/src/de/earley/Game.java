package de.earley;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import de.earley.game.Player;
import de.earley.game.Wall;

public class Game extends GameState {

	Array<Wall> walls;
	OrthographicCamera cam;
	SpriteBatch batch;
	Player player;
	// background texture
	Texture bg;

	@Override
	public void create() {
		bg = new Texture(Gdx.files.internal("bg.png"));
		player = new Player();
		cam = new OrthographicCamera();
		cam.setToOrtho(false, TheWall.WIDTH, TheWall.HEIGHT);
		walls = new Array<Wall>();
		batch = new SpriteBatch();
		walls.add(new Wall());
		Wall wall = new Wall();
		wall.x = 0.33f;
		walls.add(wall);
		wall = new Wall();
		wall.x = 0.66f;
		walls.add(wall);
	}

	@Override
	public void render() {

		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		cam.update();

		batch.setProjectionMatrix(cam.combined);

		// --------------------------------------------------------------
		batch.begin();

		// Bacjground
		batch.draw(bg, 0, 0, TheWall.WIDTH, TheWall.HEIGHT, 0, 0, bg.getWidth(), bg.getHeight(), false, false);

		// Walls
		for (int i = 0; i < walls.size; i++) {
			walls.get(i).render(batch);
		}

		//Player
		player.render(batch);

		batch.end();
		// --------------------------------------------------------------

		//update
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
